package com.sahmwanga.demo.service;

import com.sahmwanga.demo.entity.Department;
import com.sahmwanga.demo.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> getDepartments();

    public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public void removeDepartmentById(Long departmentId);

    public Department updateDepartment(Long id, Department department);

    public Department getDepartmentByName(String departmentName);
}
