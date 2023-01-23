package com.exalt.coursemanagementplatform.service;

import com.exalt.coursemanagementplatform.dto.HomeworkDTO;
import com.exalt.coursemanagementplatform.exception.dataalreadyexistsexception.HomeworkAlreadyExistsException;
import com.exalt.coursemanagementplatform.exception.notfoundexception.CourseNotFoundException;
import com.exalt.coursemanagementplatform.exception.notfoundexception.HomeworkNotFoundException;
import com.exalt.coursemanagementplatform.exception.notfoundexception.StudentNotFoundException;
import com.exalt.coursemanagementplatform.mapper.HomeworkMapper;
import com.exalt.coursemanagementplatform.models.Course;
import com.exalt.coursemanagementplatform.models.Homework;
import com.exalt.coursemanagementplatform.models.Student;
import com.exalt.coursemanagementplatform.repository.CourseRepository;
import com.exalt.coursemanagementplatform.repository.HomeworkRepository;
import com.exalt.coursemanagementplatform.repository.StudentRepository;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * The HomeworkService class is service for manipulating Homework data
 */
public class HomeworkService implements IHomeworkService{
    private HomeworkRepository homeworkRepository;
    private CourseRepository courseRepository;
    private StudentRepository studentRepository;
    private HomeworkMapper homeworkMapper;

    public HomeworkService(){
        courseRepository = new CourseRepository();
        homeworkRepository = new HomeworkRepository();
        studentRepository = new StudentRepository();
        homeworkMapper = Mappers.getMapper(HomeworkMapper.class);
    }

    public HomeworkDTO createHomework(HomeworkDTO homeworkDtO) throws HomeworkAlreadyExistsException {
        Homework homework = homeworkRepository.getHomework(homeworkDtO.getId());

        if(homework != null){
            throw new HomeworkAlreadyExistsException();
        }

        homework = homeworkMapper.dtoToHomework(homeworkDtO);
        homework = homeworkRepository.saveHomework(homework);
        HomeworkDTO homeworkDTO = homeworkMapper.ToDTO(homework);
        return homeworkDTO;
    }

    public HomeworkDTO updateHomework(HomeworkDTO homeworkDto) throws HomeworkNotFoundException {
        Homework homework = homeworkRepository.getHomework(homeworkDto.getId());

        if(homework == null){
            throw new HomeworkNotFoundException();
        }

        homework = homeworkMapper.dtoToHomework(homeworkDto);
        homework = homeworkRepository.saveHomework(homework);
        HomeworkDTO homeworkDTO = homeworkMapper.ToDTO(homework);
        return homeworkDTO;
    }

    public HomeworkDTO getHomework(String id) throws HomeworkNotFoundException{
        Homework homework = homeworkRepository.getHomework(id);

        if(homework == null){
            throw new HomeworkNotFoundException();
        }

        return homeworkMapper.ToDTO(homework);
    }

    public List<HomeworkDTO> getAllHomeworks(){
        List<Homework> homeworks = homeworkRepository.getAllHomeworks();
        return homeworkMapper.homeworksToDto(homeworks);
    }

    public void deleteHomework(String id) throws HomeworkNotFoundException{
        homeworkRepository.deleteHomework(id);
    }

    public HomeworkDTO attachHomeworkToCourse(String homeworkId, String courseId)throws HomeworkNotFoundException, CourseNotFoundException{
        Homework homework = homeworkRepository.getHomework(homeworkId);

        if(homework == null){
            throw new HomeworkNotFoundException();
        }

        Course course = courseRepository.getCourse(courseId);

        if(course == null){
            throw new CourseNotFoundException();
        }

        course.getHomeworks().add(homework);
        courseRepository.saveCourse(course);
        return homeworkMapper.ToDTO(homework);
    }

    public HomeworkDTO assignHomeworkToStudent(String homeworkId, String studentId) throws HomeworkNotFoundException, StudentNotFoundException{
        Homework homework = homeworkRepository.getHomework(homeworkId);

        if(homework == null){
            throw new HomeworkNotFoundException();
        }

        Student student = studentRepository.getStudent(studentId);

        if(student == null){
            throw new StudentNotFoundException();
        }

        student.getHomeworks().add(homework);
        studentRepository.saveStudent(student);
        return homeworkMapper.ToDTO(homework);
    }
}
