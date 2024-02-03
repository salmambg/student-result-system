package com.example.studentresultsystem.service;

import com.example.studentresultsystem.entity.Semester;
import com.example.studentresultsystem.exception.UserNotFoundException;
import com.example.studentresultsystem.repository.SemesterRepository;
import com.example.studentresultsystem.utils.Constants;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SemesterService {
    private static Logger LOG = LoggerFactory.getLogger(SemesterService.class);

    @Autowired
    SemesterRepository semesterRepository;

    public List<Semester> getAllSemesters() {
        return semesterRepository.findAll();
    }

    public Semester create(Semester semester) throws UserNotFoundException {
        try {
            return semesterRepository.save(semester);
        } catch (DataIntegrityViolationException | ConstraintViolationException exception) {
            LOG.warn(Constants.DATA_VIOLATION + exception.getMessage());
            throw new UserNotFoundException(Constants.ALREADY_EXISTS);
        }
    }
    public Semester getByID (int id)  {
        Optional<Semester> semester = semesterRepository.findById(id);
        if (semester.isPresent()) {
            return semester.get();
        } else {
            LOG.warn(Constants.SEMESTER_NOT_FOUND + id);
            throw new EntityNotFoundException(Constants.SEMESTER_NOT_FOUND + id);
        }
    }
    public Semester update(Semester semester) throws UserNotFoundException {
      Semester existingSemester = getByID(semester.getId());
        BeanUtils.copyProperties(semester, existingSemester, "id");
        try {
            return semesterRepository.save(existingSemester);
        } catch (DataIntegrityViolationException | ConstraintViolationException exception) {
            LOG.warn(Constants.DATA_VIOLATION + exception.getMessage());
            throw new UserNotFoundException(Constants.ALREADY_EXISTS);
        }
    }
    public void deleteById(Integer id) {
        try {
            semesterRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            LOG.warn(Constants.SEMESTER_NOT_FOUND + id);
            throw new EntityNotFoundException(Constants.SEMESTER_NOT_FOUND+ id);
        }
    }
}

