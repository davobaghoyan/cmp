package com.exalt.coursemanagementplatform.dto;


import java.time.LocalDate;

/**
 * The StudentDTO class is data transfer object for Student model.
 */
public class StudentDTO {
    private String id;
    private String mail;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate startDate;
    private LocalDate graduationDate;

    public String getId() {return this.id;}
    public String getMail() {return this.mail;}
    public String getPassword() {return this.password;}
    public String getFirstname() {return this.firstName;}
    public String getLastname() {return this.lastName;}
    public LocalDate getStartDate() {return this.startDate;}
    public LocalDate getGraduationDate() {return this.graduationDate;}




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
}
