package com.exalt.coursemanagementplatform.soap;

import com.exalt.coursemanagementplatform.service.CourseService;
import com.exalt.coursemanagementplatform.service.HomeworkService;
import com.exalt.coursemanagementplatform.service.LecturerService;
import com.exalt.coursemanagementplatform.service.StudentService;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * There are SOAP endpoint responsible for attaching homework to course
 * and assigning homework to student
 */
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
    public String attachHomeworkToCourse(String homeworkId, String courseId){
        try{
           return homeworkService.attachHomeworkToCourse(homeworkId, courseId).toString();
        }
        catch (Exception e){
            return e.getMessage();
        }
    }

    @WebMethod(operationName = "assignHomeworkToStudent")
    public String assignHomeworkToStudent(String homeworkId, String studentId){
        try{
           return homeworkService.attachHomeworkToCourse(homeworkId, studentId).toString();
        }
        catch (Exception e){
            return e.getMessage();
        }
    }
}
