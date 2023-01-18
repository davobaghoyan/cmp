package com.example.coursemanagementplatform.rest;

import com.example.coursemanagementplatform.dto.HomeworkDTO;
import com.example.coursemanagementplatform.service.HomeworkService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.apache.log4j.Logger;

import java.util.List;

@Path("/homework")
public class HomeworkController {
    private HomeworkService homeworkService;
    private static final Logger logger
            = Logger.getLogger(CourseController.class);
    public HomeworkController(){
        homeworkService = new HomeworkService();
    }

    @GET
    @Path("/get/{id}")
    public Response getHomework(@PathParam("id") String id) {
        HomeworkDTO homeworkDTO = homeworkService.getHomework(id);
        if(homeworkDTO != null){
            return Response.ok(homeworkDTO).build();
        }

        logger.error("The homework with id " + id + " not found");
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("/get")
    public Response getHomeworks(){
        List<HomeworkDTO> homeworks = homeworkService.getAllHomeworks();
        return Response.ok(homeworks).build();
    }

    @POST
    @Path("/save")
    public Response saveHomework(HomeworkDTO homeworkDTO) {
        HomeworkDTO homework = homeworkService.saveHomework(homeworkDTO);
        logger.info("The course with id " + homeworkDTO.id + " saved");
        return Response.ok(homework).build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteHomework(@PathParam("id") String id) {
        homeworkService.deleteHomework(id);
        logger.warn("The course with id " + id + " deleted");
        return Response.noContent().build();
    }
}
