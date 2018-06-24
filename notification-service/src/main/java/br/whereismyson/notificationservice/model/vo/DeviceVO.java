package br.whereismyson.notificationservice.model.vo;

public class DeviceVO {
	
	private Long id;
	
	private String label;
	
	private String accountableEmail;

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

	public String getAccountableEmail() {
		return accountableEmail;
	}

	public void setAccountableEmail(String accountableEmail) {
		this.accountableEmail = accountableEmail;
	}

	
	
}
