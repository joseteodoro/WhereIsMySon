package br.whereismyson.notificationservice.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import br.whereismyson.notificationservice.model.GeoPosition;
import br.whereismyson.notificationservice.service.MessageNotificationFormater;

@Component
public class NotificationSenderService {

	@Autowired
	public JavaMailSender emailSender;

	@Autowired
	public MessageNotificationFormater messageNotificationFormater;

	public void sendDeviationNotification(String accountableEmailAdress, GeoPosition geoPosition) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(accountableEmailAdress);
		message.setSubject(String.format("Deviation of %s", geoPosition.getDeviceId()));
		message.setText(messageNotificationFormater.formatDeviationMessage(geoPosition));
		emailSender.send(message);
	}

}
