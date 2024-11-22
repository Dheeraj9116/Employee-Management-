package com.Springpor.Springpor.Services.impl;

import com.Springpor.Springpor.Entity.Employee;
import  com.Springpor.Springpor.exception.ResourceNotFoundClass;
import com.Springpor.Springpor.Repository.EmployeeRepository;
import com.Springpor.Springpor.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Repository
@Service
public class EmployeeServiceimpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee RegisterEmployee(Employee employee) {
      return   employeeRepository.save(employee);

    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeesByMail(String email) {
        Employee employees= employeeRepository.findByEmail(email);
        return  employees;


    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundClass("Id not found"+id));
    }

    @Override
    public Employee UpdateEmployeeId(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
    employeeRepository.deleteById(id);
    }
}
