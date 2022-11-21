package com.employee.service;

import com.employee.model.Employee;
import java.util.List;

public interface EmployeeService {

    int save(final Employee employee);
    List<Employee> getAll();
    Employee getById(Integer id);
    public void delete(Integer id);
}
