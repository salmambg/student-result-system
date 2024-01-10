package com.example.studentresultsystem.service;

import com.example.studentresultsystem.dto.StudentRequest;
import com.example.studentresultsystem.entity.Student;
import com.example.studentresultsystem.exception.UserNotFoundException;
import com.example.studentresultsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    public Student saveStudent(StudentRequest studentRequest) throws UserNotFoundException {
        Student student = Student.build(0, studentRequest.getName(), studentRequest.getGrade(),studentRequest.getGender(),
                Integer.valueOf(studentRequest.getRollNumber()), studentRequest.getDepartments());
        return studentRepository.save(student);
    }

    public Student getStudent(int id) throws UserNotFoundException {
        Student student = studentRepository.findByStudentId(id);
        if (student!= null) {
            return student;
        }else {
            throw new UserNotFoundException("student id not found: " + id);
        }
    }
    public Student updateStudent(int id, StudentRequest studentRequest) throws UserNotFoundException {
        Student existingStudent= getStudent(id);
        if (existingStudent!= null) {
            return existingStudent;
        }else {
            throw new UserNotFoundException("student id not found: " + id);
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
