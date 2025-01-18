package com.rauldev.api.digoAlgoForo.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.rauldev.api.digoAlgoForo.domain.user.User;
import com.rauldev.api.digoAlgoForo.domain.user.DTO.UserDataAuthentication;
import com.rauldev.api.digoAlgoForo.infra.security.TokenService;
import com.rauldev.api.digoAlgoForo.infra.security.DTO.DataJWToken;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid UserDataAuthentication userDataAuthentication){
        Authentication authenticationToken = new UsernamePasswordAuthenticationToken(userDataAuthentication.email(), userDataAuthentication.password());
        var userAuthenticated = authenticationManager.authenticate(authenticationToken);
        var JWToken =  tokenService.generate((User) userAuthenticated.getPrincipal());
        return ResponseEntity.ok(new DataJWToken(JWToken));
    }
}
