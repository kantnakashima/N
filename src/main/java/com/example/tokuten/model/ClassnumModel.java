package com.example.tokuten.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="CLASS_NUM")
public class ClassnumModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long id;
	
	@Column(length = 3, nullable = false)
	private String SCHOOL_CD;
	
	@Column(length = 5, nullable = false)
	private String CLASS_NUM;
	
	public long getid() {
		return id;
	}
	public void setid(long id) {
		this.id = id;
	}
	
	public String getSCHOOL_CD() {
		return SCHOOL_CD;
	}
	
	public void setSCHOOL_CD(String SCHOOL_CD) {
		this.SCHOOL_CD = SCHOOL_CD;
	}
	public String getCLASS_NUM() {
		return CLASS_NUM;
	}
	
	public void setCLASS_NUM(String CLASS_NUM) {
		this.CLASS_NUM = CLASS_NUM;
	}
}