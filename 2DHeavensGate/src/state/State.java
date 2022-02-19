package state;

import java.awt.Graphics;

import main.Game;

public abstract class State {

	//STATE MANAGER
	private static State currentState = null;
	
	public static void setState(State state) {
		currentState = state;
	}
	
	public static State getState() {
		return currentState;
	}
	
	
	//CLASS
	
	protected Game game;
	
	public State(Game game) {
		this.game = game;
	}
	
	public abstract void update();
	
	public abstract void draw(Graphics g);
	
}

