package entitys;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import UI.UI;
import gfx.Assets;
import main.Game;

public class oldMan extends Creature {

	
	private boolean finishedText = false;
	private String[] text;
	Rectangle diabox;
	
	public oldMan(Game game, float x, float y) {
		super(game, x, y,44,44);
		bounds = new Rectangle(0,0,width,height);  
		health = 2;
		
		text = new String[4];
		
		text[0] = "sup baby take out to dinner";
  		text[1] = "ayyyyyy dog";
  		text[2] = "fuck baby";
  		text[3] = "The wizard king has arrived\n"
  		+"and hes back for blood lots of blood\n"
  		+"i like blood do u like blood";
	}
	
	public void update() {
		xMove = 0;
		yMove = 0;
		
		diabox = new Rectangle((int)x-15,(int)y-15,90,90);
		
		move();
		
	}
	
	public void draw(Graphics g) {
		
		g.drawImage(Assets.oldMan,(int)x,(int)y,width,height,null);
		//draws collision box
//      	g.drawRect((int)(diabox.x), (int)(diabox.y),diabox.width,diabox.height);
      	if(playerDetected()) {
      		if(game.getKeyManager().enter) {
      			UI.visible = true; 		
          		UI.dialodgeText = text[3];
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
