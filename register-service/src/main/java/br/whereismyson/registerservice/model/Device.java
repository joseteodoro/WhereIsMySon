package br.whereismyson.notificationservice.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Device {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String label;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Accountable accountable;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Accountable getAccountable() {
		return accountable;
	}

	public void setAccountable(Accountable accountable) {
		this.accountable = accountable;
	}
	
	

}
