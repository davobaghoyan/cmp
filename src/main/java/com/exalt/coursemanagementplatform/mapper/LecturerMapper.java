package com.exalt.coursemanagementplatform.mapper;

import com.exalt.coursemanagementplatform.dto.LecturerDTO;
import com.exalt.coursemanagementplatform.models.Lecturer;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * The LecturerMapper maps lecturer to DTO and vice versa.
 */
@Mapper
public interface LecturerMapper {
    LecturerDTO ToDTO(Lecturer lecturer);
    Lecturer dtoToLecturer(LecturerDTO lecturerDTO);
    List<LecturerDTO> lecturersToDto(List<Lecturer> lecturers);
}
