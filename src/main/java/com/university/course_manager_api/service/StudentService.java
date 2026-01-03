package com.university.course_manager_api.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.university.course_manager_api.domain.Student;
import com.university.course_manager_api.dto.StudentRequestDTO;
import com.university.course_manager_api.dto.StudentResponseDTO;
import com.university.course_manager_api.exceptions.BadRequestException;
import com.university.course_manager_api.mapper.StudentMapper;
import com.university.course_manager_api.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Transactional
    public StudentResponseDTO createStudent(StudentRequestDTO request) {
        if (studentRepository.existsByEmail(request.email())) {
            throw new BadRequestException("The email is already in use");
        }
        Student student = studentMapper.toEntity(request);
        Student saveStudent = studentRepository.save(student);
        return studentMapper.toResponse(saveStudent);
    }

    @Transactional(readOnly = true)
    public List<StudentResponseDTO> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(studentMapper::toResponse)
                .toList();
    }

}
