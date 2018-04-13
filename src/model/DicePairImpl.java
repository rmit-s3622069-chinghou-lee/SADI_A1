package model;

import java.util.Random;

import model.interfaces.DicePair;
import model.interfaces.GameEngine;

public class DicePairImpl implements DicePair {
	
	private int dice1;
	private int dice2;
	private int NumFaces;
	
	// simple constructor
	public DicePairImpl() {
		this(GameEngine.NUM_FACES);
	}

	public DicePairImpl(int numFaces) {

		Random roll = new Random();
		this.NumFaces = numFaces;
		
		dice1 = roll.nextInt(numFaces)+1;
		dice2 = roll.nextInt(numFaces)+1;
	}

	@Override
	public int getDice1() {
		return dice1;
	}

	@Override
	public int getDice2() {
		return dice2;
	}

	@Override
	public int getNumFaces() {
		return NumFaces;
	}
	
	public int totalDice() {
		return dice1+dice2;
	}

}
