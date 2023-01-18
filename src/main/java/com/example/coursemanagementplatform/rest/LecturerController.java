package com.example.coursemanagementplatform.rest;

import com.example.coursemanagementplatform.dto.LecturerDTO;
import com.example.coursemanagementplatform.service.LecturerService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.apache.log4j.Logger;

import java.util.List;

@Path("/lecturer")
public class LecturerController {
    private LecturerService lecturerService;
    private static final Logger logger
            = Logger.getLogger(CourseController.class);

    public LecturerController(){
        lecturerService = new LecturerService();
    }

    @GET
    @Path("/get/{id}")
    public Response getLecturer(@PathParam("id") String id) {
        LecturerDTO lecturer = lecturerService.getLecturer(id);
        if(lecturer != null){
            return Response.ok(lecturer).build();
        }

        logger.error("The lecturer with id " + id + " not found");
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("/get")
    public Response getLecturers(){
        List<LecturerDTO> lecturers = lecturerService.getAllLecturers();
        return Response.ok(lecturers).build();
    }

    @POST
    @Path("/save")
    public Response saveLecturer(LecturerDTO lecturerDTO) {
        LecturerDTO lecturer = lecturerService.saveLecturer(lecturerDTO);
        logger.info("The course with id " + lecturerDTO.id + " saved");
        return Response.ok(lecturer).build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteLecturer(@PathParam("id") String id) {
        lecturerService.deleteLecturer(id);
        logger.warn("The course with id " + id + " deleted");
        return Response.noContent().build();
    }
}
