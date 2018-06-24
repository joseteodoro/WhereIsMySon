package br.whereismyson.notificationservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.whereismyson.notificationservice.anomalyDetection.AnomalyDetector;
import br.whereismyson.notificationservice.model.Device;
import br.whereismyson.notificationservice.model.GeoPosition;
import br.whereismyson.notificationservice.notification.NotificationSenderService;
import br.whereismyson.notificationservice.repository.DeviceDAO;

@Component
public class GeoPositionService {

	@Autowired
	private AnomalyDetector anomalyDetector;

	@Autowired
	private NotificationSenderService notificationSenderService;

	@Autowired
	private DeviceDAO deviceDAO;

	public void processGeoPosition(GeoPosition readValue) {
		if (this.anomalyDetector.hasAnomaly(readValue)) {
			Optional<Device> deviceFound = deviceDAO.findById(readValue.getDeviceId());
			if (deviceFound.isPresent()) {
				notificationSenderService.sendDeviationNotification(deviceFound.get().getAccountableEmailAdress(),
						readValue);
				System.out.println("########################### anomlay detected for: " + readValue.getDeviceId());
			} else {
				// should ignore if does not find the device?
			}
		}
	}

}
