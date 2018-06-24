package br.whereismyson.notificationservice.anomalyDetection;

import org.springframework.stereotype.Component;

import br.whereismyson.notificationservice.model.GeoPosition;

@Component
public class AnomalyDetector {

	public Boolean hasAnomaly(GeoPosition geoPosition) {
		return false;
	}
	
}
