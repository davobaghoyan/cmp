package com.example.coursemanagementplatform.repository;

import com.aerospike.mapper.tools.AeroMapper;
import com.example.coursemanagementplatform.database.DbConnection;
import com.example.coursemanagementplatform.models.Lecturer;

import java.util.List;

public class LecturerRepository {
    private AeroMapper mapper;
    public LecturerRepository(){
        mapper = DbConnection.MAPPER;
    }

    public Lecturer saveLecturer(Lecturer lecturer){
        mapper.save(lecturer);
        return lecturer;
    }

    public Lecturer getLecturer(String id){
        return mapper.read(Lecturer.class, id);
    }

    public List<Lecturer> getAllLecturers(){
        return mapper.scan(Lecturer.class);
    }

    public void deleteLecturer(String id){
        Lecturer lecturer = getLecturer(id);
        mapper.delete(lecturer);
    }
}
