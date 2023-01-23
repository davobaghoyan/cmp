package com.exalt.coursemanagementplatform.dto;


/**
 * The LecturerDTO class is data transfer object for Lecturer model.
 */
public class LecturerDTO {
    private String id;
    private String mail;
    private String password;
    private String firstName;
    private String lastName;

    public String getId() {return this.id;}
    public String getMail() {return this.mail;}
    public String getPassword() {return this.password;}
    public String getFirstname() {return this.firstName;}
    public String getLastname() {return this.lastName;}


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
}
