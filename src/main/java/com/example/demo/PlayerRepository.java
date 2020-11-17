package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Integer> {
	Player findByLogin(String login);
	List<Player> findBySport(String sport);
	List<Player> findByZipCode(String zipCode);
	Long countByZipCode(String zipCode);
	Long countBySport(String sport);
}