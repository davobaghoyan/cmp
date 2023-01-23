package com.exalt.coursemanagementplatform.service;

import com.exalt.coursemanagementplatform.dto.CourseDTO;
import com.exalt.coursemanagementplatform.exception.dataalreadyexistsexception.CourseAlreadyExistsException;
import com.exalt.coursemanagementplatform.exception.notfoundexception.CourseNotFoundException;
import com.exalt.coursemanagementplatform.mapper.CourseMapper;
import com.exalt.coursemanagementplatform.models.Course;
import com.exalt.coursemanagementplatform.repository.CourseRepository;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * The CourseService class is service for manipulating Course data
 */
public class CourseService implements ICourseService{
    private CourseRepository courseRepository;
    private CourseMapper courseMapper;

    public CourseService(){
        courseMapper = Mappers.getMapper(CourseMapper.class);
        courseRepository = new CourseRepository();
    }

    public CourseDTO createCourse(CourseDTO courseDto) throws CourseAlreadyExistsException{
        Course course = courseRepository.getCourse(courseDto.getId());

        if(course != null){
            throw new CourseAlreadyExistsException();
        }

        course = courseMapper.dtoToCourse(courseDto);
        course = courseRepository.saveCourse(course);
        CourseDTO courseDTO = courseMapper.courseToDTO(course);
        return courseDTO;
    }

    public CourseDTO updateCourse(CourseDTO courseDto) throws CourseNotFoundException{
        Course course = courseRepository.getCourse(courseDto.getId());

        if(course == null){
            throw new CourseNotFoundException();
        }

        course = courseMapper.dtoToCourse(courseDto);
        course = courseRepository.saveCourse(course);
        CourseDTO courseDTO = courseMapper.courseToDTO(course);
        return courseDTO;
    }

    public CourseDTO getCourse(String id) throws CourseNotFoundException{
        Course course = courseRepository.getCourse(id);

        if(course == null){
            throw new CourseNotFoundException();
        }

        return courseMapper.courseToDTO(course);
    }

    public List<CourseDTO> getAllCourses(){
        List<Course> courses = courseRepository.getAllCourses();
        return courseMapper.coursesToDto(courses);
    }

    public void deleteCourse(String id) throws CourseNotFoundException{
        courseRepository.deleteCourse(id);
    }
}
