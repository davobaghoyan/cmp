package com.exalt.coursemanagementplatform.service;

import com.exalt.coursemanagementplatform.dto.LecturerDTO;
import com.exalt.coursemanagementplatform.exception.dataalreadyexistsexception.LecturerAlreadyExistsException;
import com.exalt.coursemanagementplatform.exception.notfoundexception.LecturerNotFoundException;
import com.exalt.coursemanagementplatform.models.Lecturer;

import java.util.List;

/**
 * The ILecturerService interface is abstraction for LecturerService
 */
public interface ILecturerService {
     LecturerDTO createLecturer(LecturerDTO lecturerDto) throws LecturerAlreadyExistsException;
     LecturerDTO updateLecturer(LecturerDTO lecturerDto) throws LecturerNotFoundException;
     LecturerDTO getLecturer(String id) throws LecturerNotFoundException;
     List<LecturerDTO> getAllLecturers();
     void deleteLecturer(String id) throws LecturerNotFoundException;
}
