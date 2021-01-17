package com.practice.snakeandladder;

import java.util.LinkedList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Square {

	@Getter
	@Setter
	private Integer position;

	private List<Player> players = new LinkedList<>();

	public Square(Integer value) {
		this.position = value;
	}

	@Override
	public String toString() {
		return Integer.toString(position);
	}

	public boolean equals(Square square) {
		if (square instanceof Square) {
			if (square.getPosition() == this.position) {
				return true;
			}
		}
		return false;
	}

	public void enter(Player player) {
		players.add(player);
	}

}