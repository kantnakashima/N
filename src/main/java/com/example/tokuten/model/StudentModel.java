package com.example.tokuten.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name="STUDENT")
public class StudentModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long id;
	
	@Column(length = 10, nullable = false)
	private String NO;
	
	@Column(length = 10, nullable = true)
	private String NAME;
	
	@Column(length = 10, nullable = true)
	private String ENT_YEAR;
	
	@Column(length = 3, nullable = true)
	private String CLASS_NUM;
	
	@Column
	private String IS_ATTEND;
	
	@Column(length = 3, nullable = true)
	private String SCHOOL_CD;
	
	public long getid() {
		return id;
	}
	public void setid(Long id) {
		this.id = id;
	}
	
	public String getNO() {
		return NO;
	}
	
	public void setNO(String NO) {
		this.NO = NO;
	}
	public String getNAME() {
		return NAME;
	}
	
	public void setNAME(String NAME) {
		this.NAME = NAME;
	}
	public String getENT_YEAR() {
		return ENT_YEAR;
	}
	
	public void setENT_YEAR(String ENT_YEAR) {
		this.ENT_YEAR = ENT_YEAR;
	}
	public String getCLASS_NUM() {
		return CLASS_NUM;
	}
	
	public void setCLASS_NUM(String CLASS_NUM) {
		this.CLASS_NUM = CLASS_NUM;
	}
	public String getIS_ATTEND() {
		return IS_ATTEND;
	}
	
	public void setIS_ATTEND(String IS_ATTEND) {
		this.IS_ATTEND = IS_ATTEND;
	}
	public String getSCHOOL_CD() {
		return SCHOOL_CD;
	}
	
	public void setSCHOOL_CD(String SCHOOL_CD) {
		this.SCHOOL_CD = SCHOOL_CD;
	}
}