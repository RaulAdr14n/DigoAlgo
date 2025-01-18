package com.rauldev.api.digoAlgoForo.domain.response.DTO;

import java.time.LocalDateTime;

import com.rauldev.api.digoAlgoForo.domain.response.Response;
import com.rauldev.api.digoAlgoForo.domain.topic.Topic;
import com.rauldev.api.digoAlgoForo.domain.user.User;

public record ResponseDataList(Long id, String message, Topic topic, LocalDateTime creationDate, User author, String solution) {
    public ResponseDataList(Response response){
        this(response.getId(), response.getMessage(), response.getTopic(), response.getCreationDate(), response.getAuthor(), response.getSolution());
    }
}
