package com.sushree.sahayatri.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


/*Error*/

@Entity
@Table(name="group")
@EntityListeners(AuditingEntityListener.class)
public class Group {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int groupId;
	
	@OneToOne
	@JoinColumn(name="packageId")
	private Package packages;
	
	
	

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public Package getPackages() {
		return packages;
	}

	public void setPackages(Package packages) {
		this.packages = packages;
	}
	
	
}
