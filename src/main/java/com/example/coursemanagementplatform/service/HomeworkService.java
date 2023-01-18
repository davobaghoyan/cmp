package com.example.coursemanagementplatform.service;

import com.example.coursemanagementplatform.dto.HomeworkDTO;
import com.example.coursemanagementplatform.mapper.HomeworkMapper;
import com.example.coursemanagementplatform.models.Course;
import com.example.coursemanagementplatform.models.Homework;
import com.example.coursemanagementplatform.models.Student;
import com.example.coursemanagementplatform.repository.CourseRepository;
import com.example.coursemanagementplatform.repository.HomeworkRepository;
import com.example.coursemanagementplatform.repository.StudentRepository;
import org.mapstruct.factory.Mappers;

import java.util.List;

public class HomeworkService {
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

    public HomeworkDTO saveHomework(HomeworkDTO homeworkDTO){
        Homework homework = new Homework();
        homework.setId(homeworkDTO.id);
        homework.setState(homeworkDTO.state);
        homework.setDescription(homeworkDTO.description);

        return homeworkMapper.ToDTO(homeworkRepository.saveHomework(homework));
    }

    public HomeworkDTO getHomework(String id){
        Homework homework = homeworkRepository.getHomework(id);
        return homeworkMapper.ToDTO(homework);
    }

    public List<HomeworkDTO> getAllHomeworks(){
        List<Homework> homeworks = homeworkRepository.getAllHomeworks();
        return homeworkMapper.homeworksToDto(homeworks);
    }

    public void deleteHomework(String id){
        homeworkRepository.deleteHomework(id);
    }

    public HomeworkDTO attachHomeworkToCourse(String homeworkId, String courseId){
        Homework homework = homeworkRepository.getHomework(homeworkId);
        Course course = courseRepository.getCourse(courseId);
        course.getHomeworks().add(homework);

        courseRepository.saveCourse(course);

        return homeworkMapper.ToDTO(homework);
    }

    public HomeworkDTO assignHomeworkToStudent(String homeworkId, String studentId){
        Homework homework = homeworkRepository.getHomework(homeworkId);
        Student student = studentRepository.getStudent(studentId);
        student.getHomeworks().add(homework);
        studentRepository.saveStudent(student);

        return homeworkMapper.ToDTO(homework);
    }
}
