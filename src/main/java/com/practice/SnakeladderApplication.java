package com.practice;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.practice.snakeandladder.Game;

@SpringBootApplication
public class SnakeladderApplication {

	public static void main(String[] args) {
		// SpringApplication.run(SnakeladderApplication.class, args);

		String[] playerNames = { "A", "B", "C" };

		int numberOfSquares = 12;

		int[][] snakesFromTo = { { 11, 2 } };

		int[][] ladderFromTo = { { 3, 9 }, { 4, 7 } };

		Game game = new Game(playerNames, numberOfSquares, snakesFromTo, ladderFromTo);
		game.play();
	}

}
