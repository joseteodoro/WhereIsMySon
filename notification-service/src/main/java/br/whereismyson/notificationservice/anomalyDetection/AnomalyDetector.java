package br.whereismyson.notificationservice.anomalyDetection;

import org.springframework.stereotype.Component;

import br.whereismyson.notificationservice.model.GeoPosition;

@Component
public class AnomalyDetector {

	// mock one, should be replaced with some machine learning code to use the geoposition to load the 
	// device usual positions and understand if there is a anomaly or not.
	public Boolean hasAnomaly(GeoPosition geoPosition) {
		return false;
	}
	
}
