package com.rauldev.api.digoAlgoForo.domain.topic.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.List;

import com.rauldev.api.digoAlgoForo.domain.response.Response;
import com.rauldev.api.digoAlgoForo.domain.topic.Course;
import com.rauldev.api.digoAlgoForo.domain.user.User;

public record TopicRegistrationData(
        @NotBlank(message = "The title is required.")
        String title,

        @NotBlank(message = "The message is required.")
        @Size(min = 10, max = 1000, message = "The message must be between 10 and 1000 characters.")
        String message,

        @NotNull(message = "The author is required.")
        User author,

        @NotNull(message = "The course is required.")
        Course course,

        @NotNull(message = "The creation date is required.")
        LocalDateTime creationDate,

        @NotNull(message = "The responses list is required.")
        List<Response> responses

) {
}
