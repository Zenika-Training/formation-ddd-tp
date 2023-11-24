package com.zenika.ddd.stub;

import com.zenika.ddd.course.CoursierEntity;
import com.zenika.ddd.port.RecupereCoursierService;
import com.zenika.ddd.doc.Stub;
import com.zenika.ddd.port.RecupereCoursierService;

import java.util.UUID;

@Stub
public class RecupereCoursierServiceStub implements RecupereCoursierService {

    @Override
    public CoursierEntity recupererCoursier() {
        return CoursierEntity.builder()
                .id(UUID.fromString("d0d7c2f0-4f1e-4b7a-9f6a-5e8b5b4b2b2e"))
                .nom("John")
                .prenom("Doe")
                .email("john.doe@domain.com")
                .build();
    }
}
