package com.example.studentresultsystem.service;

import com.example.studentresultsystem.entity.Department;
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
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private static Logger LOG = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private DepartmentService departmentService;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    public Student saveStudent(Student student) throws UserNotFoundException {
        departmentService.getByID(student.getDepartment().getId());
        try {
            return studentRepository.save(student);
        } catch (DataIntegrityViolationException | ConstraintViolationException exception) {
            LOG.warn(Constants.DATA_VIOLATION + exception.getMessage());
            throw new UserNotFoundException(Constants.ALREADY_EXISTS);
        }
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
        departmentService.getByID(student.getDepartment().getId());
        BeanUtils.copyProperties(student, existingStudent, "id");
        try {
            return studentRepository.save(existingStudent);
        } catch (DataIntegrityViolationException | ConstraintViolationException exception) {
            LOG.warn(Constants.DATA_VIOLATION + exception.getMessage());
            throw new UserNotFoundException(Constants.ALREADY_EXISTS);
        }
    }

    public void deleteStudent(int id) throws UserNotFoundException {
        try {
            studentRepository.deleteById(id);
        } catch (Exception exception) {
            throw new UserNotFoundException("student id not found: " + id);
        }
    }

}
