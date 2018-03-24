package player;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import processing.Route;
import processing.RouteAlreadyExistsException;
/**
 * 
 * @author François-Laurent
 *
 */

public class Routebook {
	private ArrayList<Route> routes = new ArrayList<Route>();
	
	public void add(Route route) throws RouteAlreadyExistsException {
		if (routes.contains(route)) {
			throw new RouteAlreadyExistsException(route);
		} else {
			routes.add(route);
		}
	}
	public Route recherchechemin(String name) throws NoSuchElementException {
		Route result = null;
		for (Route route : routes) {
			if (route.getName().equals(name)) {
				result = route;
			}
		}
		if (result == null) {
			throw new NoSuchElementException("Contact " + name + " does not exists.");
		} else {
			return result;
		}
	}
	
	public boolean contains(Route route) {
		return routes.contains(route);
	}
	
	
	
	
}
