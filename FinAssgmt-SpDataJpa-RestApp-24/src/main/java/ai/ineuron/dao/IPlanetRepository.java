package ai.ineuron.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ai.ineuron.bo.Planet;

public interface IPlanetRepository extends JpaRepository<Planet, Integer> {

}
