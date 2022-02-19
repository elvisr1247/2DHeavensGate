package entitys;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import main.Game;
import map.Map;

public class NPC extends Entity {
	
	public Rectangle dialogueBoxDetected = new Rectangle(-30,-30,128,128);

	public NPC() {}
	
	public NPC(Game game, Map m, float x, float y) {
		super(game, m, x, y, 64,64);
		bounds = new Rectangle(18,33,30,30);
		
		
		
	}
	
	public void update() {}
	
	public void draw(Graphics g) {
		g.setColor(Color.pink);
		g.drawRect((int)x, (int)y, width, height);
		//draws collision box
      	g.setColor(Color.magenta);
      	g.drawRect((int)(x +bounds.x), (int)(y + bounds.y),bounds.width, bounds.height);
      	
      	g.setColor(Color.yellow);
      	g.drawRect((int)(x +dialogueBoxDetected.x), (int)(y + dialogueBoxDetected.y),
      			dialogueBoxDetected.width, dialogueBoxDetected.height);
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)(x +dialogueBoxDetected.x),
				(int)(y + dialogueBoxDetected.y),dialogueBoxDetected.width,
				dialogueBoxDetected.height);
	}
	

}
