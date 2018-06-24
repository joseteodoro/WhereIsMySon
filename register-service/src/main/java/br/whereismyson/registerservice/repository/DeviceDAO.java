package br.whereismyson.registerservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.whereismyson.registerservice.model.Device;

@Repository
public interface DeviceDAO extends CrudRepository<Device, Long> {

	public Device findByLabel(String label);
	
}
