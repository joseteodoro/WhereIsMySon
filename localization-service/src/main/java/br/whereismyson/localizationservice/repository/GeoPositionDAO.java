package br.whereismyson.localizationservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.whereismyson.localizationservice.model.GeoPosition;

@Repository
public interface GeoPositionDAO extends CrudRepository<GeoPosition, Long> {
	
}
