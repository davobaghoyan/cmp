package com.example.coursemanagementplatform.service;

import com.example.coursemanagementplatform.dto.StudentDTO;
import com.example.coursemanagementplatform.mapper.LecturerMapper;
import com.example.coursemanagementplatform.mapper.StudentMapper;
import com.example.coursemanagementplatform.models.Student;
import com.example.coursemanagementplatform.repository.StudentRepository;

import java.util.List;

public class StudentService {

    private StudentRepository studentRepository;
    private StudentMapper studentMapper;

    public StudentService(){
        studentRepository = new StudentRepository();
    }

    public StudentDTO saveStudent(StudentDTO studentDTO){
        Student student = new Student();
        student.setId(studentDTO.id);
        student.setMail(studentDTO.mail);
        student.setPassword(studentDTO.password);
        student.setFirstname(studentDTO.firstName);
        student.setLastname(studentDTO.lastName);
        student.setStartDate(studentDTO.startDate);
        student.setGraduationDate(studentDTO.graduationDate);

        return studentMapper.ToDTO(studentRepository.saveStudent(student));
    }

    public StudentDTO getStudent(String id){
        Student student = studentRepository.getStudent(id);
        return studentMapper.ToDTO(student);
    }

    public List<StudentDTO> getAllStudents(){
        List<Student> students = studentRepository.getAllStudents();
        return studentMapper.studentsToDto(students);
    }

    public void deleteStudent(String id){
        studentRepository.deleteStudent(id);
    }
}
