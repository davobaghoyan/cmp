package com.exalt.coursemanagementplatform.dto;

import com.exalt.coursemanagementplatform.models.Homework;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * The CourseDTO class is data transfer object for Course model.
 */
public class CourseDTO {
    private String id;
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private HashSet<Homework> homeworks ;

    public String getId() {return this.id;}
    public String getName() {return this.name;}
    public LocalDateTime getStartDate() {return this.startDate;}
    public LocalDateTime getEndDate() {return this.endDate;}
    public Set<Homework> getHomeworks() {return this.homeworks;}

    public void setId(String id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setStartDate(LocalDateTime startDate){
        this.startDate = startDate;
    }
    public void setEndDate(LocalDateTime endDate){
        this.endDate = endDate;
    }
    public void setHomeworks(HashSet<Homework> homeworks){
        this.homeworks = homeworks;
    }
}
