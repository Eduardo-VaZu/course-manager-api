package com.university.course_manager_api.dto;

public record CourseResponseDTO(
        Long id,
        String title,
        String description,
        Integer credits) {
}