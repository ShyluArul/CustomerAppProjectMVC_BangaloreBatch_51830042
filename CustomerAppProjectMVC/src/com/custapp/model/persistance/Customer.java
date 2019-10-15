package com.custapp.model.persistance;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "customer_table1")
public class Customer {
	@Id
	@GeneratedValue
	private int cusId;
	@NotEmpty(message = "name cant left blank")
	private String cusName;
	@NotEmpty(message = "phoneno cant left blank")
	private String phNo;

	@Email
	@NotEmpty(message = "email cant left blank")
	private String email;

	public int getCusId() {
		return cusId;
	}

	public void setCusId(int cusId) {
		this.cusId = cusId;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getPhNo() {
		return phNo;
	}

	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Customer(String cusName, String phNo, String email) {

		this.cusName = cusName;
		this.phNo = phNo;
		this.email = email;
	}

	public Customer(int cusId, String cusName, String phNo, String email) {
		super();
		this.cusId = cusId;
		this.cusName = cusName;
		this.phNo = phNo;
		this.email = email;
	}

	public Customer() {

		// TODO Auto-generated constructor stub
	}

}
