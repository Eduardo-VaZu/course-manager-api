package com.university.course_manager_api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.university.course_manager_api.domain.Course;
import com.university.course_manager_api.dto.CourseRequestDTO;
import com.university.course_manager_api.dto.CourseResponseDTO;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CourseMapper {

    CourseResponseDTO toResponse(Course course);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "students", ignore = true)
    Course toEntity(CourseRequestDTO request);
}