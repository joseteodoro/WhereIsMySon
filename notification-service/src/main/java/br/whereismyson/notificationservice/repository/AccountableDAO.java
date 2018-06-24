package br.whereismyson.notificationservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.whereismyson.notificationservice.model.Accountable;

@Repository
public interface AccountableDAO extends CrudRepository<Accountable, Long> {

	public Accountable findByDevice(String device);
	
}
