package com.exalt.coursemanagementplatform.service;

import com.exalt.coursemanagementplatform.dto.LecturerDTO;
import com.exalt.coursemanagementplatform.exception.dataalreadyexistsexception.LecturerAlreadyExistsException;
import com.exalt.coursemanagementplatform.exception.notfoundexception.LecturerNotFoundException;
import com.exalt.coursemanagementplatform.mapper.LecturerMapper;
import com.exalt.coursemanagementplatform.models.Lecturer;
import com.exalt.coursemanagementplatform.repository.LecturerRepository;

import java.util.List;

/**
 * The LecturerService class is service for manipulating Lecturer data
 */
public class LecturerService implements ILecturerService {

    private LecturerRepository lecturerRepository;
    private LecturerMapper lecturerMapper;

    public LecturerDTO createLecturer(LecturerDTO lecturerDto) throws LecturerAlreadyExistsException {
        Lecturer lecturer = lecturerRepository.getLecturer(lecturerDto.getId());

        if(lecturer != null){
            throw new LecturerAlreadyExistsException();
        }

        lecturer = lecturerMapper.dtoToLecturer(lecturerDto);
        lecturer = lecturerRepository.saveLecturer(lecturer);
        LecturerDTO lecturerDTO = lecturerMapper.ToDTO(lecturer);
        return lecturerDTO;
    }

    public LecturerDTO updateLecturer(LecturerDTO lecturerDto) throws LecturerNotFoundException {
        Lecturer lecturer = lecturerRepository.getLecturer(lecturerDto.getId());

        if(lecturer == null){
            throw new LecturerNotFoundException();
        }

        lecturer = lecturerMapper.dtoToLecturer(lecturerDto);
        lecturer = lecturerRepository.saveLecturer(lecturer);
        LecturerDTO lecturerDTO = lecturerMapper.ToDTO(lecturer);
        return lecturerDTO;
    }

    public LecturerDTO getLecturer(String id) throws LecturerNotFoundException{
        Lecturer lecturer = lecturerRepository.getLecturer(id);

        if(lecturer == null){
            throw new LecturerNotFoundException();
        }

        return lecturerMapper.ToDTO(lecturer);
    }

    public List<LecturerDTO> getAllLecturers(){
        List<Lecturer> lecturers = lecturerRepository.getAllLecturers();
        return lecturerMapper.lecturersToDto(lecturers);
    }

    public void deleteLecturer(String id) throws LecturerNotFoundException{
        lecturerRepository.deleteLecturer(id);
    }
}
