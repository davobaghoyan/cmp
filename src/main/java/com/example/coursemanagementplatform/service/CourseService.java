package com.example.coursemanagementplatform.service;

import com.example.coursemanagementplatform.dto.CourseDTO;
import com.example.coursemanagementplatform.mapper.CourseMapper;
import com.example.coursemanagementplatform.models.Course;
import com.example.coursemanagementplatform.repository.CourseRepository;
import org.mapstruct.factory.Mappers;

import java.util.List;


public class CourseService {
    private CourseRepository courseRepository;
    private CourseMapper courseMapper;

    public CourseService(){
        courseMapper = Mappers.getMapper(CourseMapper.class);
        courseRepository = new CourseRepository();
    }

    public CourseDTO saveCourse(CourseDTO courseDto){
        Course course = courseMapper.dtoToCourse(courseDto);
        return courseMapper.courseToDTO(courseRepository.saveCourse(course));
    }

    public CourseDTO getCourse(String id){
        Course course = courseRepository.getCourse(id);
        return courseMapper.courseToDTO(course);
    }

    public List<CourseDTO> getAllCourses(){
        List<Course> courses = courseRepository.getAllCourses();
        return courseMapper.coursesToDto(courses);
    }

    public void deleteCourse(String id){
        courseRepository.deleteCourse(id);
    }
}
