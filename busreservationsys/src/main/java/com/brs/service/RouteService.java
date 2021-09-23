package com.brs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brs.entity.Route;
import com.brs.exceptions.RouteNotFoundException;
import com.brs.repository.IRouteRepository;

/**
 * Description:This is Route Service Class that provides the services to add a
 * Route, remove a Route, update a Route and view a Route
 **/

@Service
@Transactional
public class RouteService implements IRouteService {

	@Autowired
	private IRouteRepository routeRepo;

	/**
	 * Description :To add Route to the database Input Params :Route object to be
	 * added to the database Return Value :Route Object
	 **/

	@Override
	public Route addRoute(Route route) {

		Route newRoute = routeRepo.save(route);
		System.out.println(newRoute + "******");
		return newRoute;

	}

	/**
	 * Description :To update Route in the database Input Params :Route object to be
	 * added to the database Return Value :Route Object Exception
	 * :RouteNotFoundException-raised when Route Id not found
	 **/

	@Override
	public Route updateRoute(Route route) throws NullPointerException {

		Route retrievedRoute = null;
		try {
			retrievedRoute = routeRepo.findById(route.getRouteId()).orElseThrow(RouteNotFoundException::new);
		} catch (Exception e) {
			e.printStackTrace();
		}
		retrievedRoute.setRouteId(route.getRouteId());
		retrievedRoute.setRouteFrom(route.getRouteFrom());
		retrievedRoute.setRouteTo(route.getRouteTo());
		retrievedRoute.setDistance(route.getDistance());

		return routeRepo.save(retrievedRoute);

	}

	/**
	 * Description :To view Route in the database Input Params :Route id whose Route
	 * object should be viewed in the database Return Value :Route Object Exception
	 * :RouteNotFoundException-raised when Route Id not found
	 **/

	@Override
	public Route viewRoute(long id) {

		Route retVal = null;
		try {
			retVal = routeRepo.findById(id).orElseThrow(RouteNotFoundException::new);
		} catch (RouteNotFoundException e) {
			e.printStackTrace();
		}
		return retVal;

	}

	/**
	 * Description :To delete Route from the database Input Params :Route object to
	 * be deleted from the database Return Value :Route Object Exception
	 * :RouteNotFoundException-raised when Route Id not found
	 **/

	@Override
	public Route deleteRoute(long id) {

		Route retrVal = null;
		try {
			retrVal = routeRepo.findById(id).orElseThrow(RouteNotFoundException::new);
			routeRepo.deleteById(id);

		} catch (RouteNotFoundException e) {

			e.printStackTrace();
		}
		return retrVal;

	}

	/**
	 * Description :To view all the Route in the database Return Value :list of
	 * Route Objects
	 **/

	@Override
	public List<Route> viewAllRoute() {

		List<Route> retVal = null;
		retVal = routeRepo.findAll();
		return retVal;
	}

}