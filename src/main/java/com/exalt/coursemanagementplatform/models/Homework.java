package com.exalt.coursemanagementplatform.models;

import com.aerospike.mapper.annotations.AerospikeKey;
import com.aerospike.mapper.annotations.AerospikeRecord;
import com.exalt.coursemanagementplatform.models.enums.HomeworkState;

import java.io.Serializable;

/**
 * The Homework is Data Access Object for Homework model in database.
 */
@AerospikeRecord(namespace = "cmp2", set = "homework")
public class Homework implements Serializable{

    @AerospikeKey
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
