package com.exalt.coursemanagementplatform.repository;

import com.aerospike.mapper.tools.AeroMapper;
import com.exalt.coursemanagementplatform.database.DbConnection;
import com.exalt.coursemanagementplatform.exception.notfoundexception.LecturerNotFoundException;
import com.exalt.coursemanagementplatform.models.Lecturer;

import java.util.List;

/**
 * The LecturerRepository class is for manipulating any data related to Lecturer.
 */
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

    public void deleteLecturer(String id) throws LecturerNotFoundException {
        Lecturer lecturer = getLecturer(id);

        if(lecturer == null){
            throw new LecturerNotFoundException();
        }

        mapper.delete(lecturer);
    }
}
