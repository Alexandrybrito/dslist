package com.myprojects.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myprojects.dslist.dto.GameListDTO;
import com.myprojects.dslist.entities.GameList;
import com.myprojects.dslist.projections.GameMinProjection;
import com.myprojects.dslist.repositories.GameListRepository;
import com.myprojects.dslist.repositories.GameRepository;


@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(x -> new GameListDTO(x)).toList();
	}
	
	@Transactional
	public void move(Integer listId, int sourceIndex, int destinationIndex) {
		List<GameMinProjection> list = gameRepository.searchByList(listId);
		
		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinationIndex, obj);
		
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
		
		for (int i = min; i <= max; i++) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
	}
}
