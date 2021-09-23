package com.brs.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.brs.exceptions.BusNotFoundException;
import com.brs.entity.Bus;
import com.brs.repository.IBusRepository;

@Service
@Transactional
/**
 * Description:This is Bus Service Class that provides the services to add a
 * bus, remove a bus, update a bus and view a bus
 **/
public class BusService implements IBusService {
	@Autowired
	private IBusRepository busrepo;

	/**
	 * Description :To add Bus to the database Input Params :Bus object to be added
	 * to the database Return Value :Bus Object 
	 **/
	@Override
	public Bus addBus(Bus bus) {
		return busrepo.save(bus);
	}

	/**
	 * Description :To update Bus in the database Input Params :Bus object to be
	 * added to the database Return Value :Bus Object Exception
	 * :BusNotFoundException-raised when bus Id not found
	 **/
	@Override
	public Bus updateBus(Bus bus) throws NullPointerException {
		Bus updateBus = null;
		try {
			updateBus = busrepo.findById(bus.getBusId()).orElseThrow(BusNotFoundException::new);

		} catch (BusNotFoundException e) {
			e.printStackTrace();
		}
		updateBus.setBusId(bus.getBusId());
		updateBus.setBusName(bus.getBusName());
		updateBus.setDriverName(bus.getDriverName());
		updateBus.setBusType(bus.getBusType());
		updateBus.setRouteFrom(bus.getRouteFrom());
		updateBus.setRouteTo(bus.getRouteTo());
		updateBus.setArrivalTime(bus.getArrivalTime());
		updateBus.setDepartureTime(bus.getDepartureTime());
		updateBus.setSeats(bus.getSeats());
		updateBus.setAvaiableSeats(bus.getAvaiableSeats());
		return busrepo.save(updateBus);

	}

	/**
	 * Description :To delete Bus from the database Input Params :Bus object to be
	 * deleted from the database Return Value :Bus Object Exception
	 * :BusNotFoundException-raised when bus Id not found
	 **/
	@Override
	public Bus deleteBus(int busId) {
		Bus bus = null;
		try {
			bus = busrepo.findById(busId).orElseThrow(BusNotFoundException::new);
			busrepo.delete(bus);
		} catch (BusNotFoundException e) {
			e.printStackTrace();
		}
		return bus;
	}

	/**
	 * Description :To view Bus in the database Input Params :Bus id whose bus
	 * object should be viewed in the database Return Value :Bus Object Exception
	 * :BusNotFoundException-raised when bus Id not found
	 **/
	@Override
	public Bus viewBus(int busId) throws BusNotFoundException {
		Bus b = null;
		try {
			b = busrepo.findById(busId).orElseThrow(BusNotFoundException::new);
		} catch (BusNotFoundException e) {
			e.printStackTrace();
		}
		return b;
	}

	/**
	 * Description :To view Bus in the database Input Params :Bus type whose bus
	 * object should be viewed in the database Return Value :Bus Object Exception
	 * :BusNotFoundException-raised when bus type not found
	 **/

	@Override
	public List<Bus> viewBusByType(String busType) throws BusNotFoundException {

		return null;
	}

	/**
	 * Description :To view all the Bus in the database Return Value :list of Bus
	 * Objects
	 **/
	@Override
	public List<Bus> viewAllBus() {

		return busrepo.findAll();
	}
}