package com.example.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.crud.model.LoanEntity;

import java.util.List;
 
@Repository
public interface LoanRepository extends JpaRepository<LoanEntity, Long> {

    @Query("select u from LoanEntity u where u.user_id = ?1")
    List<LoanEntity> findByUser_id(Long user_id);

}