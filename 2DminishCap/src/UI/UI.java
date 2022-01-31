package UI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import entitys.Player;
import main.Game;

public class UI {
	
	public static int health;
	
	public static boolean visible = true;

	private Player p;
	private Game game;
	private int timer = 0;
	private static int FPS;
	
	
	public UI() {
		
	}
	public UI(Game game,Player p) {
		this.p = p;
		this.game = game;
		health = p.getHealth();
		
	}
	
	public void update() {
		timer++;

	}
	
	public void draw(Graphics g) {
		Color c = new Color(255,255,255);
		g.setColor(c);
		playerHealth(g);
		if(p.isStats()) {
			g.drawString(p.getX()+","+p.getY(),20,50);
			g.drawString("Timer: "+timer, 20, 70);
			g.drawString("Fps: "+FPS, 20, 90);
		}
		
	

	}
	
	public void playerHealth(Graphics g) {
		Color c = new Color(255,255,255);
		g.setColor(c);
		if(health == 3) {
			g.fillRect(10, 10, 20, 20);
			g.fillRect(40, 10, 20, 20);
			g.fillRect(70, 10, 20, 20);
		}else if(health == 2){
			g.fillRect(10, 10, 20, 20);
			g.fillRect(40, 10, 20, 20);
			g.drawRect(70, 10, 20, 20);
		}else if(health == 1){
			g.fillRect(10, 10, 20, 20);
			g.drawRect(40, 10, 20, 20);
			g.drawRect(70, 10, 20, 20);
		}else if(health == 0) {
			g.drawRect(10, 10, 20, 20);
			g.drawRect(40, 10, 20, 20);
			g.drawRect(70, 10, 20, 20);
		}
		
	}
	
	public void coinCollected() {}
	
	public void drawDialogueScreen(Graphics g) {
		int  x = 20,y = 300,width = 600,height = 100,
				rwidth = 20,rheight = 20;
		Color c = new Color(0,0,0);
		Graphics2D g2 = (Graphics2D)g;
		
		if(visible) {
			g.setColor(c);
			g.fillRoundRect(x,y, width, height, rwidth, rheight);
		
			c = new Color(255,255,255);
			g.setColor(c);
			g2.setStroke(new BasicStroke(5));
			g2.drawRoundRect(x+5, y+5,width-10, height-10,rwidth-5, rheight-5);
		}
	}
	

	public static void fps(int fps) {
		FPS = fps;
	}
	
	
}
