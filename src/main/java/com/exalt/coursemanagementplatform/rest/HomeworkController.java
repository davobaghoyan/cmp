package com.exalt.coursemanagementplatform.rest;

import com.exalt.coursemanagementplatform.exception.ErrorResponse;
import com.exalt.coursemanagementplatform.exception.dataalreadyexistsexception.HomeworkAlreadyExistsException;
import com.exalt.coursemanagementplatform.exception.notfoundexception.HomeworkNotFoundException;
import com.exalt.coursemanagementplatform.service.HomeworkService;
import com.exalt.coursemanagementplatform.dto.HomeworkDTO;
import com.exalt.coursemanagementplatform.service.IHomeworkService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * The HomeworkController class is responsible for endpoints for homework
 */
@Path("/homework")
public class HomeworkController {
    private IHomeworkService homeworkService;
    private static final Logger logger
            = Logger.getLogger(CourseController.class);
    public HomeworkController(){
        homeworkService = new HomeworkService();
    }

    @GET
    @Path("/get/{id}")
    public Response getHomework(@PathParam("id") String id) {
        HomeworkDTO homeworkDTO;

        try{
            homeworkDTO = homeworkService.getHomework(id);
        }
        catch (HomeworkNotFoundException e){
            logger.error(e.getMessage());
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new ErrorResponse(e.getMessage(), 404))
                    .build();
        }

        return Response.ok(homeworkDTO).build();
    }

    @GET
    @Path("/get")
    public Response getHomeworks(){
        List<HomeworkDTO> homeworks = homeworkService.getAllHomeworks();
        return Response.ok(homeworks).build();
    }

    @POST
    @Path("/create")
    public Response createHomework(HomeworkDTO homeworkDto) {
        HomeworkDTO homeworkDTO;

        try{
            homeworkDTO = homeworkService.createHomework(homeworkDto);
        }
        catch (HomeworkAlreadyExistsException e){
            logger.error(e.getMessage());
            return Response.status(Response.Status.CONFLICT)
                    .entity(new ErrorResponse(e.getMessage(), 409))
                    .build();
        }

        logger.info("The homework with id " + homeworkDTO.getId() + " saved");
        return Response.ok(homeworkDTO).build();
    }

    @PUT
    @Path("/update")
    public Response updateHomework(HomeworkDTO homeworkDto) {
        HomeworkDTO homeworkDTO;

        try{
            homeworkDTO = homeworkService.updateHomework(homeworkDto);
        }
        catch (HomeworkNotFoundException e){
            logger.error(e.getMessage());
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new ErrorResponse(e.getMessage(), 404))
                    .build();
        }

        logger.info("The homework with id " + homeworkDTO.getId() + " updated");
        return Response.ok(homeworkDTO).build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteHomework(@PathParam("id") String id) {
        try{
            homeworkService.deleteHomework(id);
        }
        catch (HomeworkNotFoundException e){
            logger.error(e.getMessage());
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new ErrorResponse(e.getMessage(), 404))
                    .build();
        }

        logger.warn("The homework with id " + id + " deleted");
        return Response.noContent().build();
    }
}
