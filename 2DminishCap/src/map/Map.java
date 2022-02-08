package map;

import java.awt.Graphics;

import UI.UI;
import entitys.Player;
import main.Game;
import tiles.TileType;
import tiles.Tiles;

public class Map {
	private int tileSize = 64;
	public Tiles[][] map = new Tiles[13][10];
	
	private Player player;
	private UI ui;
	

	private Game game;
	
	int[][] level = {
			{2,2,2,2,2,2,2,2,2,2,2,2,2},
			{2,1,0,1,0,0,0,0,0,0,0,1,2},
			{2,0,0,2,0,0,0,0,0,0,2,0,2},
			{2,0,0,0,1,0,1,0,0,0,0,0,2},
			{2,0,0,1,0,0,0,0,0,0,0,0,2},
			{2,0,2,0,1,0,3,1,0,2,0,1,2},
			{2,0,0,0,0,0,0,0,0,0,1,1,2},
			{2,0,0,0,0,0,0,0,0,0,1,1,2},
			{2,0,0,0,0,0,0,0,0,0,1,1,2},
			{2,2,2,2,2,2,2,2,2,2,2,2,2}};
	
	public Map() {}
	
	public Map(Game game) {
		 this.game = game;
		 
		 grid();		 
		 player = new Player(game,this,325,220);	
		 
		 
		 ui = new UI(game,player);
	}
	
	public void grid() {
		for(int i = 0; i<map.length;i++) {   
			for(int j = 0; j < map[i].length; j++) {				
				switch(level[j][i]) {
				case 0:
					map[i][j] = new Tiles(i*tileSize,j*tileSize,TileType.Grass00);
					break;
				case 1:
					map[i][j] = new Tiles(i*tileSize,j*tileSize,TileType.Grass01);
					break;
				case 2:
					map[i][j] = new Tiles(i*tileSize,j*tileSize,TileType.Tree);
					break;
				case 3:
					map[i][j] = new Tiles(i*tileSize,j*tileSize,TileType.Brick);
					break;
				default:
					map[i][j] = new Tiles(i*tileSize,j*tileSize,TileType.Grass00);
					break;
				}
			}
		}
		
	}
	
	public void setTile(int xCoord,int yCoord,TileType type) {
		map[xCoord][yCoord] = new Tiles(xCoord*64,yCoord*64,type);
	}
	
	public Tiles getTile(int xCoord,int yCoord) {
		return map[xCoord][yCoord];
	}
	
	
	
	public void update() {
		ui.update();
		player.update();
	}
	
	public void Draw(Graphics g) {
		//centers on player
		int offsetX = (int)player.getX() - game.getWidth()/2 + 36;
		int offsetY = (int)player.getY() - game.getHeight()/2 + 54;
		
		g.translate(-offsetX,-offsetY);
		
		for(int i = 0; i < map.length;i++) {
			for(int j = 0; j<map[i].length;j++) {

					Tiles t = map[i][j];
					g.drawImage(t.getTexture(), t.getX(), t.getY(),
						t.getWidth(), t.getHeight(), null);

			}
		}
		
		player.draw(g);
		
		g.translate(offsetX,offsetY);
		
		//keep last
		ui.draw(g);
		
	}

}
