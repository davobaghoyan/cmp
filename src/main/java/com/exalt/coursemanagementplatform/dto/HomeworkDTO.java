package com.exalt.coursemanagementplatform.dto;

import com.exalt.coursemanagementplatform.models.enums.HomeworkState;

/**
 * The HomeworkDTO class is data transfer object for Homework model.
 */
public class HomeworkDTO {
    private String id;
    private String description;
    private HomeworkState state;

    public String getId() {return this.id;}
    public String getDescription() {return this.description;}
    public HomeworkState getState() {return this.state;}


    public void setId(String id){
        this.id = id;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setState(HomeworkState state){this.state = state;}
}
