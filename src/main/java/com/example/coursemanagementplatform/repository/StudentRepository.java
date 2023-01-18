package com.example.coursemanagementplatform.repository;

import com.aerospike.mapper.tools.AeroMapper;
import com.example.coursemanagementplatform.database.DbConnection;
import com.example.coursemanagementplatform.models.Student;

import java.util.List;

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

    public void deleteStudent(String id){
        Student student = getStudent(id);

        if(student == null){
            return;
        }

        mapper.delete(student);
    }
}
