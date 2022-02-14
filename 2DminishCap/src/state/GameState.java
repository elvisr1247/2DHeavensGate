package state;

import java.awt.Graphics;

import entitys.Entity;
import main.Game;
import map.Map;
import tiles.TileType;


public class GameState extends State {

	//TODO: update tiles
	/*
	 https://opengameart.org/content/dungeon-tileset-1
	 */
	private Map m;
	
	public GameState(Game game) {
		super(game);
		if(game !=null)
		m = new Map(game);
		
//		used to draw tiles 
//		m.setTile(2,4, TileType.Brick);
//		m.setTile(2,5, m.getTile(2, 6).getType());

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
