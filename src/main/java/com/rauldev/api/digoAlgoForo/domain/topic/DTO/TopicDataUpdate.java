package com.rauldev.api.digoAlgoForo.domain.topic.DTO;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.List;

import com.rauldev.api.digoAlgoForo.domain.response.Response;
import com.rauldev.api.digoAlgoForo.domain.topic.Course;
import com.rauldev.api.digoAlgoForo.domain.user.User;

public record TopicDataUpdate(
        @NotBlank
        Long id,
        String title,
        String message,
        LocalDateTime creationDate,
        User author,
        Course course,
        List<Response> responses
) {
}
