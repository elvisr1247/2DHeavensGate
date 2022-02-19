package entitys;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import gfx.Assets;
import main.Game;
import map.Map;

public class Skeleton extends Entity {

	
	public Skeleton(Game game,Map m,float x, float y) {
		super(game,m,x, y, 64, 64);
		//temp collision bounds
		bounds = new Rectangle(22,38,19,25);  
	}

	public void update() {
		xMove = 0;
		yMove = 0;
		
//		yMove++;                
		
		move();
	}
	
    public void draw(Graphics g) {
    	//draws collision box
      	g.setColor(Color.magenta);
      	g.drawRect((int)(x +bounds.x), (int)(y + bounds.y),bounds.width, bounds.height);
    	g.drawImage(Assets.skeleton[0],(int)x,(int)y,width,height, null);
    }
}
