package com.exalt.coursemanagementplatform.rest;

import com.exalt.coursemanagementplatform.dto.LecturerDTO;
import com.exalt.coursemanagementplatform.exception.ErrorResponse;
import com.exalt.coursemanagementplatform.exception.dataalreadyexistsexception.LecturerAlreadyExistsException;
import com.exalt.coursemanagementplatform.exception.notfoundexception.LecturerNotFoundException;
import com.exalt.coursemanagementplatform.service.ILecturerService;
import com.exalt.coursemanagementplatform.service.LecturerService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * The LecturerController class is responsible for endpoints for lecturer
 */
@Path("/lecturer")
public class LecturerController {
    private ILecturerService lecturerService;
    private static final Logger logger
            = Logger.getLogger(CourseController.class);

    public LecturerController(){
        lecturerService = new LecturerService();
    }

    @GET
    @Path("/get")
    public Response getLecturers(){
        List<LecturerDTO> lecturers = lecturerService.getAllLecturers();
        return Response.ok(lecturers).build();
    }

    @GET
    @Path("/get/{id}")
    public Response getLecturer(@PathParam("id") String id) {
        LecturerDTO lecturerDTO;

        try{
            lecturerDTO = lecturerService.getLecturer(id);
        }
        catch (LecturerNotFoundException e){
            logger.error(e.getMessage());
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new ErrorResponse(e.getMessage(), 404))
                    .build();
        }

        return Response.ok(lecturerDTO).build();
    }

    @POST
    @Path("/create")
    public Response createLecturer(LecturerDTO lecturerDto) {
        LecturerDTO lecturerDTO;

        try{
            lecturerDTO = lecturerService.createLecturer(lecturerDto);
        }
        catch (LecturerAlreadyExistsException e){
            logger.error(e.getMessage());
            return Response.status(Response.Status.CONFLICT)
                    .entity(new ErrorResponse(e.getMessage(), 409))
                    .build();
        }

        logger.info("The lecturer with id " + lecturerDTO.getId() + " saved");
        return Response.ok(lecturerDTO).build();
    }

    @PUT
    @Path("/update")
    public Response updateLecturer(LecturerDTO lecturerDto) {
        LecturerDTO lecturerDTO;

        try{
            lecturerDTO = lecturerService.updateLecturer(lecturerDto);
        }
        catch (LecturerNotFoundException e){
            logger.error(e.getMessage());
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new ErrorResponse(e.getMessage(), 404))
                    .build();
        }

        logger.info("The lecturer with id " + lecturerDto.getId() + " updated");
        return Response.ok(lecturerDto).build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteLecturer(@PathParam("id") String id) {
        try{
            lecturerService.deleteLecturer(id);
        }
        catch (LecturerNotFoundException e){
            logger.error(e.getMessage());
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new ErrorResponse(e.getMessage(), 404))
                    .build();
        }

        logger.warn("The lecturer with id " + id + " deleted");
        return Response.noContent().build();
    }
}
