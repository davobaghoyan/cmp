package com.exalt.coursemanagementplatform.repository;

import com.aerospike.mapper.tools.AeroMapper;
import com.exalt.coursemanagementplatform.database.DbConnection;
import com.exalt.coursemanagementplatform.exception.notfoundexception.StudentNotFoundException;
import com.exalt.coursemanagementplatform.models.Student;

import java.util.List;

/**
 * The StudentRepository class is for manipulating any data related to Student.
 */
public class StudentRepository {
    private AeroMapper mapper;
    public StudentRepository(){
        mapper = DbConnection.MAPPER;
    }

    public Student saveStudent(Student student){
        mapper.save(student);
        return student;
    }

    public Student getStudent(String id){
        return mapper.read(Student.class, id);
    }

    public List<Student> getAllStudents(){
        return mapper.scan(Student.class);
    }

    public void deleteStudent(String id) throws StudentNotFoundException{
        Student student = getStudent(id);

        if(student == null){
            throw new StudentNotFoundException();
        }

        mapper.delete(student);
    }
}
