package map;

import java.awt.Graphics;
import java.util.ArrayList;

import UI.UI;
import entitys.Entity;
import entitys.Player;
import main.Game;
import tiles.TileType;
import tiles.Tiles;

public class Map {
	//width and height is reversed
	int width = 21,height = 16;
	private int tileSize = 64;
	public Tiles[][] map = new Tiles[height][width];
	//Bottom is left side, top is right, left is bottom, right is top
	public  int[][] level = {
			{2,2,2,2,2,2,2,2,2,0,0,0,2,2,2,2,2,2,2,2,0},
			{2,2,2,2,2,2,2,2,0,0,0,0,0,2,2,2,2,2,2,2,0},
			{2,2,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,2,0},
			{2,2,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0},
			{2,2,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,2,0,2,0},
			{2,0,0,0,0,0,0,1,3,0,1,0,0,3,0,0,1,1,0,2,0},
			{2,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{2,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0},
			{2,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0},
			{2,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,1,2,0},
			{2,2,0,0,0,0,0,0,3,0,0,0,1,3,0,0,0,0,2,2,0},
			{2,2,0,0,1,0,2,0,0,0,1,0,0,0,1,0,0,0,2,2,0},
			{2,2,1,0,0,0,0,0,0,0,0,0,0,0,0,2,0,1,2,2,0},
			{2,2,2,2,2,2,2,2,2,0,0,0,2,2,2,2,2,2,2,2,0},
			{2,2,2,2,2,2,2,2,0,0,0,0,0,2,2,2,2,2,2,2,0},
			{0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0}
			};
	
	private Player player;
	private UI ui;
	
	private ArrayList<Entity> list = new ArrayList<Entity>();
	private Game game;
	
	public Map() {
		
	}
	
	public Map(Game game){
		this.game = game;
		
		Grid();
		
		list.add(player = new Player(game,480,664));	
		ui = new UI(game,player);
	}
	
	public void Grid() {
		for(int i = 0; i<height;i++) {   
			for(int j = 0; j < width; j++) {
				switch(level[i][j]) {
				case 0:
					map[i][j] = new Tiles(i*tileSize,j*tileSize,tileSize,tileSize,TileType.Grass00);
					break;
				case 1:
					map[i][j] = new Tiles(i*tileSize,j*tileSize,tileSize,tileSize,TileType.Grass01);
					break;
				case 2:
					map[i][j] = new Tiles(i*tileSize,j*tileSize,tileSize,tileSize,TileType.Tree);
					break;
				case 3:
					map[i][j] = new Tiles(i*tileSize,j*tileSize,tileSize,tileSize,TileType.Brick);
					break;
				default:
					map[i][j] = new Tiles(i*tileSize,j*tileSize,tileSize,tileSize,TileType.Grass01);
					break;
				}
			}
		}
	}
	
	public void update() {
		ui.update();
		for(Entity e : list)e.update();
	}
	
	public void Draw(Graphics g) {
		//centers on player
		int offsetX = (int)player.getX() - game.getWidth()/2 + 36;
		int offsetY = (int)player.getY() - game.getHeight()/2 + 54;
		
		g.translate(-offsetX,-offsetY);
		
		for(int i = 0; i < height;i++) {
			for(int j = 0; j<width;j++) {

					Tiles t = map[i][j];
					g.drawImage(t.getTexture(), t.getX(), t.getY(),
						t.getWidth(), t.getHeight(), null);

//				System.out.println(new Entity().collision(t.getX(),t.getY()));
					new Entity().collision(t.getX(),t.getY());
			}
		}
		
		for(Entity e : list)e.draw(g);
		
		g.translate(offsetX,offsetY);
		
		//keep last
		ui.draw(g);
		
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}


}
