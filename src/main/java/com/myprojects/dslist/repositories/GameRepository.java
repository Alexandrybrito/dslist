package com.myprojects.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myprojects.dslist.entities.Game;

//consultas no banco de dados
public interface GameRepository extends JpaRepository<Game, Integer> {

}
