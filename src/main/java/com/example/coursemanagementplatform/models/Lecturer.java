package com.example.coursemanagementplatform.models;


import com.aerospike.mapper.annotations.AerospikeKey;
import com.aerospike.mapper.annotations.AerospikeRecord;
import com.aerospike.mapper.annotations.AerospikeReference;
import lombok.Data;

import java.util.Set;


@Data
@AerospikeRecord(namespace = "cmp2", set = "lecturer")
public class Lecturer{
    @AerospikeKey
    private String id;
    private String mail;
    private String password;
    private String firstName;
    private String lastName;
    @AerospikeReference
    private Set<Course> courses;

    public String getId() {return this.id;}
    public String getMail() {return this.mail;}
    public String getPassword() {return this.password;}
    public String getFirstname() {return this.firstName;}
    public String getLastname() {return this.lastName;}
    public Set<Course> getCourses() {return this.courses;}


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
    public void setCourses(Set<Course> courses){
        this.courses = courses;
    }

}
