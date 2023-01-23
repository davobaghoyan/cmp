package com.exalt.coursemanagementplatform.mapper;

import com.exalt.coursemanagementplatform.dto.StudentDTO;
import com.exalt.coursemanagementplatform.models.Student;
import org.mapstruct.Mapper;

import java.util.List;


/**
 * The StudentMapper maps student to DTO and vice versa.
 */
@Mapper
public interface StudentMapper {
    StudentDTO ToDTO(Student student);
    Student dtoToStudent(StudentDTO studentDTO);
    List<StudentDTO> studentsToDto(List<Student> students);
}
