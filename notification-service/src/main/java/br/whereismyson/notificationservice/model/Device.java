package br.whereismyson.notificationservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Device {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String label;
	
	private String accountableEmailAdress;

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

	public String getAccountableEmailAdress() {
		return accountableEmailAdress;
	}

	public void setAccountableEmailAdress(String accountableEmailAdress) {
		this.accountableEmailAdress = accountableEmailAdress;
	}

}
