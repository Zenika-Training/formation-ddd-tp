package com.brett.catalog.infrastructure;

import com.brett.catalog.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class JdbcReferenceRepository implements ReferenceRepository {

    @Autowired
    private JdbcClient jdbcClient;

    @Override
    public void add(Reference reference) {
        // Upsert into reference table
        String upsertReferenceSql = "MERGE INTO reference (code, name, description, price_per_day) KEY (code) VALUES (?, ?, ?, ?)";
        jdbcClient.sql(upsertReferenceSql)
                .param(reference.getCode().code())
                .param(reference.getName())
                .param(reference.getDescription())
                .param(reference.getPricePerDay().amount().amount())
                .update();

        // Upsert characteristics
        String upsertCharacteristicSql = "MERGE INTO reference_characteristic (code, characteristic, characteristic_value) KEY (code, characteristic) VALUES (?, ?, ?)";
        reference.getCharacteristics().forEach((key, value) ->
                jdbcClient.sql(upsertCharacteristicSql)
                        .param(reference.getCode().code())
                        .param(key)
                        .param(value)
                        .update()
        );
    }

    @Override
    public Reference get(Code code) {
        String query = """
                SELECT r.code, r.name, r.description, r.price_per_day, rc.characteristic, rc.characteristic_value
                FROM reference r
                LEFT JOIN reference_characteristic rc ON r.code = rc.code
                WHERE r.code = ?""";
        var rows = jdbcClient.sql(query)
                .param(code.code())
                .query()
                .listOfRows();
        if (rows.isEmpty()) {
            return null;
        }

        var characteristics = mapCharacteristics(rows);

        return mapReference(rows.get(0), characteristics);
    }

    private static Reference mapReference(Map<String, Object> row, Map<String, String> characteristics) {
        return new Reference(
                new Code((String) row.get("code")),
                (String) row.get("name"),
                (String) row.get("description"),
                new PricePerDay(new AmountInCents((int) row.get("price_per_day"))),
                characteristics
        );
    }

    @Override
    public List<Reference> findAll() {
        String query = """
                SELECT r.code, r.name, r.description, r.price_per_day, rc.characteristic, rc.characteristic_value
                FROM reference r
                LEFT JOIN reference_characteristic rc ON r.code = rc.code""";

        var rows = jdbcClient.sql(query)
                .query()
                .listOfRows();
        if (rows.isEmpty()) {
            return List.of();
        }

        var rowsByCode = rows.stream().collect(Collectors.groupingBy(row -> (String) row.get("code")));

        return rowsByCode.values().stream()
                .map(maps -> {
                    var characteristics = mapCharacteristics(maps);
                    return mapReference(maps.get(0), characteristics);
                })
                .toList();
    }

    private static Map<String, String> mapCharacteristics(List<Map<String, Object>> rows) {
        return rows.stream().map(
                        row -> Map.entry((String) row.get("characteristic"), (String) row.get("characteristic_value"))
                )
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));
    }
}
