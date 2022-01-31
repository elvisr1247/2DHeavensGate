package entitys;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import main.Game;

public class npc extends GameObject {

	private Game game;
	
	public npc(Game game, int x, int y) {
		super(game, x, y);
		this.game = game;
		rect = new Rectangle(-17,-17,100,100);
	}

	@Override
	public void update() {
		 xMove = 0;
		 yMove = 0;
		 
		
		 move();   
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.gray);
		g.drawRect(x, y, width, height);
		
//		g.setColor(Color.magenta);
//      	g.drawRect((x +rect.x), (y + rect.y),rect.width, rect.height); 
	}
	
	public Rectangle getBounds() {
		return new Rectangle(-17,-17,100,100);
	}
      	

}
