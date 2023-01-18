package com.example.coursemanagementplatform.dto;

import com.example.coursemanagementplatform.models.Homework;

import java.time.LocalDateTime;
import java.util.HashSet;

public class CourseDTO {
    public String id;
    public String name;
    public LocalDateTime startDate;
    public LocalDateTime endDate;
    public HashSet<Homework> homeworks ;
}
