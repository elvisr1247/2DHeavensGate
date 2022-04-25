package enemyEntity;

import java.awt.Graphics;
import java.awt.Rectangle;

import Item.Item;
import gfx.Assets;
import main.Game;

public class Skeleton extends EnemiesManager {
	
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
	
		switch(states) {
			case Wonder:
//				direction = "up";
				
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
		
		move();
	}
	
    public void draw(Graphics g) {
    	g.drawImage(Assets.skeleton[0],(int)x,(int)y,width,height, null);
    	
    	hpVar(g,maxBaseLife);
    	
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
