package br.whereismyson.localizationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.whereismyson.localizationservice.amqp.AMQPSender;
import br.whereismyson.localizationservice.model.GeoPosition;

@RestController
public class GeoPositionController {

	@Autowired
	private AMQPSender amqpSender;
	
	@PostMapping("/geoposition")
	@ResponseStatus(HttpStatus.CREATED)
	public GeoPosition post(@RequestBody GeoPosition position) {
		try {
			amqpSender.send(position);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			throw new RuntimeException("Could not place the geolocation");
		}
		return position;
	}
}