package com.rauldev.api.digoAlgoForo.domain.response;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponseRepository extends JpaRepository<Response, Long> {
    Page<Response> findByActiveTrue(Pageable pagination);
}
