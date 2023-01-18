package com.example.coursemanagementplatform.models;

import com.aerospike.mapper.annotations.AerospikeKey;
import com.aerospike.mapper.annotations.AerospikeRecord;
import com.aerospike.mapper.annotations.AerospikeReference;

import java.util.HashSet;
import java.util.Set;
import java.time.LocalDateTime;

@AerospikeRecord(namespace="cmp2", set="course")
public class Course {
    private static final long serialVersionUID = 6529685098247757690L;

    @AerospikeKey
    private String id;
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    @AerospikeReference
    private HashSet<Homework> homeworks = new HashSet<>();
    @AerospikeReference
    private Set<Student> students;
    @AerospikeReference
    private Lecturer lecturer;

    public String getId() {return this.id;}
    public String getName() {return this.name;}
    public LocalDateTime getStartDate() {return this.startDate;}
    public LocalDateTime getEndDate() {return this.endDate;}
    public Set<Homework> getHomeworks() {return this.homeworks;}
    public Set<Student> getStudents() {return this.students;}
    public Lecturer getLecturer() {return this.lecturer;}

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
    public void setStudents(Set<Student> students){
        this.students = students;
    }
    public void setLecturer(Lecturer lecturer){
        this.lecturer = lecturer;
    }

}
