package br.whereismyson.notificationservice.model;

import javax.persistence.Entity;

@Entity
public class Accountable {
	
	private String emailAdress;
	
	

	public String getEmailAdress() {
		return emailAdress;
	}

	public void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
	}

}
