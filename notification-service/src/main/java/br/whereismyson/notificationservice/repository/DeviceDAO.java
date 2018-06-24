package br.whereismyson.notificationservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.whereismyson.notificationservice.model.Device;

@Repository
public interface DeviceDAO extends CrudRepository<Device, Long> {

	public Device findByLabel(String label);
	
}
