package com.example.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.example.crud.exception.RecordNotFoundException;
import com.example.crud.model.LoanEntity;
import com.example.crud.model.LoanOutEntity;
import com.example.crud.service.LoanService;

@RestController
@RequestMapping("/loan")
public class LoanController {
    @Autowired
    LoanService service;

    @GetMapping("/all")
    public ResponseEntity<List<LoanEntity>> getAllLoan() {
        final List<LoanEntity> list = service.getAllLoans();

        return new ResponseEntity<List<LoanEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public List<LoanEntity> getLoansByUser_Id(@PathVariable("id") final Long id) throws RecordNotFoundException {
        List<LoanEntity> entity = service.getLoansByUser_Id(id);
        return entity;
    }

    @GetMapping
    public LoanOutEntity getLoanByUser_Id(@RequestParam int page, @RequestParam int size,
            @RequestParam(required = false, defaultValue = "-1") String user_id) throws RecordNotFoundException {

        List<LoanEntity> entity = service.getLoansByUser_IdPageable(Long.parseLong(user_id), page, size);
        float total = 0;
        for (LoanEntity ent : entity) {
            total += ent.getTotal();
        }
        LoanOutEntity out = new LoanOutEntity(entity, page, size, total);
        return out;
    }

}