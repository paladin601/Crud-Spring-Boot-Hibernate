package com.example.crud.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.exception.RecordNotFoundException;
import com.example.crud.model.LoanEntity;
import com.example.crud.model.UserEntity;
import com.example.crud.model.UserLoanEntity;
import com.example.crud.service.LoanService;
import com.example.crud.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService service;
    @Autowired
    LoanService serviceLoan;

    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUser() {
        final List<UserEntity> list = service.getAllUsers();

        return new ResponseEntity<List<UserEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserLoanEntity> getEmployeeById(@PathVariable("id") final Long id)
            throws RecordNotFoundException {
        UserEntity entity = service.getUserById(id);
        List<LoanEntity> loan = serviceLoan.getLoansByUser_Id(id);
        final UserLoanEntity entityFinish = new UserLoanEntity(entity, loan);
        return new ResponseEntity<UserLoanEntity>(entityFinish, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public HttpStatus createUser(UserEntity user) {
        service.createUser(user);
        return HttpStatus.OK;
    }

    @GetMapping("/delete/{id}")
    public HttpStatus deleteUserById(@PathVariable("id") Long id) throws RecordNotFoundException {
        service.deleteUserById(id);
        return HttpStatus.OK;
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus deleteMappingUserById(@PathVariable("id") Long id) throws RecordNotFoundException {
        service.deleteUserById(id);
        return HttpStatus.OK;
    }

}