package map;

import java.awt.Graphics;
import java.util.ArrayList;

import UI.UI;
import entitys.GameObject;
import entitys.Player;
import main.tt;
import tiles.TileType;
import tiles.Tiles;

public class Map {
	//width and height is reversed
	int height = 14,width = 20;
	private int tileSize = 64;
	public Tiles[][] map = new Tiles[height][width];
	
	public  int[][] level = {
			{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
			{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
			{2,2,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,2},
			{2,2,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
			{2,2,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,2,0,2},
			{2,0,0,0,0,0,0,1,3,0,0,0,0,3,0,0,0,0,0,2},
			{2,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,2},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
			{2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2},
			{2,2,0,0,0,0,0,0,3,0,0,0,1,3,0,0,0,0,2,2},
			{2,2,0,0,0,0,2,0,0,0,1,0,0,0,0,0,0,0,2,2},
			{2,2,1,0,0,0,0,0,0,0,0,0,0,0,0,2,0,1,2,2},
			{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
			{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}};
	
	private Player player;
	private UI ui;
	
	private ArrayList<GameObject> list = new ArrayList<GameObject>();
	private tt t;
	
	public Map(tt t){
		this.t = t;
		
		Grid();
		
		list.add(player = new Player(t,672,448));	
		ui = new UI(t,player);
	}
	
	public void Grid() {
		for(int i = 0; i<height;i++) {   
			for(int j = 0; j < width; j++) {
				switch(level[i][j]) {
				case 0:
					map[i][j] = new Tiles(j*64,i*64,64,64,TileType.Grass00);
					break;
				case 1:
					map[i][j] = new Tiles(j*64,i*64,64,64,TileType.Grass01);
					break;
				case 2:
					map[i][j] = new Tiles(j*64,i*64,64,64,TileType.Tree);
					break;
				case 3:
					map[i][j] = new Tiles(j*64,i*64,64,64,TileType.Brick);
					break;
				default:
					map[i][j] = new Tiles(j*64,i*64,64,64,TileType.Grass01);
					break;
				}
			}
		}
	}
	
	public void update() {
		ui.update();
		for(GameObject o : list)o.update();
	}
	
	public void Draw(Graphics g) {
		int offsetX = (int)player.getX() - t.getWidth()/2;
		int offsetY = (int)player.getY() - t.getWidth()/3;
		
		g.translate(-offsetX,-offsetY);
		
		for(int i = 0; i < map.length;i++) {
			for(int j = 0; j<map[i].length;j++) {
				Tiles t = map[i][j];
//				g.drawRect(i*64, j*64, 64, 64);
//				g.drawImage(t.getTexture(), t.getX()+1, t.getY()+1,
//						t.getWidth()-2, t.getHeight()-2, null);
				g.drawImage(t.getTexture(), t.getX(), t.getY(),
						t.getWidth(), t.getHeight(), null);
			}
		}
		
		for(GameObject o : list)o.draw(g);
		g.translate(offsetX,offsetY);
		
		//keep last
		ui.draw(g);
		
	}


}
