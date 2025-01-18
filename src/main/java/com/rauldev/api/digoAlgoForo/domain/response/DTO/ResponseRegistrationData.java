package com.rauldev.api.digoAlgoForo.domain.response.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

import com.rauldev.api.digoAlgoForo.domain.topic.Topic;
import com.rauldev.api.digoAlgoForo.domain.user.User;

public record ResponseRegistrationData (
        @NotBlank(message = "The response message is required.")
        String message,

        @NotNull(message = "The topic is required.")
        Topic topic,

        @NotNull(message = "The creation date is required.")
        LocalDateTime creationDate,

        @NotNull(message = "The author is required.")
        User author,

        @NotBlank(message = "The solution status is required.")
        String solution
){
}
