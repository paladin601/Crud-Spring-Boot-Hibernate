package com.example.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LOAN")
public class LoanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="total")
    private float total;
    
    @Column(name="user_id")
    private Long user_id;
    
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
    }

	public float getFirstName() {
		return total;
	}

	public void setFirstName(float totalAux) {
		this.total = totalAux;
	}

	public Long getUserId() {
		return user_id;
	}

	public void setUserId(Long user_id_aux) {
		this.user_id = user_id_aux;
	}

}