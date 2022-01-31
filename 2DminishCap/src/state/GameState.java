package state;

import java.awt.Graphics;

import gfx.Camera;
import main.tt;
import map.Map;


public class GameState extends State {
	
	

	private Camera cam;
	private Map m;

	
	public GameState(tt t) {
		super(t);
		m = new Map(t);
		
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
