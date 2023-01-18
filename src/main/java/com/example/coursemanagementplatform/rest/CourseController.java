package com.example.coursemanagementplatform.rest;

import com.example.coursemanagementplatform.dto.CourseDTO;
import com.example.coursemanagementplatform.service.CourseService;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.apache.log4j.Logger;

import java.util.List;

@Path("/course")
public class CourseController {
    private CourseService courseService;

    private static final Logger logger
            = Logger.getLogger(CourseController.class);
    public CourseController(){
        courseService = new CourseService();
    }

    @GET
    @Path("/get/{id}")
    public Response getCourse(@PathParam("id") String id) {
        CourseDTO course = courseService.getCourse(id);
        if(course != null){
            return Response.ok(course).build();
        }

        logger.error("The course with id " + id + " not found");
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("/get")
    public Response getCourses(){
        List<CourseDTO> courses = courseService.getAllCourses();
        return Response.ok(courses).build();
    }

    @POST

    @Path("/save")
    public Response saveCourse(CourseDTO courseDTO) {
        CourseDTO course = courseService.saveCourse(courseDTO);
        logger.info("The course with id " + course.id + " saved");
        return Response.ok(course).build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteCourse(@PathParam("id") String id) {
        courseService.deleteCourse(id);
        logger.warn("The course with id " + id + " deleted");
        return Response.noContent().build();
    }
}
