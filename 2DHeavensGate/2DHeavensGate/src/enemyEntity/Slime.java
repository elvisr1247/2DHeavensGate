package enemyEntity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import Item.Item;
import gfx.Animation;
import gfx.Assets;
import main.Game;

public class Slime extends EnemiesManager {
	
	public enum state{Wonder,Attack,Chase}
	public state states = state.Wonder;
	
	private Animation walkAnimation;
	
	Random random = new Random();
	int i = random.nextInt(100)+1;
	
	int count = 0;

	public Slime(Game game, float x, float y, int width, int height) {
		super(game, x, y, game.tileSize/2, game.tileSize/2);
		bounds = new Rectangle(6,15,20,15);
		maxBaseLife = 3;
		health = maxBaseLife;
		
		walkAnimation = new Animation(400,Assets.slime);
	}
	
	public void update() {
		xMove = 0;
		yMove = 0;
		
		boolean flip = false;
//		System.out.println(count);
		
		switch(states) {
			case Wonder:
				direction = "left";
				
				
				if(isCollidingWithTile) {
					if(direction.equals("up"))direction = "down";
					else if(direction.equals("down"))direction = "up";
					else if(direction.equals("right"))direction = "left";
					else if(direction.equals("left")) direction = "right";
					
					count++;
					if(count == 5) { 
						isCollidingWithTile = false;
						count = 0;
					}
				}			
				break;
			case Attack:
				break;
			case Chase:
				break;
		}
		
		
		//wall collision
//		directionFlip();
		//enemy movement
		directionMovement();
		//updates animation
		walkAnimation.update();
		//allows movement
		move();
	}
	
	public void draw(Graphics g) {
		g.drawImage(walkAnimation.getCurrentFrame(),(int)x,(int)y,width,height,null);
		hpVar(g,maxBaseLife);
		
//		g.setColor(Color.yellow);
//		g.drawRect(flipleft.x, flipleft.y, flipleft.width, flipleft.height);
	}
	


	@Override
	public void die() {
	    game.getMap().getItemManager().addItem(Item.ruppe.createNew((int)x, (int)y));
	}

}
