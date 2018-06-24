package br.whereismyson.registerservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.whereismyson.registerservice.exception.NotFoundException;
import br.whereismyson.registerservice.model.Device;
import br.whereismyson.registerservice.model.vo.DeviceVO;
import br.whereismyson.registerservice.model.vo.Position;
import br.whereismyson.registerservice.repository.DeviceDAO;

@RestController
public class DeviceController {

	@Autowired
	private DeviceDAO dao;

	@PostMapping("/device")
	@ResponseStatus(HttpStatus.CREATED)
	public Device post(@RequestBody DeviceVO deviceVO) {
		if (deviceVO.getId() != null) {
			Optional<Device> deviceFound = dao.findById(deviceVO.getId());
			if (!deviceFound.isPresent()) {
				throw new NotFoundException("Device", String.format("id: [%s]", deviceVO.getId()));
			}
		}
		Device newDevice = new Device();
		newDevice.setAccountableEmailAdress(deviceVO.getAccountableEmail());
		newDevice.setLabel(deviceVO.getLabel());
		return dao.save(newDevice);
	}

	@PostMapping("/device/{deviceId}")
	public Device post(@PathVariable("deviceId") Long deviceId, @RequestBody DeviceVO deviceVO) {
		Optional<Device> deviceFound = dao.findById(deviceId);
		if (!deviceFound.isPresent()) {
			throw new NotFoundException("Device", String.format("id: [%s]", deviceVO.getId()));
		}

		Device device = deviceFound.get();
		device.setAccountableEmailAdress(deviceVO.getAccountableEmail());
		device.setLabel(deviceVO.getLabel());
		return dao.save(device);
	}
	
	@PostMapping("/device/{deviceId}/home")
	public Device postHome(@PathVariable("deviceId") Long deviceId, @RequestBody Position position) {
		Optional<Device> deviceFound = dao.findById(deviceId);
		if (!deviceFound.isPresent()) {
			throw new NotFoundException("Device", String.format("id: [%s]", deviceId));
		}

		Device device = deviceFound.get();
		device.setHomeLatitude(position.getLatitude());
		device.setHomeLongitude(position.getLongitude());
		return dao.save(device);
	}
	
	@PostMapping("/device/{deviceId}/usualOutsidePlace")
	public Device postUsualOutsidePlace(@PathVariable("deviceId") Long deviceId, @RequestBody Position position) {
		Optional<Device> deviceFound = dao.findById(deviceId);
		if (!deviceFound.isPresent()) {
			throw new NotFoundException("Device", String.format("id: [%s]", deviceId));
		}

		Device device = deviceFound.get();
		device.setUsuallyOutsideLatitude(position.getLatitude());
		device.setUsuallyOutsideLongitude(position.getLongitude());
		return dao.save(device);
	}

}
