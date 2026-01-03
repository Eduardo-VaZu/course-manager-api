package com.university.course_manager_api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.university.course_manager_api.dto.CourseRequestDTO;
import com.university.course_manager_api.dto.CourseResponseDTO;
import com.university.course_manager_api.dto.StudentResponseDTO;
import com.university.course_manager_api.service.CourseService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<CourseResponseDTO> create(@Valid @RequestBody CourseRequestDTO request) {
        return new ResponseEntity<>(courseService.createCourse(request), HttpStatus.CREATED);
    }

    // Endpoint Estrella: Inscribir alumno
    // PUT /courses/{courseId}/enroll/{studentId}
    @PutMapping("/{courseId}/enroll/{studentId}")
    public ResponseEntity<CourseResponseDTO> enrollStudent(
            @PathVariable Long courseId,
            @PathVariable Long studentId) {
        return ResponseEntity.ok(courseService.enrollStudent(courseId, studentId));
    }

    // Listar alumnos de un curso
    // GET /courses/{courseId}/students
    @GetMapping("/{courseId}/students")
    public ResponseEntity<List<StudentResponseDTO>> getCourseStudents(@PathVariable Long courseId) {
        return ResponseEntity.ok(courseService.getEnrolledStudents(courseId));
    }
}
