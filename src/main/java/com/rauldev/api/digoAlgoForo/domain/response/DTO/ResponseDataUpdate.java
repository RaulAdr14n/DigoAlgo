package com.rauldev.api.digoAlgoForo.domain.response.DTO;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

import com.rauldev.api.digoAlgoForo.domain.topic.Topic;
import com.rauldev.api.digoAlgoForo.domain.user.User;

public record ResponseDataUpdate(
        @NotBlank
        Long id,
        String message,
        Topic topic,
        LocalDateTime creationDate,
        User author,
        String solution
) {
}
