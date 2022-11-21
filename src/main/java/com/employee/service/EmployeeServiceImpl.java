package com.employee.service;

import com.employee.entity.CompanyEntity;
import com.employee.entity.EmployeeEntity;
import com.employee.exception.DataNotFoundException;
import com.employee.model.Company;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private CompanyService companyService;
    private ModelMapper modelMapper;

    EmployeeServiceImpl(EmployeeRepository employeeRepository, CompanyService companyService, ModelMapper modelMapper){
        this.employeeRepository = employeeRepository;
        this.companyService = companyService;
        this.modelMapper = modelMapper;
    }

    @Override
    public int save(final Employee employee) {

        EmployeeEntity employeeEntity = new EmployeeEntity();
        modelMapper.map(employee, employeeEntity);
        employeeRepository.save(employeeEntity);
        return employeeEntity.getId();
    }

    @Override
    public List<Employee> getAll() {

        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        List<Employee> employees = modelMapper.map(employeeEntities, new TypeToken<List<Employee>>() {}.getType());
        return employees;
    }

    @Override
    public Employee getById(Integer id) {

        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Employee not found"));
        Employee employee = new Employee();
        modelMapper.map(employeeEntity, employee);
        return employee;
    }

    @Override
    public void delete(Integer id){
        employeeRepository.deleteById(id);
    }
}
