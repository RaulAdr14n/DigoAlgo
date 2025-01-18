package com.rauldev.api.digoAlgoForo.domain.topic.DTO;

import com.rauldev.api.digoAlgoForo.domain.topic.CourseCategory;

import jakarta.validation.constraints.NotBlank;

public record CourseDataUpdate(
        @NotBlank
        Long id,
        String name,
        CourseCategory category
) {
}
