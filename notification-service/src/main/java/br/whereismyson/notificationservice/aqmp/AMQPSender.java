package br.whereismyson.notificationservice.aqmp;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.whereismyson.notificationservice.model.GeoPosition;

@Component
public class AMQPSender {

	@Autowired
	AmqpTemplate template;
	
	@Autowired
	private ObjectMapper jacksonObjectMapper;
	
	public void send(GeoPosition position) throws JsonProcessingException {
		String json = jacksonObjectMapper.writeValueAsString(position);
		this.template.convertAndSend(AmqpConfig.QUEUE_NAME, json);
	}
	
}
