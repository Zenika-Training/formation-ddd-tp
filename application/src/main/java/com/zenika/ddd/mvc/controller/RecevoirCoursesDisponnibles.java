package com.zenika.ddd.mvc.controller;

import com.zenika.ddd.course.CourseEntity;
import com.zenika.ddd.course.service.SelectionnerCourseDomainService;
import com.zenika.ddd.mvc.adapter.CoursesMapper;
import com.zenika.ddd.mvc.dto.CoursesDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class RecevoirCoursesDisponnibles {

    private final SelectionnerCourseDomainService selectionnerCourseDomainService;
    private final CoursesMapper coursesMapper;

    @PostMapping("/courses")
    public ResponseEntity recevoirCoursesDisponnibles(@RequestBody List<CoursesDTO> coursesDTO) {
        log.info("Courses received: {}", coursesDTO);
        selectionnerCourseDomainService.selectCourse(coursesMapper.toCourseEntities(coursesDTO));
         return ResponseEntity.ok().build();
    }
}
