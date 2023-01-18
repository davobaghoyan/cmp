package com.example.coursemanagementplatform.mapper;

import com.example.coursemanagementplatform.dto.LecturerDTO;
import com.example.coursemanagementplatform.models.Lecturer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface LecturerMapper {
    LecturerDTO ToDTO(Lecturer lecturer);
    Lecturer dtoToLecturer(LecturerDTO lecturerDTO);
    List<LecturerDTO> lecturersToDto(List<Lecturer> lecturers);
}
