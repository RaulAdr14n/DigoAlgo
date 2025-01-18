package com.rauldev.api.digoAlgoForo.domain.topic.DTO;

import com.rauldev.api.digoAlgoForo.domain.topic.CourseCategory;

public record CourseDataResponse(
        Long id,
        String name,
        CourseCategory category
) {
}
