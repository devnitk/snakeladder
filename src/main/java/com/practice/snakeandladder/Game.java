package com.practice.snakeandladder;


import java.util.LinkedList;

public class Game {

	public LinkedList<Player> players = new LinkedList<>();

	public Board board = null;

	private Player winner = null;

	public Game(String[] playerNames, int numberOfSquares,
			int[][] snakesFromTo, int[][] ladderFromTo) {
		createPlayer(playerNames);
		createBoard(numberOfSquares, snakesFromTo, ladderFromTo);
	}

	private void createBoard(int numberOfSquares, int[][] snakesFromTo,
			int[][] ladderFromTo) {
		board = new Board(numberOfSquares, snakesFromTo, ladderFromTo);
	}

	private void createPlayer(String[] playerNames) {
		for (String playerName : playerNames) {
			Player player = new Player(playerName);
			players.add(player);
		}
	}

	public void play() {
		placeAllPlayersAtFirstPosition();
		printAllPlayerPosition();
		Die die = new Die(1, 6);
		while (!gameOver()) {
			int rollDice = die.roll();
			System.out.println("Player name who rolled dice : " + currentPlayer().getName() + " and dice is - " + rollDice);
			movePlayer(rollDice);
			printAllPlayerPosition();
		}
		System.out.println("Winner is : " + winner.name);
	}

	private Player currentPlayer() {
		return players.peekFirst();
	}

	private void printAllPlayerPosition() {
		for (Player player : players) {
			System.out.println(player.getName() + " - position is : "
					+ player.getSquare().getPosition());
		}
	}

	private void movePlayer(int rollDice) {
		Player currentPlayer = players.pollFirst();
		int shift = currentPlayer.getSquare().getPosition() + rollDice;
		if (shift >= board.getNumberOfSquares()) {
			currentPlayer.setSquare(getFirstSquare());
		} else {
			int position = board.getSquares().get(shift).getPosition();
			if (shift > position) {
				System.out.println("There is snake from " + shift + " to is : "
						+ position);
			} else if (shift < position) {
				System.out.println("There is ladder from " + position
						+ " to is : " + shift);
			}

			currentPlayer.setSquare(board.getSquares().get(position));
		}
		players.add(currentPlayer);
		checkWinner(currentPlayer);
	}

	private void checkWinner(Player currentPlayer) {
		if (currentPlayer.getSquare().equals(board.getLastSquare())) {
			winner = currentPlayer;
		}
	}

	private boolean gameOver() {
		return winner == null ? false : true;
	}

	private void placeAllPlayersAtFirstPosition() {
		for (Player player : players) {
			player.setSquare(getFirstSquare());
			getFirstSquare().enter(player);
		}
	}

	private Square getFirstSquare() { 
		return board.getFirstSquare();
	}

}
