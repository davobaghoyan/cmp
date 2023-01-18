package com.example.coursemanagementplatform.service;

import com.example.coursemanagementplatform.dto.LecturerDTO;
import com.example.coursemanagementplatform.mapper.LecturerMapper;
import com.example.coursemanagementplatform.models.Lecturer;
import com.example.coursemanagementplatform.repository.LecturerRepository;
import org.mapstruct.factory.Mappers;

import java.util.List;

public class LecturerService {

    private LecturerRepository lecturerRepository;
    private LecturerMapper lecturerMapper;

    public LecturerService(){
        lecturerRepository = new LecturerRepository();
        lecturerMapper = Mappers.getMapper(LecturerMapper.class);
    }

    public LecturerDTO saveLecturer(LecturerDTO lecturerDTO){
        Lecturer lecturer = new Lecturer();
        lecturer.setId(lecturerDTO.id);
        lecturer.setMail(lecturerDTO.mail);
        lecturer.setPassword(lecturerDTO.password);
        lecturer.setFirstname(lecturerDTO.firstName);
        lecturer.setLastname(lecturerDTO.lastName);

        return lecturerMapper.ToDTO(lecturer);
    }

    public LecturerDTO getLecturer(String id){
        Lecturer lecturer = lecturerRepository.getLecturer(id);
        return lecturerMapper.ToDTO(lecturer);
    }

    public List<LecturerDTO> getAllLecturers(){
        List<Lecturer> lecturers = lecturerRepository.getAllLecturers();
        return lecturerMapper.lecturersToDto(lecturers);
    }

    public void deleteLecturer(String id){
        lecturerRepository.deleteLecturer(id);
    }
}
