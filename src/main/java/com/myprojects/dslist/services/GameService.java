package com.myprojects.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.myprojects.dslist.dto.GameDTO;
import com.myprojects.dslist.dto.GameMinDTO;
import com.myprojects.dslist.entities.Game;
import com.myprojects.dslist.projections.GameMinProjection;
import com.myprojects.dslist.repositories.GameRepository;



@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public GameDTO findById(Integer id) {
		Game result = gameRepository.findById(id).get();
		return new GameDTO(result);
	}	
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll() {
		List<Game> result = gameRepository.findAll();
		return result.stream().map(x -> new GameMinDTO(x)).toList();
//		return result.stream().map(GameMinDTO::new).toList();	
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Integer listId) {
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		return result.stream().map(x -> new GameMinDTO(x)).toList();
//		return result.stream().map(GameMinDTO::new).toList();	
	}


}
