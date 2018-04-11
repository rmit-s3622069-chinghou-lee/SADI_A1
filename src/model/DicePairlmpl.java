package model;

import model.interfaces.DicePair;

public class DicePairlmpl implements DicePair {

	   private int dice1;
	   private int dice2;
	   private int numOfFaces;
	  
	
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
		return numOfFaces;
	}

}
