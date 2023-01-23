package com.exalt.coursemanagementplatform.rest;

import com.exalt.coursemanagementplatform.dto.CourseDTO;
import com.exalt.coursemanagementplatform.exception.dataalreadyexistsexception.CourseAlreadyExistsException;
import com.exalt.coursemanagementplatform.exception.notfoundexception.CourseNotFoundException;
import com.exalt.coursemanagementplatform.exception.ErrorResponse;
import com.exalt.coursemanagementplatform.service.CourseService;

import com.exalt.coursemanagementplatform.service.ICourseService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * The CourseController class is responsible for endpoints for course
 */
@Path("/course")
public class CourseController {
    private ICourseService courseService;

    private static final Logger logger
            = Logger.getLogger(CourseController.class);
    public CourseController(){
        courseService = new CourseService();
    }

    @GET
    @Path("/get/{id}")
    public Response getCourse(@PathParam("id") String id) {
        CourseDTO course;

        try{
            course = courseService.getCourse(id);
        }
        catch (CourseNotFoundException e){
            logger.error(e.getMessage());
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new ErrorResponse(e.getMessage(), 404))
                    .build();
        }

        return Response.ok(course).build();
    }

    @GET
    @Path("/get")
    public Response getCourses(){
        List<CourseDTO> courses = courseService.getAllCourses();
        return Response.ok(courses).build();
    }

    @POST
    @Path("/create")
    public Response createCourse(CourseDTO courseDTO) {
        CourseDTO course;

        try{
            course = courseService.createCourse(courseDTO);
        }
        catch (CourseAlreadyExistsException e){
            logger.error(e.getMessage());
            return Response.status(Response.Status.CONFLICT)
                    .entity(new ErrorResponse(e.getMessage(), 409))
                    .build();
        }

        logger.info("The course with id " + course.getId() + " saved");
        return Response.ok(course).build();
    }

    @PUT
    @Path("/update")
    public Response updateCourse(CourseDTO courseDTO) {
        CourseDTO course;

        try{
            course = courseService.updateCourse(courseDTO);
        }
        catch (CourseNotFoundException e){
            logger.error(e.getMessage());
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new ErrorResponse(e.getMessage(), 404))
                    .build();
        }

        logger.info("The course with id " + course.getId() + " updated");
        return Response.ok(course).build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteCourse(@PathParam("id") String id) {
        try{
            courseService.deleteCourse(id);
        }
        catch (CourseNotFoundException e){
            logger.error(e.getMessage());
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new ErrorResponse(e.getMessage(), 404))
                    .build();
        }

        logger.warn("The course with id " + id + " deleted");
        return Response.noContent().build();
    }
}
