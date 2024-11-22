package com.Springpor.Springpor.exception;

import com.Springpor.Springpor.Response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException{
  @ExceptionHandler(value = ResourceNotFoundClass.class)
  public ResponseEntity<String> handleStudentNotFoundException(ResourceNotFoundClass resourceNotFoundClass){
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resourceNotFoundClass.getMessage());

  }

  @ExceptionHandler(value = BadlogCredentials.class)
  public  ResponseEntity<Object> handleBadlogCredentials(BadlogCredentials badlogCredentials){
    Response loginError=new Response(HttpStatus.BAD_REQUEST.value(), badlogCredentials.getMessage());
    return new ResponseEntity<>(loginError,HttpStatus.BAD_REQUEST);
  }
  @ExceptionHandler(value = BadRegister.class)
  public  ResponseEntity<Object> handleBadRegister(BadRegister badRegister) {
    Response RegisterError = new Response(HttpStatus.BAD_REQUEST.value(), badRegister.getMessage());
    return new ResponseEntity<>(RegisterError, HttpStatus.BAD_REQUEST);
  }

   @ExceptionHandler(value = UserAlreadyExsist.class)
    public ResponseEntity<Object> handleUserAlreadyExsist(UserAlreadyExsist userAlreadyExsist){
     Response Error = new Response(HttpStatus.BAD_REQUEST.value(), userAlreadyExsist.getMessage());
     return new ResponseEntity<>(Error, HttpStatus.BAD_REQUEST);
  }

}
