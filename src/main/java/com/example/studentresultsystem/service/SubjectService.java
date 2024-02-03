package com.example.studentresultsystem.service;

import com.example.studentresultsystem.entity.Subject;
import com.example.studentresultsystem.exception.UserNotFoundException;
import com.example.studentresultsystem.repository.SubjectRepository;
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
public class SubjectService {
    private static Logger LOG = LoggerFactory.getLogger(SubjectService.class);

    @Autowired
    SubjectRepository subjectRepository;

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Subject saveSubject(Subject subject) throws UserNotFoundException {
        try {
            return subjectRepository.save(subject);
        } catch (DataIntegrityViolationException | ConstraintViolationException exception) {
            LOG.warn(Constants.DATA_VIOLATION + exception.getMessage());
            throw new UserNotFoundException(Constants.ALREADY_EXISTS);
        }
    }
    public Subject getByID (int id)  {
        Optional<Subject> subject = subjectRepository.findById(id);
        if (subject.isPresent()) {
            return subject.get();
        } else {
            LOG.warn(Constants.SUBJECT_NOT_FOUND + id);
            throw new EntityNotFoundException(Constants.SUBJECT_NOT_FOUND + id);
        }
    }
    public Subject update(Subject subject) throws UserNotFoundException {
        Subject existingSubject = getByID(subject.getId());
        BeanUtils.copyProperties(subject, existingSubject, "id");
        try {
            return subjectRepository.save(existingSubject);
        } catch (DataIntegrityViolationException | ConstraintViolationException exception) {
            LOG.warn(Constants.DATA_VIOLATION + exception.getMessage());
            throw new UserNotFoundException(Constants.ALREADY_EXISTS);
        }
    }
    public void deleteBySubjectId(Integer id) {
        try {
            subjectRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            LOG.warn(Constants.SUBJECT_NOT_FOUND + id);
            throw new EntityNotFoundException(Constants.SUBJECT_NOT_FOUND+ id);
        }
    }
}
