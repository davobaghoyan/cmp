package com.exalt.coursemanagementplatform.mapper;

import com.exalt.coursemanagementplatform.dto.HomeworkDTO;
import com.exalt.coursemanagementplatform.models.Homework;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * The HomeworkMapper maps homework to DTO and vice versa.
 */
@Mapper
public interface HomeworkMapper {
    HomeworkDTO ToDTO(Homework homework);
    Homework dtoToHomework(HomeworkDTO courseDTO);
    List<HomeworkDTO> homeworksToDto(List<Homework> homeworks);
}
