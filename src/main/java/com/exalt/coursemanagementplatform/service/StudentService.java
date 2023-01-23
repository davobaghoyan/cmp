package com.exalt.coursemanagementplatform.service;

import com.exalt.coursemanagementplatform.dto.StudentDTO;
import com.exalt.coursemanagementplatform.exception.dataalreadyexistsexception.StudentAlreadyExistsException;
import com.exalt.coursemanagementplatform.exception.notfoundexception.StudentNotFoundException;
import com.exalt.coursemanagementplatform.mapper.StudentMapper;
import com.exalt.coursemanagementplatform.models.Student;
import com.exalt.coursemanagementplatform.repository.StudentRepository;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * The StudentService class is service for manipulating Student data
 */
public class StudentService implements IStudentService{

    private StudentRepository studentRepository;
    private StudentMapper studentMapper;

    public StudentService(){
        studentMapper = Mappers.getMapper(StudentMapper.class);
        studentRepository = new StudentRepository();
    }

    public StudentDTO createStudent(StudentDTO studentDto) throws StudentAlreadyExistsException {
        Student student = studentRepository.getStudent(studentDto.getId());

        if(student != null){
            throw new StudentAlreadyExistsException();
        }

        student = studentMapper.dtoToStudent(studentDto);
        student = studentRepository.saveStudent(student);
        StudentDTO studentDTO = studentMapper.ToDTO(student);
        return studentDTO;
    }

    public StudentDTO updateStudent(StudentDTO studentDto) throws StudentNotFoundException {
        Student student = studentRepository.getStudent(studentDto.getId());

        if(student == null){
            throw new StudentNotFoundException();
        }

        student = studentMapper.dtoToStudent(studentDto);
        student = studentRepository.saveStudent(student);
        StudentDTO studentDTO = studentMapper.ToDTO(student);
        return studentDTO;
    }

    public StudentDTO getStudent(String id) throws StudentNotFoundException{
        Student student = studentRepository.getStudent(id);

        if(student == null){
            throw new StudentNotFoundException();
        }

        return studentMapper.ToDTO(student);
    }

    public List<StudentDTO> getAllStudents(){
        List<Student> students = studentRepository.getAllStudents();
        return studentMapper.studentsToDto(students);
    }

    public void deleteStudent(String id) throws StudentNotFoundException {
        studentRepository.deleteStudent(id);
    }
}
