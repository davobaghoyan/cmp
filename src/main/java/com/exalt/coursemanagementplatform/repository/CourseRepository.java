package com.exalt.coursemanagementplatform.repository;

import com.aerospike.mapper.tools.AeroMapper;
import com.exalt.coursemanagementplatform.exception.notfoundexception.CourseNotFoundException;
import com.exalt.coursemanagementplatform.rest.CourseController;
import com.exalt.coursemanagementplatform.database.DbConnection;
import com.exalt.coursemanagementplatform.models.Course;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * The CourseRepository class is for manipulating any data related to Course.
 */
public class CourseRepository {
    private AeroMapper mapper;
    private static final Logger logger
            = Logger.getLogger(CourseController.class);

    public CourseRepository(){
        mapper = DbConnection.MAPPER;
    }

    public Course saveCourse(Course course){
        mapper.save(course);
        return course;
    }

    public Course getCourse(String id){
        return mapper.read(Course.class, id);
    }

    public List<Course> getAllCourses(){
        return mapper.scan(Course.class);
    }

    public void deleteCourse(String id) throws CourseNotFoundException{
        Course course = getCourse(id);

        if(course == null){
            throw new CourseNotFoundException();
        }

        mapper.delete(course);
    }
}
