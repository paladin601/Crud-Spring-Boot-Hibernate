package com.example.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LOAN")
public class LoanEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "total", unique = false)
	private float total;

	@Column(name = "user_id", unique = false)
	private Long user_id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float totalAux) {
		this.total = totalAux;
	}

	public Long getUser_Id() {
		return user_id;
	}

	public void setUser_Id(Long user_id_aux) {
		this.user_id = user_id_aux;
	}

}