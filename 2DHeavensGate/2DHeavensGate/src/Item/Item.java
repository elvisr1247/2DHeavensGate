package Item;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import gfx.Assets;
import main.Game;
import UI.UI;

public class Item {

	//array of items stores items
	public static Item[] items = new Item[256];
	public static Item ruppe = new Item(Assets.rupee,"ruppe",0,"money?");
	public static Item key = new Item(Assets.key,"key",1,"an old key");
	public static Item grassSword = new Item(Assets.grassSword,"grassSword",2,"blade touched by the gods you wish\n "
			+ "its just a metal with some moss on it");
	public static Item sword = new Item(Assets.sword,"sword",3,"a sword what did u expect more???");
	public static Item potion = new Item(Assets.potion,"potion",4,"heals you i think or was it posion?\n who knows");
	public static Item axe = new Item(Assets.axe,"axe",5,"an axe you chop wood with it");
	
	
	private final int id;
	private String name;
	private BufferedImage texture;
	public static final int ITEMSIZE = 32,PICKED_UP = -1;
	//x&y used to draw item location
	protected int x,y,count;
	public String description = "";
	
	protected Rectangle bounds;
	private Game game;

	public Item(BufferedImage texture,String name,int id,String description) {
		this.id = id;
		this.name = name;
		this.texture = texture;
		this.description = description;
		
		items[id] = this;
		
		bounds = new Rectangle(x,y,ITEMSIZE,ITEMSIZE);
	}
	
	public void update() {
		//used to detect player
		if(game.getMap().getEntityManager().getPlayer().getBounds(0f, 0f).intersects(bounds)) {
			count = PICKED_UP;
			//picks up coins and adds it to the screen
			if(id == 0) {
				int rupees = game.getMap().getEntityManager().getPlayer().getRupees();
				rupees++;
				game.getMap().getEntityManager().getPlayer().setRupees(rupees);
			}else if(id == 4){
				int health = game.getMap().getEntityManager().getPlayer().getHealth();
				if(health!=6) {
					health++;
					game.getMap().getEntityManager().getPlayer().setHealth(health);
					UI.health = health;
				}else {
					game.getMap().getEntityManager().getPlayer().inventory.add(this);
				}
			}else {
				game.getMap().getEntityManager().getPlayer().inventory.add(this);
			}
		}
	}
	//draw used to draw items in the game world
	public void draw(Graphics g) {
		draw(g,x,y);
	}
	//draw used to draw items in the inventory
	public void draw(Graphics g,int x,int y) {
			g.drawImage(texture,x, y, ITEMSIZE, ITEMSIZE,null);
		
	}

	//creates a copy of the specific item at whatever position specified
	public Item createNew(int x,int y) {
		Item i = new Item(texture,name,id,description);
		i.setPosition(x, y);
		return i;
	}
	
	public void setPosition(int x,int y) {
		this.x = x;
		this.y = y;
		this.bounds.x = x;
		this.bounds.y = y;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BufferedImage getTexture() {
		return texture;
	}

	public void setTexture(BufferedImage texture) {
		this.texture = texture;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public static int getItemsize() {
		return ITEMSIZE;
	}
	
	
}
