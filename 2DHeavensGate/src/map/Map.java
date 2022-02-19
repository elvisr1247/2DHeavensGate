package map;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import UI.UI;
import entitys.Entity;
import entitys.NPC;
import entitys.Player;
import entitys.Skeleton;
import entitys.Tree;
import main.Game;
import tiles.TileEditor;
import tiles.TileType;
import tiles.Tiles;

public class Map {
	
	private Game game;
	private int width = 25,height = 14;
	private int tileSize = 64;
	public Tiles[][] map = new Tiles[width][height];
	
	private Player player;
	private Skeleton skeleton;
	private UI ui;

	//world map
	private int[][] level = {
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,3,0,1},
			{0,1,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,0,0},
			{0,0,0,2,0,0,0,0,0,0,2,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,1,0,1,0,0,0,0,0,2,0,0,0,1,0,0,0,0,0,0,0,0},
			{0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,3,0,0},
			{0,0,2,0,1,0,0,1,0,2,0,1,0,0,0,0,0,0,0,0,0,0,3,0,0},
			{1,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,1,0,0},
			{0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,3,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,0,0,0,3,0,0},
			{1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,0,0},
			{0,0,1,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,3,0,0},
			{0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,0,0},
			{0,0,0,0,0,0,0,0,0,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0}};
	
	//used to draw and update all entities
	ArrayList<Entity> e = new ArrayList<Entity>();
	//TODO:fix and update tile editor
	//private TileEditor tileEditor;
	
	public Map() {}
	
	public Map(Game game) {
		 this.game = game;
		 
		 grid();		 
		 
		 e.add(skeleton = new Skeleton(game,this,250,220));
		 e.add(new Tree(game,this,400,140,64*2,64*3));
//		 e.add(new NPC(game,this,100,100));
		 
		 e.add(player = new Player(game,this,325,220));
		 ui = new UI(game,player);
		 
//		 tileEditor = new TileEditor(game,this,player);
	}
	
	public void update() {
		ui.update();
		for(Entity e : e)e.update();
		game.getCam().update(player);
//		tileEditor.update();
	}
	
	public void Draw(Graphics g) {
		//g.translate used for camera movement
		g.translate((int)-game.getCam().getxOffset(),(int)-game.getCam().getyOffset());
		for(int i = 0; i < map.length;i++) {
			for(int j = 0; j<map[i].length;j++) {

					Tiles t = map[i][j];
					g.drawImage(t.getTexture(), t.getX(), t.getY(),
						t.getWidth(), t.getHeight(), null);
					
//					g.setColor(Color.DARK_GRAY);
//					g.drawRect(i*64, j*64, 64, 64);

			}
		}
		
		//draws all the entity's
		for(Entity e : e)e.draw(g);
//		tileEditor.draw(g);
		g.translate((int)game.getCam().getxOffset(),(int)game.getCam().getyOffset());
		//keep last
		ui.draw(g);
		
		
	}
	
	public void grid() {
		for(int i = 0; i<map.length;i++) {   
			for(int j = 0; j < map[i].length; j++) {	
				//you add more tiles here
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
		//so it doesnt give an error when out side of map bounds
		if(xCoord<0||yCoord<0||xCoord>=width ||yCoord>=height)
			return new Tiles(xCoord*tileSize,yCoord*tileSize,TileType.Tree);
		return map[xCoord][yCoord];
	}

	public ArrayList<Entity> getE() {
		return e;
	}

	public void setE(ArrayList<Entity> e) {
		this.e = e;
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
