package com.example.crud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.exception.RecordNotFoundException;
//import com.example.crud.exception.RecordNotFoundException;
import com.example.crud.model.UserEntity;
import com.example.crud.repository.UserRepository;;
 
@Service
public class UserService {
     
    @Autowired
    UserRepository repository;
     
    public List<UserEntity> getAllUsers()
    {
        List<UserEntity> userList = repository.findAll();
         
        if(userList.size() > 0) {
            return userList;
        } else {
            return new ArrayList<UserEntity>();
        }
    }
     
    public UserEntity getUserById(Long id) throws RecordNotFoundException
    {
        Optional<UserEntity> user = repository.findById(id);
         
        if(user.isPresent()) {
            return user.get();
        } else {
            throw new RecordNotFoundException("User id invalid");
        }
    }

    public UserEntity createUser(UserEntity entity)
    {

        entity = repository.save(entity);
            
        return entity;
        
    }
     


    public void deleteUserById(Long id) throws RecordNotFoundException
    {
        Optional<UserEntity> employee = repository.findById(id);
         
        if(employee.isPresent())
        {
            



            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("Not found user id ");
        }
    }
}