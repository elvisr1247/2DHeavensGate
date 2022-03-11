package map;

import java.awt.Graphics;
import java.util.ArrayList;

import Audio.Audio;
import Item.ItemManager;
import UI.UI;
import entitys.Entity;
import entitys.Entity;
import entitys.Grass;
import entitys.Player;
import entitys.Skeleton;
import entitys.Tree;
import entitys.npc;
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
	private ArrayList<Entity> entites = new ArrayList<Entity>();
	private ItemManager itemManager;
	//TODO:fix and update tile editor
	private TileEditor tileEditor;
	
	private Grass grass;
	
	public Map(Game game) {
		 this.game = game;
		 
		 grid();		
		
		 
		 itemManager = new ItemManager(game);
		 entites.add(skeleton = new Skeleton(game,250,220));
		 entites.add(new npc(game,120,30));
		 entites.add(new Tree(game,400,140,64*2,64*3));
		 //temporary grass code
		 for(int i = 250;i<442;i+=64) {
			 for(int j = 612; j<740;j+=64) 
				 entites.add(new Grass(game,i,j));
		 }
		 entites.add(player = new Player(game,325,220));
		 ui = new UI(game,player);
		 
//		 tileEditor = new TileEditor(game,this,player);
	}
	
	public void update() {
		ui.update();
		itemManager.update();
		//if entity is dead remove
		for(int i = 0; i < entites.size();i++) {
			Entity e = entites.get(i);
			e.update();
			if(!e.isActiveEntity() && !e.isUnkillableEntity()) {
				entites.remove(e);
			}
		}
		game.getCam().update(player);
//		tileEditor.update();
	}
	
	public void Draw(Graphics g) {
		//used to render portions of the screen begins used
		int xStart = (int)Math.max(0, game.getCam().getxOffset()/64);
		int xEnd = (int)Math.min(width, (game.getCam().getxOffset()+game.getWidth())/64 + 1);
		int yStart = (int)Math.max(0, game.getCam().getyOffset()/64);
		int yEnd = (int)Math.min(height, (game.getCam().getyOffset()+game.getHeight())/64+1);
		
		//g.translate used for camera movement
		g.translate((int)-game.getCam().getxOffset(),(int)-game.getCam().getyOffset());
		for(int i = xStart; i < xEnd;i++) {
			for(int j = yStart; j<yEnd;j++) {

					Tiles t = map[i][j];
					g.drawImage(t.getTexture(), t.getX(), t.getY(),
						t.getWidth(), t.getHeight(), null);
//					g.setColor(Color.DARK_GRAY);
//					g.drawRect(i*64, j*64, 64, 64);

			}
		}
		itemManager.draw(g);
		//draws all the entity's
		for(Entity e : entites)e.draw(g);
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
		return entites;
	}

	public void setE(ArrayList<Entity> c) {
		this.entites = c;
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

	public ArrayList<Entity> getEntites() {
		return entites;
	}

	public void setEntites(ArrayList<Entity> entites) {
		this.entites = entites;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public ItemManager getItemManager() {
		return itemManager;
	}

	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	
	


}
