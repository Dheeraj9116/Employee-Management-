package com.Springpor.Springpor.Services;

import com.Springpor.Springpor.Entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee RegisterEmployee(Employee employee);
    List<Employee> getAllEmployee();
    Employee getEmployeesByMail(String email);
    Employee getEmployeeById(Long id);
    Employee UpdateEmployeeId(Employee employee);
    void deleteEmployee(Long id);
}
