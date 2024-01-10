package com.example.studentresultsystem.service;

import com.example.studentresultsystem.dto.DepartmentRequest;
import com.example.studentresultsystem.entity.Department;
import com.example.studentresultsystem.entity.Student;
import com.example.studentresultsystem.exception.UserNotFoundException;
import com.example.studentresultsystem.repository.DepartmentRepository;
import com.example.studentresultsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private StudentRepository studentRepository;


    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
    public Department saveDepartment(DepartmentRequest departmentRequest) {
        Department department = new Department();
        department.setName(departmentRequest.getName());

        List<Student> studentNames = departmentRequest.getStudentNames();

        if (studentNames != null && !studentNames.isEmpty()) {
            List<Student> students = new ArrayList<>();

            for (Student studentName : studentNames) {
                Student student = new Student();
                student.setName(studentName.getName());
                student.setGrade(studentName.getGrade());
                student.setGender(studentName.getGender());
                student.setRollNumber(studentName.getRollNumber());
                student.setDepartments(studentName.getDepartments());
                students.add(studentRepository.save(student));
            }
            department.setStudents(students);
        }
        return departmentRepository.save(department);
    }
    public Department getDepartment(int id) throws UserNotFoundException {
        Department department = departmentRepository.findByDepartmentId(id);
        if (department!= null) {
            return department;
        }else {
            throw new UserNotFoundException("department id not found: " + id);
        }
    }
    public Department updateDepartment(int id, DepartmentRequest departmentRequest) throws UserNotFoundException {
        Department existingDepartment = getDepartment(id);
        return departmentRepository.save(existingDepartment);
    }

    public void deleteDepartment(int id) throws UserNotFoundException {
        try {
            departmentRepository.deleteById(id);
        } catch (Exception exception) {
            throw new UserNotFoundException("department id not found: " + id);
        }
    }

}
