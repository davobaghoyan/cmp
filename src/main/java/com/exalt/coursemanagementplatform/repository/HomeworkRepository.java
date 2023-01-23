package com.exalt.coursemanagementplatform.repository;

import com.aerospike.mapper.tools.AeroMapper;
import com.exalt.coursemanagementplatform.database.DbConnection;
import com.exalt.coursemanagementplatform.exception.notfoundexception.HomeworkNotFoundException;
import com.exalt.coursemanagementplatform.models.Homework;

import java.util.List;

/**
 * The HomeworkRepository class is for manipulating any data related to Homework.
 */
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

    public void deleteHomework(String id) throws HomeworkNotFoundException {
        Homework homework = getHomework(id);

        if(homework == null){
            throw new HomeworkNotFoundException();
        }

        mapper.delete(homework);
    }
}
