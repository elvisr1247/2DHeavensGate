package entitys;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import UI.UI;
import main.Game;

public class npc extends Creature {

	
	private boolean finishedText = false;
	private String[] text;
	Rectangle diabox;
	
	public npc(Game game, float x, float y) {
		super(game, x, y,game.tileSize,game.tileSize);
		bounds = new Rectangle(0,0,width,height);  
		health = 2;
		
		text = new String[3];
		
		text[0] = "sup baby take out to dinner";
  		text[1] = "ayyyyyy dog";
  		text[2] = "fuck baby";
	}
	
	public void update() {
		xMove = 0;
		yMove = 0;
		
		diabox = new Rectangle((int)x-15,(int)y-15,90,90);
		
		move();
		
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, width, height);
		
		//draws collision box
      	g.drawRect((int)(diabox.x), (int)(diabox.y),diabox.width,diabox.height);
      	if(playerDetected()) {
      		if(game.getKeyManager().enter) {
      			UI.visible = true; 		
          		UI.dialodgeText = text[0];
      		}else {
          		UI.visible = false;
          	}
      	}
	}
	
	public boolean playerDetected() {
		if(game.getMap().getEntityManager().getPlayer().getBounds(0, 0).intersects(diabox)) {
			return true;
		}
		return false;
	}
	
	public boolean isUnkillableEntity() {
		return true;
	}

}
