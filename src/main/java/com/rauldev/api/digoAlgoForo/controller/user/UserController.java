package com.rauldev.api.digoAlgoForo.controller.user;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import com.rauldev.api.digoAlgoForo.domain.user.User;
import com.rauldev.api.digoAlgoForo.domain.user.DTO.UserDataList;
import com.rauldev.api.digoAlgoForo.domain.user.DTO.UserDataResponse;
import com.rauldev.api.digoAlgoForo.domain.user.DTO.UserRegistrationData;
import com.rauldev.api.digoAlgoForo.domain.user.DTO.UserRepository;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<UserDataResponse> registerUser(@RequestBody @Valid UserRegistrationData userRegistrationData,
                                                         UriComponentsBuilder uriComponentsBuilder) {
        System.out.println("User");                                                  
        User user = userRepository.save(new User(userRegistrationData));
        UserDataResponse userDataResponse = new UserDataResponse(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
        URI url = uriComponentsBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(url).body(userDataResponse);
    }

    @GetMapping
    public ResponseEntity<Page<UserDataList>> listUsers(@PageableDefault(size = 2) Pageable pagination) {
        Page<User> usersPage = userRepository.findByActiveTrue(pagination);
        if (usersPage.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        Page<UserDataList> userDataListPage = usersPage.map(UserDataList::new);
        return ResponseEntity.ok(userDataListPage);
    }

}
