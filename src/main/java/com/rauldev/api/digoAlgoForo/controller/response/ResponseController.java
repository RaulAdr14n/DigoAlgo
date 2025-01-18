package com.rauldev.api.digoAlgoForo.controller.response;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import com.rauldev.api.digoAlgoForo.domain.response.Response;
import com.rauldev.api.digoAlgoForo.domain.response.ResponseRepository;
import com.rauldev.api.digoAlgoForo.domain.response.DTO.ResponseDataList;
import com.rauldev.api.digoAlgoForo.domain.response.DTO.ResponseDataResponse;
import com.rauldev.api.digoAlgoForo.domain.response.DTO.ResponseDataUpdate;
import com.rauldev.api.digoAlgoForo.domain.response.DTO.ResponseRegistrationData;
import com.rauldev.api.digoAlgoForo.domain.topic.Course;
import com.rauldev.api.digoAlgoForo.domain.topic.Topic;
import com.rauldev.api.digoAlgoForo.domain.topic.DTO.*;

import java.net.URI;

@RestController
@RequestMapping("/responses")
public class ResponseController {

    @Autowired
    private ResponseRepository responseRepository;

    @PostMapping
    public ResponseEntity<ResponseDataResponse> registerResponse(@RequestBody @Valid ResponseRegistrationData responseRegistrationData,
                                                               UriComponentsBuilder uriComponentsBuilder) {
        Response response = responseRepository.save(new Response(responseRegistrationData));
        ResponseDataResponse responseDataResponse = new ResponseDataResponse(
                response.getId(),
                response.getMessage(),
                response.getTopic(),
                response.getCreationDate(),
                response.getAuthor(),
                response.getSolution()
        );
        URI url = uriComponentsBuilder.path("/responses/{id}").buildAndExpand(response.getId()).toUri();
        return ResponseEntity.created(url).body(responseDataResponse);
    }

    @GetMapping
    public ResponseEntity<Page<ResponseDataList>> listResponses(@PageableDefault(size = 2) Pageable pagination) {
        Page<Response> responsesPage = responseRepository.findByActiveTrue(pagination);
        if (responsesPage.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        Page<ResponseDataList> responseDataLists = responsesPage.map(ResponseDataList::new);
        return ResponseEntity.ok(responseDataLists);
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateResponses(@RequestBody @Valid ResponseDataUpdate responseDataUpdate) {
        Response response = responseRepository.getReferenceById(responseDataUpdate.id());
        response.updateData(responseDataUpdate);
        return ResponseEntity.ok(new ResponseDataResponse(response.getId(), response.getMessage(), response.getTopic(), response.getCreationDate(), response.getAuthor(), response.getSolution()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteResponses(@PathVariable Long id) {
        Response response = responseRepository.getReferenceById(id);
        response.turnOffActive();
        return ResponseEntity.noContent().build();
    }
}
