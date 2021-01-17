package com.practice.snakeandladder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {

	String name;

	Square square;

	public Player(String playerName) {
		this.name = playerName;
	}
}