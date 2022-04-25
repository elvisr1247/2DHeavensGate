package state;

import java.awt.Graphics;

import UI.UI;
import gfx.Assets;
import main.Game;
import map.Map;


public class GameState extends State {

	//TODO: update tiles
	/*
	 https://opengameart.org/content/dungeon-tileset-1
	 */
	private Map map;
	
	public GameState(Game game) {
		super(game);
		if(game !=null)
		map = new Map(game);
		
		//sets the map and makes it usable everywhere
		game.setMap(map);
		
		
		
//		 if(game.gameState == game.getTitleState()) {
//			 game.playMusic("res/Audio/smallAdventurers.wav");
//		 }
//			 game.stopMusic();
		 
////			 
//		used to draw tiles 
//		m.setTile(2,4, TileType.Brick);
//		m.setTile(2,5, m.getTile(2, 6).getType());

	}

	@Override
	public void update() {
	//pauses the game
		if(!UI.visible) {
			if(!game.getKeyManager().pause
					&&!game.getKeyManager().inventory) {
						if(map !=null)
							map.update();		
			}
		}
	}

	@Override
	public void draw(Graphics g) {
		
		if(map !=null)
		map.Draw(g);
		
		//draws paused game screen
		if(game.getKeyManager().pause) UI.paused(g);
		if(game.getKeyManager().inventory) UI.inventory(g);
		
		
	}
	
	

}
