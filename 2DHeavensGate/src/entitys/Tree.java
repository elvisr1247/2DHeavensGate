package entitys;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import gfx.Assets;
import main.Game;
import map.Map;

public class Tree extends Entity {

	private int health = 3;
	
	public Tree(Game game,Map m,float x, float y,int width,int height) {
		super(game,m,x, y,width,height);
		bounds = new Rectangle(50,150,30,40);
	}
	
	public void update() {

	}
	
	public void draw(Graphics g) {
		g.drawImage(Assets.tree,(int)x,(int)y,width,height, null);
		//draws collision box
      	g.setColor(Color.magenta);
      	g.drawRect((int)(x +bounds.x), (int)(y + bounds.y),bounds.width, bounds.height);
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

}
