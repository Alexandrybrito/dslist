package com.myprojects.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.myprojects.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Integer> {

	
	@Modifying
	@Query(nativeQuery = true, value = 
			"UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND game_id = :gameId")
	void updateBelongingPosition(Integer listId, Integer gameId, Integer newPosition);
}
