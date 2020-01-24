package com.example.crud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.exception.RecordNotFoundException;
import com.example.crud.model.LoanEntity;
//import com.example.crud.exception.RecordNotFoundException;
import com.example.crud.repository.LoanRepository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

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
        if (list.size() > 0) {
            return list;
        } else {
            return new ArrayList<LoanEntity>();
        }
    }

    public List<LoanEntity> getLoansByUser_IdPageable(Long id, int page, int size) throws RecordNotFoundException {
        Pageable pagination = PageRequest.of(page, size);
        List<LoanEntity> list;
        if (id != -1) {
            list = repository.findByUser_id(id, pagination);
        } else {
            list = repository.findAll(pagination).getContent();
        }
        if (list.size() > 0) {
            return list;
        } else {
            return new ArrayList<LoanEntity>();
        }
    }
}