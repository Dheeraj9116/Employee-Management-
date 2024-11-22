package com.Springpor.Springpor.Controller;

import com.Springpor.Springpor.Entity.Employee;
import com.Springpor.Springpor.Response.Response;
import com.Springpor.Springpor.Services.EmployeeService;
import com.Springpor.Springpor.dto.EmployeeDto;
import com.Springpor.Springpor.exception.BadRegister;
import com.Springpor.Springpor.exception.BadlogCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class EmployeeController {



    @Autowired
    private EmployeeService employeeService;


    @PostMapping("/register")
    public ResponseEntity<Response> registerEmployee(@RequestBody Employee employee) {
        Employee regEmp = employeeService.RegisterEmployee(employee);

        if (regEmp != null) {
            Response response = new Response();
            response.setStatus(HttpStatus.OK.value());
            response.setMessage("Employee Registered Successfully");
            response.setData(regEmp); // Assuming Response has a field for the data
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new BadRegister("Employee registration failed");
        }
    }

    @GetMapping("/GetAllEmp")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployee();
    }
    @PostMapping("/login")
    public ResponseEntity<Response> getEmployeesByMail(@RequestBody EmployeeDto employeeDto) {
        String tempEmail = employeeDto.getEmail();
        String tempPassword = employeeDto.getPassword();

        if (tempEmail == null || tempPassword == null) {
            throw new BadlogCredentials("Email or password must not be null");
        }

        Employee userObject = employeeService.getEmployeesByMail(tempEmail);

        // Check if user exists and password matches
        if (userObject == null || !userObject.getPassword().equals(tempPassword)) {
            throw new BadlogCredentials("Invalid login credentials");
        }

        // Prepare a response object
        Response response = new Response();
        response.setStatus(HttpStatus.OK.value());
        response.setMessage("Login successful");
        response.setData(userObject);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getEmployeeByid")
    public ResponseEntity<Response> getEmployeeById(@RequestParam Long id){

        employeeService.getEmployeeById(id);

    Response response=new Response();
    response.setStatus(HttpStatus.OK.value());
    response.setMessage("Employee id is: "+id);
    return new ResponseEntity<>(response,HttpStatus.OK);

    }
    @PutMapping("/updateEmployee")
    public Employee UpdateEmployee(@RequestHeader Long id,@RequestBody Employee employee) {
        Employee exsistingEmployee = employeeService.getEmployeeById(id);
        exsistingEmployee.setEid(employee.getEid());
        exsistingEmployee.setEname(employee.getEname());
        exsistingEmployee.setEaddress(employee.getEaddress());
        exsistingEmployee.setESalary(employee.getESalary());
        exsistingEmployee.setAge(employee.getAge());
        exsistingEmployee.setPassword(employee.getPassword());
        return  employeeService.UpdateEmployeeId(exsistingEmployee);
    }
    @DeleteMapping("/deleteEmployee")
    public String deleteEmployee(@RequestHeader Long id){
        employeeService.deleteEmployee(id);
        return "Employee deleted by this id"+id;

    }

}
