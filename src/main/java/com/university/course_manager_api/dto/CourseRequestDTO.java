package com.university.course_manager_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CourseRequestDTO(
        @NotBlank(message = "El título es obligatorio") String title,
        @NotBlank(message = "La descripción es obligatoria") String description,
        @NotNull @Positive(message = "Los créditos deben ser mayores a 0") Integer credits) {
}