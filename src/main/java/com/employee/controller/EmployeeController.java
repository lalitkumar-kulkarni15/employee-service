package com.employee.controller;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@Validated
public class EmployeeController {

    private EmployeeService employeeService;

    EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @PostMapping("/employee")
    public Integer save(@RequestBody @Valid final Employee employee){
        return employeeService.save(employee);
    }

    @GetMapping("/employee/{id}")
    public Employee get(@PathVariable Integer id){
        return employeeService.getById(id);
    }

    @GetMapping("/employee")
    public List<Employee> get(){
        return employeeService.getAll();
    }

}
