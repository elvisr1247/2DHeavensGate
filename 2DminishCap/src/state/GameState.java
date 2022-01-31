package state;

import java.awt.Graphics;

import gfx.Camera;
import main.Game;
import map.Map;


public class GameState extends State {
	
	

	private Camera cam;
	private Map m;

	
	public GameState(Game game) {
		super(game);
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
