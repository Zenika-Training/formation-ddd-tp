package com.brett.catalog.infrastructure;

import com.brett.catalog.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;

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

        var characteristics = rows.stream().map(
                    row -> Map.entry((String) row.get("characteristic"), (String) row.get("characteristic_value"))
                )
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));

        return new Reference(
                new Code((String) rows.get(0).get("code")),
                (String) rows.get(0).get("name"),
                (String) rows.get(0).get("description"),
                new PricePerDay(new AmountInCents((int)rows.get(0).get("price_per_day"))),
                characteristics
        );
    }
}
