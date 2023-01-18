package com.example.coursemanagementplatform.models;

import com.aerospike.mapper.annotations.AerospikeKey;
import com.aerospike.mapper.annotations.AerospikeRecord;
import com.aerospike.mapper.annotations.AerospikeReference;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
@AerospikeRecord(namespace = "cmp2", set = "student")
public class Student {
    @AerospikeKey
    public String id;
    private String mail;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate startDate;
    private LocalDate graduationDate;

    @AerospikeReference
    private Set<Homework> homeworks;
    @AerospikeReference
    private Set<Course> courses;

    public String getId() {return this.id;}
    public String getMail() {return this.mail;}
    public String getPassword() {return this.password;}
    public String getFirstname() {return this.firstName;}
    public String getLastname() {return this.lastName;}
    public LocalDate getStartDate() {return this.startDate;}
    public LocalDate getGraduationDate() {return this.graduationDate;}

    public Set<Course> getCourses() {return this.courses;}
    public Set<Homework> getHomeworks() {return this.homeworks;}



    public void setId(String id){
        this.id = id;
    }
    public void setMail(String mail){
        this.mail = mail;
    }
    public void setPassword(String password){this.password = password;}
    public void setFirstname(String firstname){
        this.firstName = firstname;
    }
    public void setLastname(String lastname){
        this.lastName = lastname;
    }
    public void setStartDate(LocalDate startDate) {this.startDate = startDate;}
    public void setGraduationDate(LocalDate startDate) {this.graduationDate = graduationDate;}
    public void setCourses(Set<Course> courses){
        this.courses = courses;
    }
    public void  setHomeworks(Set<Homework> homeworks) {this.homeworks = homeworks;}

}
