package com.brs.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brs.entity.Route;

@Service
@Transactional
public interface IRouteService {
	public Route addRoute(Route route);

	public Route updateRoute(Route route);

	public Route viewRoute(long routeid);

	public Route deleteRoute(long routeId);

	public List<Route> viewAllRoute();

}