package com.practice.snakeandladder;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board {

	private List<Square> squares = new ArrayList<>();

	public static final Integer MIN_NUMBER_OF_SQUARE = 10;

	private Integer numberOfSquares;

	public Board(int numberOfSquares, int[][] snakesFromTo, int[][] ladderFromTo) {
		assert numberOfSquares < MIN_NUMBER_OF_SQUARE : "number of square must be greater than 10";
		this.numberOfSquares = numberOfSquares;
		makeSquares(numberOfSquares);
		makeSnakes(snakesFromTo);
		makeLadder(ladderFromTo);
	}

	private void makeLadder(int[][] ladderFromTo) {
		for (int i = 0; i < ladderFromTo.length; i++) {
			int from = ladderFromTo[i][0] - 1;
			int to = ladderFromTo[i][1] - 1;
			Square square = squares.get(from);
			square.setPosition(to);
		}
	}

	private void makeSnakes(int[][] snakesFromTo) {
		for (int i = 0; i < snakesFromTo.length; i++) {
			int from = snakesFromTo[i][0] - 1;
			int to = snakesFromTo[i][1] - 1;
			Square square = squares.get(from);
			square.setPosition(to);
		}
	}

	private void makeSquares(int numberOfSquares) {
		for (int position = 0; position < numberOfSquares; position++) {
			Square square = new Square(position);
			squares.add(square);
		}
	}

	public Square getFirstSquare() {
		return squares.get(0);
	}

	public Square getLastSquare() {
		return squares.get(numberOfSquares - 1);
	}

}