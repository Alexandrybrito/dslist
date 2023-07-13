package com.myprojects.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myprojects.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Integer> {

}
