package com.sushree.sahayatri.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*Error*/

@Entity
@Table(name="group")

public class Group {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@OneToOne
	@JoinColumn(name="packageId")
	private Package packages;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Package getPackages() {
		return packages;
	}

	public void setPackages(Package packages) {
		this.packages = packages;
	}
	
	
	
}
