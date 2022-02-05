package state;

import java.awt.Graphics;

import main.Game;
import map.Map;


public class GameState extends State {
	
	

	private Map m;

	
	public GameState(Game game) {
		super(game);
		if(game !=null)
		m = new Map(game);
		
	}

	@Override
	public void update() {
		if(m !=null)
		m.update();	
	}

	@Override
	public void draw(Graphics g) {
		if(m !=null)
		m.Draw(g);
	}
	
	

}
