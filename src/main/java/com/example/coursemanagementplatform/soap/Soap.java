package com.example.coursemanagementplatform.soap;

import com.example.coursemanagementplatform.service.CourseService;
import com.example.coursemanagementplatform.service.HomeworkService;
import com.example.coursemanagementplatform.service.LecturerService;
import com.example.coursemanagementplatform.service.StudentService;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class Soap {
    private CourseService courseService;
    private StudentService studentService;
    private LecturerService lecturerService;
    private HomeworkService homeworkService;

    public Soap(){
        courseService = new CourseService();
        studentService = new StudentService();
        lecturerService = new LecturerService();
        homeworkService = new HomeworkService();
    }

    @WebMethod(operationName = "attachHomeworkToCourse")
    public void attachHomeworkToCourse(String homeworkId, String courseId){
        homeworkService.attachHomeworkToCourse(homeworkId, courseId);
    }

    @WebMethod(operationName = "assignHomeworkToStudent")
    public void assignHomeworkToStudent(String homeworkId, String studentId){
        homeworkService.attachHomeworkToCourse(homeworkId, studentId);
    }
}
