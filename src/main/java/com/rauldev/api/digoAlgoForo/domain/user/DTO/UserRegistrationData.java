package com.rauldev.api.digoAlgoForo.domain.user.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;

import com.rauldev.api.digoAlgoForo.domain.user.Profile;

public record UserRegistrationData(
        @NotBlank(message = "The name is required.")
        String name,

        @NotBlank(message = "The email is required.")
        @Email(message = "The email must be valid.")
        String email,

        @NotBlank(message = "The password is required.")
        @Size(min = 8, max = 20, message = "The password must be between 8 and 20 characters.")
        String password,

        @NotEmpty(message = "The profiles list cannot be empty.")
        List<Profile> profiles
) {
        public void logData() {
                System.out.println("UserRegistrationData: ");
                System.out.println("Name: " + name);
                System.out.println("Email: " + email);
                System.out.println("Password: " + password);
                System.out.println("Profiles: " + profiles);
            }
}
