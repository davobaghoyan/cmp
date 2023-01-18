package com.example.coursemanagementplatform.repository;

import com.aerospike.mapper.tools.AeroMapper;
import com.example.coursemanagementplatform.database.DbConnection;
import com.example.coursemanagementplatform.models.Course;
import com.example.coursemanagementplatform.rest.CourseController;
import org.apache.log4j.Logger;

import java.util.List;

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

    public void deleteCourse(String id){
        Course course = getCourse(id);
        mapper.delete(course);
    }
}
