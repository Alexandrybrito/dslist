package com.myprojects.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myprojects.dslist.dto.GameListDTO;
import com.myprojects.dslist.entities.GameList;
import com.myprojects.dslist.repositories.GameListRepository;


@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;
	
//	@Autowired
//	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(x -> new GameListDTO(x)).toList();
	}
}
