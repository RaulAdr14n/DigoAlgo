package com.rauldev.api.digoAlgoForo.domain.topic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.rauldev.api.digoAlgoForo.domain.user.User;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Page<Course> findByActiveTrue(Pageable pagination);
}
