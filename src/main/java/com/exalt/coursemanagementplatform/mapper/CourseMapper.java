package com.exalt.coursemanagementplatform.mapper;

import com.exalt.coursemanagementplatform.dto.CourseDTO;
import com.exalt.coursemanagementplatform.models.Course;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * The CourseMapper maps course to DTO and vice versa.
 */
@Mapper
public interface CourseMapper {
    CourseDTO courseToDTO(Course course);
    Course dtoToCourse(CourseDTO courseDTO);
    List<CourseDTO> coursesToDto(List<Course> courses);
}
