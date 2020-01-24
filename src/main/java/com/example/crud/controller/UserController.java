package com.example.crud.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.exception.RecordNotFoundException;
import com.example.crud.model.UserEntity;
import com.example.crud.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUser() {
        final List<UserEntity> list = service.getAllUsers();

        return new ResponseEntity<List<UserEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getEmployeeById(@PathVariable("id") final Long id) throws RecordNotFoundException {
        final UserEntity entity = service.getUserById(id);

        return new ResponseEntity<UserEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }

}