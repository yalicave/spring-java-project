package com.newswathi.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import com.newswathi.School;

/**
 * Entity implementation class for Entity: SchoolEntity
 *
 */
@Entity

public class SchoolEntity implements Serializable {
	@Id 
	@GeneratedValue
	private Integer id;
	private String sName;
	private String sAddress;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsAddress() {
		return sAddress;
	}

	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}

	private static final long serialVersionUID = 1L;

	public SchoolEntity() {
		super();
	}
   
	public School toSchool() {
		School school = new School();
		school.setName(this.getsName());
		return school;
	}

	@Override
	public String toString() {
		return "SchoolEntity [id=" + id + ", sName=" + sName + ", sAddress=" + sAddress + "]";
	}
}
