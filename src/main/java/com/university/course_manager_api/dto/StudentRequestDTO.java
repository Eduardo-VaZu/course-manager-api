package com.university.course_manager_api.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

public record StudentRequestDTO(

        @NotBlank(message = "Name is required") String name,
        @NotBlank(message = "Email is required") @Email(message = "Email is required") String email,
        @NotNull(message = "Birth date is required") @Past(message = "Birth date is required") LocalDate birthDate) {

}
