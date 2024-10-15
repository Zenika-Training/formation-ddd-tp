package com.zenika.ddd.mvc.controller;

import com.zenika.ddd.course.CourseEntity;
import com.zenika.ddd.mvc.adapter.CoursesMapper;
import com.zenika.ddd.mvc.dto.CoursesDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class RecevoirCoursesDisponnibles {

    private final List<CourseEntity> courseEntities;
    private final CoursesMapper coursesMapper;

    @PostMapping("/courses")
    public void recevoirCoursesDisponnibles(@RequestBody
    List<CoursesDTO> coursesDTO) {
        courseEntities.addAll(coursesMapper.toCourseEntities(coursesDTO));
    }
}
