package com.example.studentresultsystem;

import com.example.studentresultsystem.dto.dsdto.DepartmentRequest;
import com.example.studentresultsystem.dto.dsdto.StudentRequest;
import com.example.studentresultsystem.dto.ssdto.SemesterRequest;
import com.example.studentresultsystem.dto.ssdto.SubjectRequest;
import com.example.studentresultsystem.entity.Department;
import com.example.studentresultsystem.entity.Semester;
import com.example.studentresultsystem.entity.Student;
import com.example.studentresultsystem.entity.Subject;
import java.util.ArrayList;
import java.util.List;

public class TestData {
    private TestData() {
    }
    public static final Integer departmentID = 1;
    public static final String departmentName = "CSTE";
    private static final Integer studentId = 1;
    public static final String studentName = "Salma";
    private static final String gender = "Female";
    private static final String grade = "A";
    private static final Integer rollNumber = 1;

    public static final Integer semesterId = 1;
    public static final String semesterName = "Semester1";
    private static final Integer subjectID = 1;
    private static final String subjectName = "English";


    public static DepartmentRequest createDepartmentRequest() {
        return new DepartmentRequest(
                departmentName
        );
    }
    public static StudentRequest createStudentRequest() {
        return new StudentRequest(
                studentName,
                gender,
                grade,
                rollNumber
        );
    }
    public static SemesterRequest createSemesterRequest() {
        return new SemesterRequest(
                semesterName
        );
    }
    public static SubjectRequest createSubjectRequest() {
        return new SubjectRequest(
                subjectName
        );
    }

    public static Department createDepartment() {
        return new Department(
                departmentID,
                departmentName
        );
    }
    public static Student createStudent() {
        Department department = new Department();
        department.setId(TestData.departmentID);
        return new Student(
                studentId,
                studentName,
                gender,
                grade,
                rollNumber,
                department
        );
    }

    public static Department createDepartmentWithStudents() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(createStudent());
        return new Department(
                departmentID,
                departmentName,
                studentList
        );
    }
    public static Department createUpdatedDepartment() {
        return new Department(
                departmentID,
                departmentName + " update"
        );
    }

    public static Student createUpdatedStudent() {
        Department department = new Department();
        department.setId(TestData.departmentID);
        return new Student(
                studentId,
                studentName + " update",
                grade + " update",
                gender + "update",
                department
        );
    }
    public static Semester createSemester() {
        return new Semester(
                semesterId,
                semesterName
        );
    }
    public static Subject createSubject() {
        Semester semester = new Semester();
        semester.setId(TestData.semesterId);
        return new Subject(
                subjectID,
                subjectName,
                semester
        );
    }

    public static Semester createSemesterWithSubjects() {
        List<Subject> subjectList = new ArrayList<>();
        subjectList.add(createSubject());
        return new Semester(
                semesterId,
                semesterName,
                subjectList
        );
    }
}

