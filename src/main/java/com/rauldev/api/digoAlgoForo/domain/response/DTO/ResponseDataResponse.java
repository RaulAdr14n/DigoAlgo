package com.rauldev.api.digoAlgoForo.domain.response.DTO;

import java.time.LocalDateTime;

import com.rauldev.api.digoAlgoForo.domain.topic.Topic;
import com.rauldev.api.digoAlgoForo.domain.user.User;

public record ResponseDataResponse(
        Long id,
        String message,
        Topic topic,
        LocalDateTime creationDate,
        User author,
        String solution
) {
}
