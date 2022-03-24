package entitys;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import gfx.Assets;
import main.Game;
import map.Map;
import Item.Item;

public class Skeleton extends Creature {
	
	public enum Enemystates{Wonder,Attack,Chase}
	public Enemystates states = Enemystates.Wonder;
	
	
	
	public Skeleton(Game game,float x, float y) {
		super(game,x, y, game.tileSize, game.tileSize);
		//temp collision bounds
		bounds = new Rectangle(22,38,19,25);  
		maxBaseLife = 5;
		health = maxBaseLife;
		
		
		
	}

	public void update() {
		xMove = 0;
		yMove = 0;
		//update the player detect bounds
		detecPlayer = new Rectangle((int)x-25,(int)y-25,120,120);
//	    xMove++;
//	System.out.println(playerDetected());
//		switch(states) {
//			case Wonder:
//				break;
//			case Attack:
//				break;
//			case Chase:
//				break;
//		}
		
//		setStates(states.Chase);
	     
		
		move();
	}
	
    public void draw(Graphics g) {
    	//draws collision box
      	g.setColor(Color.magenta);
      	g.drawRect((int)(x +bounds.x), (int)(y + bounds.y),bounds.width, bounds.height);
    	g.drawImage(Assets.skeleton[0],(int)x,(int)y,width,height, null);
    	
    	g.setColor(Color.red);
    	g.drawRect((int)(detecPlayer.x), (int)(detecPlayer.y),detecPlayer.width,detecPlayer.height);
    	
    	hpVar(g,maxBaseLife);
    	
    }
    
    public boolean playerDetected() {
		if(game.getMap().getEntityManager().getPlayer().getBounds(0f, 0f).intersects(detecPlayer)) {
			return true;
		}
		return false;
	}
    
     
    @Override
	public void die() {
    		game.getMap().getItemManager().addItem(Item.grassSword.createNew((int)x, (int)y));
	}

	public Enemystates getStates() {
		return states;
	}

	public void setStates(Enemystates states) {
		this.states = states;
	}
   
}
