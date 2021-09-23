package com.brs.service;

import java.util.List;

import com.brs.entity.Bus;
import com.brs.exceptions.BusNotFoundException;

public interface IBusService {
	public Bus addBus(Bus bus);
	public Bus updateBus(Bus bus);
	public Bus deleteBus(int busId) throws BusNotFoundException;
    public Bus viewBus(int busId) throws BusNotFoundException;
    public List<Bus> viewBusByType(String busType) throws BusNotFoundException;
    public List<Bus> viewAllBus();
}