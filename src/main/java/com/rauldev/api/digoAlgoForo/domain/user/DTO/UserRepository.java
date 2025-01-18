package com.rauldev.api.digoAlgoForo.domain.user.DTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.rauldev.api.digoAlgoForo.domain.user.User;

public interface UserRepository extends JpaRepository<User,Long> {
    UserDetails findByEmail(String Email);
    Page<User> findByActiveTrue(Pageable pagination);
}
