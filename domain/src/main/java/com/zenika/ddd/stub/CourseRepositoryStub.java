package com.zenika.ddd.stub;

import com.zenika.ddd.course.CourseEntity;
import com.zenika.ddd.course.LivreurEntity;
import com.zenika.ddd.doc.Stub;
import com.zenika.ddd.port.CourseRepository;

import java.util.UUID;

@Stub
public class CourseRepositoryStub implements CourseRepository {

    @Override
    public void save(CourseEntity courseEntity) {
        System.out.println("CourseEntity saved: " + courseEntity);
    }

    @Override
    public LivreurEntity currentLivreur() {
        return LivreurEntity.builder()
                .id(UUID.fromString("f47b3b2d-4f3b-0000-0000-4b3f4b3f4b3f"))
                .nom("Outan")
                .prenom("Laurent")
                .email("laurent.outan@gmail.com")
                .adresse(null)
                .build();
    }
}
