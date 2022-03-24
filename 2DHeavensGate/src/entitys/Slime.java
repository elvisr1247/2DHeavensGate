package entitys;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import Item.Item;
import entitys.Skeleton.Enemystates;
import gfx.Assets;
import main.Game;

public class Slime extends Creature {
	
	public enum Enemystates{Wonder,Attack,Chase}
	public Enemystates states = Enemystates.Wonder;

	long lastTimer,coolDown = 500,timer = coolDown;

	public Slime(Game game, float x, float y, int width, int height) {
		super(game, x, y, game.tileSize/2, game.tileSize/2);
		bounds = new Rectangle(6,15,20,15);
	}
	
	public void update() {
		xMove = 0;
		yMove = 0;
		
		int i = 0;
		timer += System.currentTimeMillis() - lastTimer;
		lastTimer = System.currentTimeMillis();
		if(timer<coolDown) {
			Random random = new Random();
			i = random.nextInt(100)+1;
//			System.out.println(i);
		}
		timer = 0;
		
		
		switch(states) {
		case Wonder:
//			if(i<=25)direction = "up";
//			if(i>25&&i<=50)direction = "down";
//			if(i>50&&i<=75)direction = "left";
//			if(i>75&&i<=100)direction = "right";
//			switch(direction) {
//				case "up":
//					yMove--;
//					break;
//				case "down":
//					yMove++;
//					break;
//				case "right":
//					xMove++;
//					break;
//				case "left":
//					xMove--;
//					break;
//			}
			break;
		case Attack:
			break;
		case Chase:
			break;
	}
		
		move();
	}
	
	public void draw(Graphics g) {
		g.drawImage(Assets.slime[0],(int)x,(int)y,width,height,null);
		g.setColor(Color.magenta);
      	g.drawRect((int)(x +bounds.x), (int)(y + bounds.y),bounds.width, bounds.height);
		
	}
	
	  @Override
		public void die() {
	    		game.getMap().getItemManager().addItem(Item.ruppe.createNew((int)x, (int)y));
		}

}
