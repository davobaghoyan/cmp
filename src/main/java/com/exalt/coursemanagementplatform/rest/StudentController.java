package com.exalt.coursemanagementplatform.rest;

import com.exalt.coursemanagementplatform.exception.ErrorResponse;
import com.exalt.coursemanagementplatform.exception.dataalreadyexistsexception.StudentAlreadyExistsException;
import com.exalt.coursemanagementplatform.exception.notfoundexception.StudentNotFoundException;
import com.exalt.coursemanagementplatform.service.IStudentService;
import com.exalt.coursemanagementplatform.service.StudentService;
import com.exalt.coursemanagementplatform.dto.StudentDTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * The StudentController class is responsible for endpoints for student
 */
@Path("/student")
public class StudentController {
    private IStudentService studentService;
    private static final Logger logger
            = Logger.getLogger(CourseController.class);

    public StudentController(){
        studentService = new StudentService();
    }

    @GET
    @Path("/get")
    public Response getStudents(){
        List<StudentDTO> students = studentService.getAllStudents();
        return Response.ok(students).build();
    }

    @GET
    @Path("/get/{id}")
    public Response getStudent(@PathParam("id") String id) {
        StudentDTO studentDTO;

        try{
            studentDTO = studentService.getStudent(id);
        }
        catch (StudentNotFoundException e){
            logger.error(e.getMessage());
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new ErrorResponse(e.getMessage(), 404))
                    .build();
        }

        return Response.ok(studentDTO).build();
    }

    @POST
    @Path("/create")
    public Response createStudent(StudentDTO studentDto) {
        StudentDTO studentDTO;

        try{
            studentDTO = studentService.createStudent(studentDto);
        }
        catch (StudentAlreadyExistsException e){
            logger.error(e.getMessage());
            return Response.status(Response.Status.CONFLICT)
                    .entity(new ErrorResponse(e.getMessage(), 409))
                    .build();
        }

        logger.info("The student with id " + studentDTO.getId() + " saved");
        return Response.ok(studentDTO).build();
    }

    @PUT
    @Path("/update")
    public Response updateStudent(StudentDTO studentDto) {
        StudentDTO studentDTO;

        try{
            studentDTO = studentService.updateStudent(studentDto);
        }
        catch (StudentNotFoundException e){
            logger.error(e.getMessage());
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new ErrorResponse(e.getMessage(), 404))
                    .build();
        }

        logger.info("The student with id " + studentDto.getId() + " updated");
        return Response.ok(studentDTO).build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteStudent(@PathParam("id") String id) {
        try{
            studentService.deleteStudent(id);
        }
        catch (StudentNotFoundException e){
            logger.error(e.getMessage());
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new ErrorResponse(e.getMessage(), 404))
                    .build();
        }

        logger.warn("The student with id " + id + " deleted");
        return Response.noContent().build();
    }
}