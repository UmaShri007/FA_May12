package ai.ineuron.service;

import java.util.List;

import ai.ineuron.bo.Planet;

public interface IPlanetService {
	
	// To a save singlee record of Plaanet into db
	public Planet savePlanet(Planet planet);
	
	public List<Planet> saveAllPlanets(List<Planet>planet);
	
}
