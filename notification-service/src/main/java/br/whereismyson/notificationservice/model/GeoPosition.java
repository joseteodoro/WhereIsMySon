package br.whereismyson.notificationservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class GeoPosition {

	@Id
	@GeneratedValue
	private Long id;

	private long timestamp;

	private long longitude;

	private long latitude;

	private long deviceId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public long getLongitude() {
		return longitude;
	}

	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}

	public long getLatitude() {
		return latitude;
	}

	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}

	public long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(long deviceId) {
		this.deviceId = deviceId;
	}

	@Override
	public String toString() {
		return "GeoPosition [timestamp=" + timestamp + ", longitude=" + longitude + ", latitude=" + latitude
				+ ", deviceId=" + deviceId + "]";
	}

}
