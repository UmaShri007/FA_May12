package ai.ineuron.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ai.ineuron.bo.Planet;
import ai.ineuron.service.IPlanetService;

@RestController
@RequestMapping("/api/planet")
public class PlanetController {

	@Autowired
	private IPlanetService planetService;

	// localhost:8080/api/planet/save
	@PostMapping("/save")
	public Planet savePlanet(@RequestBody Planet planet) {

		return planetService.savePlanet(planet);

	}

	// localhost:8080/api/planet/saveAll
	@PostMapping("/saveAll")
	public List<Planet> saveAllPlanet(@RequestBody List<Planet> planetList) {

		return planetService.saveAllPlanets(planetList);

	}

	/*
	 * JSON Request Body==========> [ {"name": "Earth"}, {"name":"Jupiter"},
	 * {"name":"Saturn"}, {"name":"Venus"}, {"name":"Mars"} ]
	 */

}
