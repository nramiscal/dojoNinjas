
package com.nramiscal.dojoNinjas.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="dojos")
public class Dojo {
	
	@Id
	@GeneratedValue
	@Column
	private Long id;
	
	@Column
	@Size(min=2, max=255)
	private String name;
	
	@Column
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date createdAt;
	
	@Column
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date updatedAt;
	
	@OneToMany(mappedBy="dojo", fetch=FetchType.LAZY)
	private List<Ninja> ninjas;
	
	public Dojo() {
		
	}
	
	public Dojo(String name) {
		this.name = name;
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
	
	@PrePersist
	protected void onCreate(){
	this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate(){
	this.updatedAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public List<Ninja> getNinjas() {
		return ninjas;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setNinjas(ArrayList<Ninja> ninjas) {
		this.ninjas = ninjas;
	}
	
	
}