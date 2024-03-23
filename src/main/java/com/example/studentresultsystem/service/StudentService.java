package com.example.studentresultsystem.service;

import com.example.studentresultsystem.entity.Student;
import com.example.studentresultsystem.exception.UserNotFoundException;
import com.example.studentresultsystem.repository.StudentRepository;
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
import java.util.UUID;

@Service
public class StudentService {
    private static Logger LOG = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private SemesterService semesterService;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    public Student saveStudent(Student student) throws UserNotFoundException {
        departmentService.getByID(student.getDepartment().getId());
        semesterService.getByID(student.getSemester().getId());
        try {
            return studentRepository.save(student);
        } catch (DataIntegrityViolationException | ConstraintViolationException exception) {
            LOG.warn(Constants.DATA_VIOLATION + exception.getMessage());
            throw new UserNotFoundException(Constants.ROLL_ALREADY_EXISTS);
        }
    }
    public List<Student> getAllStudentsByDepartment(int departmentId) {
        return studentRepository.findByDepartmentId(departmentId);
    }
    public List<Student> getAllStudentsBySemester(int semesterId) {
        return studentRepository.findBySemesterId(semesterId);
    }

    public List<Student> getAllStudentsByYear(int year) {
        return studentRepository.findByYear(year);
    }

    public Student getById(int id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return student.get();
        } else {
            LOG.warn(Constants.STUDENT_NOT_FOUND + id);
            throw new EntityNotFoundException(Constants.STUDENT_NOT_FOUND + id);
        }
    }

    public Student update(Student student) throws UserNotFoundException {
        Student existingStudent = getById(student.getId());
        BeanUtils.copyProperties(student, existingStudent,  "id");
        try {
            return studentRepository.save(existingStudent);
        } catch (DataIntegrityViolationException | ConstraintViolationException exception) {
            LOG.warn(Constants.DATA_VIOLATION + exception.getMessage());
            throw new UserNotFoundException(Constants.ALREADY_EXISTS);
        }
    }

    public void deleteByStudentId(Integer id) {
        try {
            studentRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            LOG.warn(Constants.STUDENT_NOT_FOUND + id);
            throw new EntityNotFoundException(Constants.STUDENT_NOT_FOUND + id);
        }
    }

}
