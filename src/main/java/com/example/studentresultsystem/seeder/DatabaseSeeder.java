package com.example.studentresultsystem.seeder;

import com.example.studentresultsystem.entity.Department;
import com.example.studentresultsystem.entity.Student;
import com.example.studentresultsystem.repository.DepartmentRepository;
import com.example.studentresultsystem.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder {
    private static final Logger logger = LoggerFactory.getLogger(DatabaseSeeder.class);

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        logger.info("Run Seeder --------------------------");
        seedDepartmentData();
        seedStudentData();
        logger.info("End Seeder --------------------------");
    }
    private void seedDepartmentData() {
        List<Department> departments = new ArrayList<>();

        Department department1 = new Department();
        department1.setId(10001);
        department1.setName("CSTE");
        departments.add(department1);

        Department department2 = new Department();
        department2.setId(10002);
        department2.setName("MBG");
        departments.add(department2);

        departmentRepository.saveAll(departments);
    }
    private void seedStudentData() {
        List<Student> students = new ArrayList<>();

        Student student1 = new Student();
        student1.setId(20001);
        student1.setName("Salma");
        student1.setGender("female");
        student1.setRollNumber(1);
        student1.setGrade('A');
        students.add(student1);

        Student student2 = new Student();
        student2.setId(20002);
        student2.setName("Samiha");
        student2.setGender("female");
        student2.setRollNumber(2);
        student2.setGrade('A');
        students.add(student2);

        Student student3 = new Student();
        student3.setId(20003);
        student3.setName("Sabiha");
        student3.setGender("female");
        student3.setRollNumber(3);
        student3.setGrade('A');
        students.add(student3);

        Student student4 = new Student();
        student4.setId(20004);
        student4.setName("Momo");
        student4.setGender("female");
        student4.setRollNumber(4);
        student4.setGrade('A');
        students.add(student4);

        studentRepository.saveAll(students);
    }
    private void seedStudentCourseData() {
        List<Student> students = new ArrayList<>();

        Department department1 = departmentRepository.findById(10001).orElse(null);
        if (department1 != null) {
            List<Department> departmentArrayList = new ArrayList<>();
            departmentArrayList.add(department1);
            Student student1= studentRepository.findById(20001).orElse(null);
            student1.setDepartments(departmentArrayList);
            students.add(student1);
        }

        Department department2 = departmentRepository.findById(10001).orElse(null);
        if (department2 != null) {
            List<Department> departmentArrayList = new ArrayList<>();
            departmentArrayList.add(department2);
            Student student2= studentRepository.findById(20002).orElse(null);
            student2.setDepartments(departmentArrayList);
            students.add(student2);
        }

        Department department3 = departmentRepository.findById(10002).orElse(null);
        if (department3 != null) {
            List<Department> departmentArrayList = new ArrayList<>();
            departmentArrayList.add(department3);
            Student student3= studentRepository.findById(20003).orElse(null);
            student3.setDepartments(departmentArrayList);
            students.add(student3);
        }
        Department department4 = departmentRepository.findById(10002).orElse(null);
        if (department4 != null) {
            List<Department> departmentArrayList = new ArrayList<>();
            departmentArrayList.add(department4);
            Student student4= studentRepository.findById(20004).orElse(null);
            student4.setDepartments(departmentArrayList);
            students.add(student4);
        }
        studentRepository.saveAll(students);
    }
}
