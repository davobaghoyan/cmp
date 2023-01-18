package com.example.coursemanagementplatform.mapper;

import com.example.coursemanagementplatform.dto.StudentDTO;
import com.example.coursemanagementplatform.models.Student;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    StudentDTO ToDTO(Student student);
    Student dtoToStudent(StudentDTO studentDTO);
    List<StudentDTO> studentsToDto(List<Student> students);
}
