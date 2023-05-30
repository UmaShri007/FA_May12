package ai.ineuron.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ai.ineuron.bo.Planet;
import ai.ineuron.dao.IPlanetRepository;

@Service
public class PlanetServiceImpl implements IPlanetService {

	@Autowired
	private IPlanetRepository planetRepo;
	
	@Override
	public Planet savePlanet(Planet planet) {
		return planetRepo.save(planet);
	}

	@Override
	public List<Planet> saveAllPlanets(List<Planet> planetList) {
		
		return planetRepo.saveAll(planetList);
	}

}
