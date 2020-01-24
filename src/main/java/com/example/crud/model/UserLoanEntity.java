package com.example.crud.model;

import java.util.ArrayList;
import java.util.List;

public class UserLoanEntity {

    public UserLoanEntity(UserEntity user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.first_name = user.getFirstName();
        this.last_name = user.getLastName();
        this.loan = new ArrayList<LoanEntity>();
    }

    public UserLoanEntity(UserEntity user, List<LoanEntity> loans) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.first_name = user.getFirstName();
        this.last_name = user.getLastName();
        this.loan = loans;
    }

    public UserLoanEntity(Long idAux, String emailAux, String firstName, String lastName, List<LoanEntity> loans) {
        this.id = idAux;
        this.email = emailAux;
        this.first_name = firstName;
        this.last_name = lastName;
        this.loan = loans;
    }

    private Long id;

    private String email;

    private String first_name;

    private String last_name;

    private List<LoanEntity> loan;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String firstName) {
        this.first_name = firstName;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String lastName) {
        this.last_name = lastName;
    }

    public List<LoanEntity> getLoans() {
        return loan;
    }

    public void setLoans(List<LoanEntity> loans) {
        this.loan = loans;
    }

}