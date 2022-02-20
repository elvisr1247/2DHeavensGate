package entitys;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import gfx.Assets;
import main.Game;
import map.Map;

public class Tree extends Entity {

	public Tree(Game game, float x, float y, Map m, int width, int height) {
		super(game, m, y, x, width, height);
		bounds = new Rectangle(50,150,30,40);
//		unkillableEntity = true;
	}

	private int health = 3;
	
	
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

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}
	
	public boolean isUnkillableEntity() {
		return true;
	}

}
