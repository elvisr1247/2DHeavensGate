package plants;

import java.awt.Graphics;
import java.awt.Rectangle;

import entitys.Creature;
import gfx.Assets;
import main.Game;

public class Tree extends Creature{

	public Tree(Game game, float x, float y, int width, int height) {
		super(game,x, y, 150, 200);
		bounds = new Rectangle(50,150,30,40);
	}
	
	public void update() {

	}
	
	public void draw(Graphics g) {
		g.drawImage(Assets.tree,(int)x,(int)y,width,height, null);
		//draws collision box
//      	g.setColor(Color.magenta);
//      	g.drawRect((int)(x +bounds.x), (int)(y + bounds.y),bounds.width, bounds.height);
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	public boolean isUnkillableEntity() {
		return true;
	}

}
