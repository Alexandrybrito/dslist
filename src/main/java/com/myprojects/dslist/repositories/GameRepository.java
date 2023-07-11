package com.myprojects.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myprojects.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Integer> {

}
