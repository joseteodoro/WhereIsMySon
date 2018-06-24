package br.whereismyson.notificationservice.model;

public class GeoPosition {
	
	private long timestamp;
	
	private long longitude;
	
	private long latitude;
	
	private String deviceId;

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

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	@Override
	public String toString() {
		return "GeoPosition [timestamp=" + timestamp + ", longitude=" + longitude + ", latitude=" + latitude
				+ ", deviceId=" + deviceId + "]";
	}
	
}
