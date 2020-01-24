package com.example.crud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.exception.RecordNotFoundException;
import com.example.crud.model.LoanEntity;
//import com.example.crud.exception.RecordNotFoundException;
import com.example.crud.repository.LoanRepository;

@Service
public class LoanService {

    @Autowired
    LoanRepository repository;

    public List<LoanEntity> getAllLoans() {
        List<LoanEntity> list = repository.findAll();

        if (list.size() > 0) {
            return list;
        } else {
            return new ArrayList<LoanEntity>();
        }
    }

    public List<LoanEntity> getLoansByUser_Id(Long id) throws RecordNotFoundException {
        List<LoanEntity> list = repository.findByUser_id(id);
            return list;
       
    }
}