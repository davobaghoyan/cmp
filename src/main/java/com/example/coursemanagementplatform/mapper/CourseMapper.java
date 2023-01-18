package com.example.coursemanagementplatform.mapper;

import com.example.coursemanagementplatform.dto.CourseDTO;
import com.example.coursemanagementplatform.models.Course;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper {
    CourseDTO courseToDTO(Course course);
    Course dtoToCourse(CourseDTO courseDTO);
    List<CourseDTO> coursesToDto(List<Course> courses);
}
