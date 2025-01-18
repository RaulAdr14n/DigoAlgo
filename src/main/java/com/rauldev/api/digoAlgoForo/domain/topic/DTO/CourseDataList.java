package com.rauldev.api.digoAlgoForo.domain.topic.DTO;

import com.rauldev.api.digoAlgoForo.domain.topic.Course;
import com.rauldev.api.digoAlgoForo.domain.topic.CourseCategory;

public record CourseDataList(Long id, String name, CourseCategory category) {
    public CourseDataList(Course course){
        this(course.getId(),course.getName(), course.getCategory());
    }
}
