package br.whereismyson.registerservice.model;

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
	
	private Long homeLatitude;
	
	private Long homeLongitude;
	
	private Long usuallyOutsideLatitude;
	
	private Long usuallyOutsideLongitude;

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

	public long getHomeLatitude() {
		return homeLatitude;
	}

	public void setHomeLatitude(long homeLatitude) {
		this.homeLatitude = homeLatitude;
	}

	public long getHomeLongitude() {
		return homeLongitude;
	}

	public void setHomeLongitude(long homeLongitude) {
		this.homeLongitude = homeLongitude;
	}

	public long getUsuallyOutsideLatitude() {
		return usuallyOutsideLatitude;
	}

	public void setUsuallyOutsideLatitude(long usuallyOutsideLatitude) {
		this.usuallyOutsideLatitude = usuallyOutsideLatitude;
	}

	public long getUsuallyOutsideLongitude() {
		return usuallyOutsideLongitude;
	}

	public void setUsuallyOutsideLongitude(long usuallyOutsideLongitude) {
		this.usuallyOutsideLongitude = usuallyOutsideLongitude;
	}
	
}
