package state;

import java.awt.Graphics;

import main.tt;

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
	
	protected tt t;
	
	public State(tt t) {
		this.t = t;
	}
	
	public abstract void update();
	
	public abstract void draw(Graphics g);
	
}

