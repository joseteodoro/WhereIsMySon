package br.whereismyson.notificationservice.aqmp;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import br.whereismyson.notificationservice.anomalyDetection.AnomalyDetector;
import br.whereismyson.notificationservice.model.GeoPosition;
import br.whereismyson.notificationservice.notification.NotificationSenderService;
import br.whereismyson.notificationservice.repository.AccountableDAO;

@Component
@EnableRabbit
public class AmqpListener {

	@Autowired
	private AnomalyDetector  anomalyDetector;
	
	@Autowired
	private NotificationSenderService notificationSenderService;
	
	@Autowired
	private AccountableDAO accountableDAO;
	
	@Bean
    public Jackson2JsonMessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }
	
	@Bean
    public Queue userQueue() {
       return new Queue(AmqpConfig.QUEUE_NAME);
    }
	
	//if used from the rabbit web console, must pass the `Properties` with 'content_type' = 'application/json' value
	@RabbitListener(queues = AmqpConfig.QUEUE_NAME)
	public void processUserMessage(GeoPosition readValue) {

		if (this.anomalyDetector.hasAnomaly(readValue)) {
			
			notificationSenderService.sendDeviationNotification(accountable, geoPosition);
		}
		System.out.println("########################### >>> Received from annotated component: " + readValue);
    }
	
}
