package com.university.course_manager_api.dto;

import java.time.LocalDate;

public record StudentResponseDTO(
        Long id,
        String name,
        String email,
        LocalDate birthDate) {
}
