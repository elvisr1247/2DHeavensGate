package tiles;

import java.awt.Color;
import java.awt.Graphics;

import entitys.Player;
import main.Game;
import map.Map;

public class TileEditor {

	private Game game;
	private Map map;
	private Player player;
	
	private TileType[] types;
	private int index;
	
	
	public TileEditor(Game game,Map map, Player player) {
		this.game = game;
		this.map = map;
		this.player = player;
		types = new TileType[4];
		types[0] = TileType.Grass00;
		types[1] = TileType.Grass01;
		types[2] = TileType.Tree;
		types[3] = TileType.Brick;
		index = 3;
	}
	
	public void update() {
		mouseEditing();
	}
	public void draw(Graphics g) {
		int row = (int)game.getMouseManager().getMouseX();
		int column = (int)game.getMouseManager().getMouseY();
		
		g.setColor(Color.red);
		g.drawRect(row,column,10, 10);

	}
	
	private void mouseEditing() {
		//gets mouse location by row and columns
				int row = (int) ((int)game.getMouseManager().getMouseX()/64);
				int column = (int)game.getMouseManager().getMouseY()/64;
				
					
				if(game.getMouseManager().isLeftPressed()) {
					System.out.println(map.getTile(row, column).getType());
				}
				
				
//				if(game.getMouseManager().isRightPressed()) {
//					map.setTile(row, column, types[index]);
//				}
		
	}
}
