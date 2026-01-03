package com.university.course_manager_api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.university.course_manager_api.domain.Student;
import com.university.course_manager_api.dto.StudentRequestDTO;
import com.university.course_manager_api.dto.StudentResponseDTO;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentResponseDTO toResponse(Student student);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "courses", ignore = true)
    Student toEntity(StudentRequestDTO studentRequestDTO);

}
