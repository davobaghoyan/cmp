package com.example.coursemanagementplatform.mapper;

import com.example.coursemanagementplatform.dto.HomeworkDTO;
import com.example.coursemanagementplatform.models.Homework;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface HomeworkMapper {
    HomeworkDTO ToDTO(Homework course);
    Homework dtoToHomework(HomeworkDTO courseDTO);
    List<HomeworkDTO> homeworksToDto(List<Homework> homeworks);
}
