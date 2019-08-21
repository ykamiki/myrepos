package com.internous.myecsite.model.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="test")
public class Test {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="d1")
	private Timestamp d1;
	
	@Column(name="d2")
	private Date d2;
	
	@Column(name="d3")
	private java.util.Date d3;

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Timestamp getD1() {
		return d1;
	}

	public void setD1(Timestamp d1) {
		this.d1 = d1;
	}

	public Date getD2() {
		return d2;
	}

	public void setD2(Date d2) {
		this.d2 = d2;
	}

	public java.util.Date getD3() {
		return d3;
	}

	public void setD3(java.util.Date d3) {
		this.d3 = d3;
	}
	
}
