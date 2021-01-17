package com.practice.snakeandladder;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Die {

	private Integer minValue;

	private Integer maxValue;

	public Integer roll() {
		return (int) (minValue + (maxValue - minValue) * Math.random());
	}

//	public static void main(String[] args) {
//		Die die = new Die(1,6);
//		System.out.println(die.roll());
//		System.out.println(die.roll());
//		System.out.println(die.roll());
//		System.out.println(die.roll());
//		System.out.println(die.roll());
//	}

}
