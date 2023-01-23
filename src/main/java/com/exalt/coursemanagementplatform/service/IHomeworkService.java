package com.exalt.coursemanagementplatform.service;

import com.exalt.coursemanagementplatform.dto.HomeworkDTO;
import com.exalt.coursemanagementplatform.exception.dataalreadyexistsexception.HomeworkAlreadyExistsException;
import com.exalt.coursemanagementplatform.exception.notfoundexception.CourseNotFoundException;
import com.exalt.coursemanagementplatform.exception.notfoundexception.HomeworkNotFoundException;
import com.exalt.coursemanagementplatform.exception.notfoundexception.StudentNotFoundException;
import com.exalt.coursemanagementplatform.models.Course;
import com.exalt.coursemanagementplatform.models.Homework;
import com.exalt.coursemanagementplatform.models.Student;

import java.util.List;

/**
 * The IHomeworkService interface is abstraction for HomeworkService
 */
public interface IHomeworkService {
     HomeworkDTO createHomework(HomeworkDTO homeworkDtO) throws HomeworkAlreadyExistsException;
     HomeworkDTO updateHomework(HomeworkDTO homeworkDto) throws HomeworkNotFoundException;
     HomeworkDTO getHomework(String id) throws HomeworkNotFoundException;
     List<HomeworkDTO> getAllHomeworks();
     void deleteHomework(String id) throws HomeworkNotFoundException;
     HomeworkDTO attachHomeworkToCourse(String homeworkId, String courseId)throws HomeworkNotFoundException, CourseNotFoundException;
     HomeworkDTO assignHomeworkToStudent(String homeworkId, String studentId) throws HomeworkNotFoundException, StudentNotFoundException;
}
