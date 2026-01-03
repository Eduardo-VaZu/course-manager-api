package com.university.course_manager_api.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.university.course_manager_api.domain.Course;
import com.university.course_manager_api.domain.Student;
import com.university.course_manager_api.dto.CourseRequestDTO;
import com.university.course_manager_api.dto.CourseResponseDTO;
import com.university.course_manager_api.dto.StudentResponseDTO;
import com.university.course_manager_api.exceptions.BadRequestException;
import com.university.course_manager_api.exceptions.ResourceNotFoundException;
import com.university.course_manager_api.mapper.CourseMapper;
import com.university.course_manager_api.mapper.StudentMapper;
import com.university.course_manager_api.repository.CourseRepository;
import com.university.course_manager_api.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final CourseMapper courseMapper;
    private final StudentMapper studentMapper;

    @Transactional
    public CourseResponseDTO createCourse(CourseRequestDTO request) {
        if (courseRepository.existsByTitle(request.title())) {
            throw new BadRequestException("The course title is already in use");
        }
        Course course = courseMapper.toEntity(request);
        Course courseSave = courseRepository.save(course);
        return courseMapper.toResponse(courseSave);
    }

    @Transactional
    public CourseResponseDTO enrollStudent(Long courseId, Long studentId) {

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Curso", courseId));

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Estudiante", studentId));

        if (course.getStudents().contains(student)) {
            throw new BadRequestException("The student is already enrolled in the course");
        }

        course.addStudent(student);
        Course courseSave = courseRepository.save(course);
        return courseMapper.toResponse(courseSave);
    }

    @Transactional(readOnly = true)
    public List<StudentResponseDTO> getEnrolledStudents(Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Curso", courseId));

        return course.getStudents().stream()
                .map(studentMapper::toResponse)
                .toList();
    }
}
