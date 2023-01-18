package com.example.coursemanagementplatform.repository;

import com.aerospike.mapper.tools.AeroMapper;
import com.example.coursemanagementplatform.database.DbConnection;
import com.example.coursemanagementplatform.models.Homework;

import java.util.List;

public class HomeworkRepository {
    private AeroMapper mapper;
    public HomeworkRepository(){
        mapper = DbConnection.MAPPER;
    }

    public Homework saveHomework(Homework homework){
        mapper.save(homework);
        return homework;
    }

    public Homework getHomework(String id){
        return mapper.read(Homework.class, id);
    }

    public List<Homework> getAllHomeworks(){
        return mapper.scan(Homework.class);
    }

    public void deleteHomework(String id){
        Homework hm = getHomework(id);
        mapper.delete(hm);
    }
}
