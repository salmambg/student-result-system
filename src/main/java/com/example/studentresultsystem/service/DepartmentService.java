package com.example.studentresultsystem.service;

import com.example.studentresultsystem.entity.Department;
import com.example.studentresultsystem.exception.UserNotFoundException;
import com.example.studentresultsystem.repository.DepartmentRepository;
import com.example.studentresultsystem.utils.Constants;
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
public class DepartmentService {
    private static Logger LOG = LoggerFactory.getLogger(DepartmentService.class);

    @Autowired
    private DepartmentRepository departmentRepository;


    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department create(Department department) throws UserNotFoundException {
        try {
            return departmentRepository.save(department);
        } catch (DataIntegrityViolationException | ConstraintViolationException exception) {
            LOG.warn(Constants.DATA_VIOLATION + exception.getMessage());
            throw new UserNotFoundException(Constants.ALREADY_EXISTS);
        }
    }
        public Department getByID (int id) throws UserNotFoundException {
            Optional<Department> department = departmentRepository.findById(id);
            if (department.isPresent()) {
                return department.get();
            } else {
                throw new UserNotFoundException("department id not found: " + id);
            }
        }
    public Department update(Department department) throws UserNotFoundException {
       Department existingDepartment = getByID(department.getId());
        BeanUtils.copyProperties(department, existingDepartment, "id");
        try {
            return departmentRepository.save(existingDepartment);
        } catch (DataIntegrityViolationException | ConstraintViolationException exception) {
            LOG.warn(Constants.DATA_VIOLATION + exception.getMessage());
            throw new UserNotFoundException(Constants.ALREADY_EXISTS);
        }
    }
        public void deleteDepartment (int id) throws UserNotFoundException {
            try {
                departmentRepository.deleteById(id);
            } catch (Exception exception) {
                throw new UserNotFoundException("department id not found: " + id);
            }
        }
}
