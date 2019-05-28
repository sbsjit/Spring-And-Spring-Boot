package com.sushree.sahayatri.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name="Package")
@EntityListeners(AuditingEntityListener.class)
public class Package {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="PackageName")
	private String name;
	
	@Column(name="NumberOfDays")
	private int days;
	
	
	@ManyToMany
	//Many to many case requires joining the entire table and not only just the columns
	@JoinTable(name="packageDestination", joinColumns = {@JoinColumn(name="packageId")}, inverseJoinColumns = {@JoinColumn(name="destinationId")})
	//joinColumns=package table column name
	//InverseJoinColumns=destination table column name
	private List<Destination> Destination;
	//FetchType LAZY because it only fetches the data firing the query when necessary, so the data isn't fetched always which may full the buffer
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date createdAt;
	
	public int getId() {
		return id;
	}

	public List<Destination> getDestination() {
		return Destination;
	}

	public void setDestination(List<Destination> destination) {
		Destination = destination;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	
}
