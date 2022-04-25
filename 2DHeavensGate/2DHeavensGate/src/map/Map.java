package map;

import java.awt.Graphics;
import java.util.Arrays;

import Item.Item;
import Item.ItemManager;
import UI.UI;
import enemyEntity.Skeleton;
import enemyEntity.Slime;
import entitys.EntityManager;
import entitys.oldMan;
import gfx.Assets;
import main.Game;
import plants.Grass;
import plants.Tree;
import tiles.TileType;
import tiles.Tiles;

public class Map {
	
	private Game game;
	private int width = 25,height = 14;
	private int tileSize = 64;
	public Tiles[][] map = new Tiles[width][height];
	
	private Skeleton skeleton;
	private UI ui;

	//world map
	//visual help
	/*https://drive.google.com/drive/folders/1Wm91HwnJWzeHDvWvfihxy6ervGQ5srx9*/
	/* 0 = grass00,1 = grass01,2 = water00,3 = water01,
	 4 = water02,5 = water03,6 = water04,7 = water05,
	 8 = water06,9 = water07,10 = water08,11 = water09,
	 12 = water10,13 = water11,14 = water12,15 = water13
	 16 = tree, 17 = brick */
	private int[][] level = {
			{2,3,2,2,2,2,2,2,2,2,2,2,3,3,2,2,2,2,2,2,2,2,2,2,3},
			{2,2,2,2,2,2,2,12,10,10,10,10,10,13,2,2,2,2,2,2,2,2,2,2,2},
			{2,2,2,2,3,2,2,8,0,0,0,0,0,7,2,2,2,2,3,2,2,2,2,2,2},
			{10,10,10,10,10,10,10,11,1,0,1,0,1,9,10,10,10,10,10,10,10,10,10,10,10},
			{16,16,16,16,16,16,16,16,1,0,0,0,0,16,16,16,16,16,16,16,16,16,16,16,16},
			{0,0,1,0,1,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{1,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,17,0,0,0,17,0,1,0,0},
			{0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0},
			{1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,1,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,16,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0}};
	
	//used to draw and update all entities
	private ItemManager itemManager;
	private EntityManager entityManager;
	
	private Grass grass;
	
	public Map(Game game) {
		 this.game = game;
		 grid();		
		 
		 entityManager = new EntityManager(game);
		 itemManager = new ItemManager(game);
		 itemManager.addItem(Item.potion.createNew(200, 400));

		 entityManager.addEntity(new Skeleton(game,250,420));
		 
		 entityManager.addEntity(new Slime(game,1153,372,32,32));
		 entityManager.addEntity(new oldMan(game,120,420));
		 entityManager.addEntity(new Tree(game,400,440,64*2,64*3));
		 entityManager.addEntity(new Tree(game,600,440,64*2,64*3));
		 
		 //temporary grass code
		 for(int i = 250;i<442;i+=64) {
			 for(int j = 612; j<740;j+=64) 
				 entityManager.addEntity(new Grass(game,i,j));
		 }
		 //prints the level 2d array
//		 System.out.println(Arrays.deepToString(level).replace("],","\n").replace(",","\t| ")
//	                .replaceAll("[\\[\\]]", " "));
		 
		 ui = new UI(game,entityManager.getPlayer());
		 
	}
	
	public void update() {
		ui.update();
		itemManager.update();
	
		entityManager.update();
		game.getCam().update(entityManager.getPlayer());

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
			}
		}

		itemManager.draw(g);
		//draws all the entity's
		entityManager.draw(g);
		
//		g.drawImage(Assets.abc,120,120,64,64,null);
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
					map[i][j] = new Tiles(i*tileSize,j*tileSize,TileType.Water00);
					break;
				case 3:
					map[i][j] = new Tiles(i*tileSize,j*tileSize,TileType.Water01);
					break;
				case 4:
					map[i][j] = new Tiles(i*tileSize,j*tileSize,TileType.Water02);
					break;
				case 5:
					map[i][j] = new Tiles(i*tileSize,j*tileSize,TileType.Water03);
					break;
				case 6:
					map[i][j] = new Tiles(i*tileSize,j*tileSize,TileType.Water04);
					break;
				case 7:
					map[i][j] = new Tiles(i*tileSize,j*tileSize,TileType.Water05);
					break;
				case 8:
					map[i][j] = new Tiles(i*tileSize,j*tileSize,TileType.Water06);
					break;
				case 9:
					map[i][j] = new Tiles(i*tileSize,j*tileSize,TileType.Water07);
					break;
				case 10:
					map[i][j] = new Tiles(i*tileSize,j*tileSize,TileType.Water08);
					break;
				case 11:
					map[i][j] = new Tiles(i*tileSize,j*tileSize,TileType.Water09);
					break;
				case 12:
					map[i][j] = new Tiles(i*tileSize,j*tileSize,TileType.Water10);
					break;
				case 13:
					map[i][j] = new Tiles(i*tileSize,j*tileSize,TileType.Water11);
					break;
				case 14:
					map[i][j] = new Tiles(i*tileSize,j*tileSize,TileType.Water12);
					break;
				case 15:
					map[i][j] = new Tiles(i*tileSize,j*tileSize,TileType.Water13);
					break;
				case 16:
					map[i][j] = new Tiles(i*tileSize,j*tileSize,TileType.Tree);
					break;
				case 17:
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

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	


}
