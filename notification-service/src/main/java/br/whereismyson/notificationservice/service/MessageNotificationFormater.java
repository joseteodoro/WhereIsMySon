package br.whereismyson.notificationservice.service;

import org.springframework.stereotype.Component;

import br.whereismyson.notificationservice.model.GeoPosition;

@Component
public class MessageNotificationFormater {

	public String formatDeviationMessage(GeoPosition geoPosition) {
		return String.format("Dear friend, we just noticed a anomaly on the path that the device %s usually take. "
				+ "Please take a look on that and call the device if you are no aware of that devition.\n"
				+ "Following device's position [latitute: %d, longitude: %d]", geoPosition.getLatitude(), geoPosition.getLongitude());
	}

}
