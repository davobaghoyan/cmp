package com.exalt.coursemanagementplatform.service;

import com.exalt.coursemanagementplatform.dto.CourseDTO;
import com.exalt.coursemanagementplatform.exception.dataalreadyexistsexception.CourseAlreadyExistsException;
import com.exalt.coursemanagementplatform.exception.notfoundexception.CourseNotFoundException;

import java.util.List;

/**
 * The ICourseService interface is abstraction for CourseService
 */
public interface ICourseService {
     CourseDTO createCourse(CourseDTO courseDto) throws CourseAlreadyExistsException;
     CourseDTO updateCourse(CourseDTO courseDto) throws CourseNotFoundException;
     CourseDTO getCourse(String id) throws CourseNotFoundException;
     List<CourseDTO> getAllCourses();
     void deleteCourse(String id) throws CourseNotFoundException;
}
