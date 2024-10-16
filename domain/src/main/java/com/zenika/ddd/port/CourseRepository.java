package com.zenika.ddd.port;

import com.zenika.ddd.course.CourseEntity;
import com.zenika.ddd.course.LivreurEntity;

public interface CourseRepository {

    void save(CourseEntity courseEntity);

    LivreurEntity currentLivreur();
}
