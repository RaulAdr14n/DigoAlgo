package com.rauldev.api.digoAlgoForo.domain.topic.DTO;

import com.rauldev.api.digoAlgoForo.domain.topic.CourseCategory;

import jakarta.validation.constraints.NotBlank;

public record CourseRegistrationData(
        @NotBlank(message = "The course name is required.")
        String name,

        @NotBlank(message = "The course category is required.")
        CourseCategory category
) {
}
