package com.Springpor.Springpor.Response;


import com.Springpor.Springpor.Entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Response {

    private int status;
    private String message;


    public void setData(Employee regEmp) {
    }
}
