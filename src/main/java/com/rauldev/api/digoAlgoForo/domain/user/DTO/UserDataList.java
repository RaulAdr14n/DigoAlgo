package com.rauldev.api.digoAlgoForo.domain.user.DTO;

import java.util.List;

import com.rauldev.api.digoAlgoForo.domain.user.Profile;
import com.rauldev.api.digoAlgoForo.domain.user.User;

public record UserDataList(Long id, String name, String email, String password, List<Profile> profiles) {
    public UserDataList(User user){
        this(user.getId(), user.getName(), user.getEmail(), user.getPassword(), user.getProfiles());
    }
}
