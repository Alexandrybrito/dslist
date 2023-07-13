package com.myprojects.dslist.dto;



import com.myprojects.dslist.entities.GameList;

public class GameListDTO {

	private Integer id;
	private String name;
	
	public GameListDTO() {
	}

	public GameListDTO(GameList entity) {
		id = entity.getId();
		name = entity.getName();
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}	
}
