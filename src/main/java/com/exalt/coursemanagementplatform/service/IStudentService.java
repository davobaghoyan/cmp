package com.exalt.coursemanagementplatform.service;

import com.exalt.coursemanagementplatform.dto.StudentDTO;
import com.exalt.coursemanagementplatform.exception.dataalreadyexistsexception.StudentAlreadyExistsException;
import com.exalt.coursemanagementplatform.exception.notfoundexception.StudentNotFoundException;

import java.util.List;

/**
 * The IStudentService interface is abstraction for StudentService
 */
public interface IStudentService {
     StudentDTO createStudent(StudentDTO studentDto) throws StudentAlreadyExistsException;
     StudentDTO updateStudent(StudentDTO studentDto) throws StudentNotFoundException;
     StudentDTO getStudent(String id) throws StudentNotFoundException;
     List<StudentDTO> getAllStudents();
     void deleteStudent(String id) throws StudentNotFoundException;
}
