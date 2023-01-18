package com.example.coursemanagementplatform.rest;

import com.example.coursemanagementplatform.dto.StudentDTO;
import com.example.coursemanagementplatform.models.Student;
import com.example.coursemanagementplatform.service.StudentService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.apache.log4j.Logger;

import java.util.List;

@Path("/student")
public class StudentController {
    private StudentService studentService;
    private static final Logger logger
            = Logger.getLogger(CourseController.class);

    public StudentController(){
        studentService = new StudentService();
    }

    @GET
    @Path("/get/{id}")
    public Response getStudent(@PathParam("id") String id) {
        StudentDTO student = studentService.getStudent(id);
        if(student != null){
            return Response.ok(student).build();
        }

        logger.error("The student with id " + id + " not found");
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("/get")
    public Response getStudents(){
        List<StudentDTO> students = studentService.getAllStudents();
        return Response.ok(students).build();
    }

    @POST
    @Path("/save")
    public Response saveStudent(StudentDTO studentDTO) {
        StudentDTO student = studentService.saveStudent(studentDTO);
        logger.info("The student with id " + studentDTO.id + " saved");
        return Response.ok(student).build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteStudent(@PathParam("id") String id) {
        studentService.deleteStudent(id);
        logger.warn("The student with id " + id + " deleted");
        return Response.noContent().build();
    }
}