package UI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import entitys.Player;
import gfx.Assets;
import main.Game;

public class UI {
	
	public static int health;
	
	public static boolean visible = true;

	private Player p;
	private Game game;
	private int timer = 0;
	private static int FPS;
	public static int commandNum = 0;
	
	
	
	private int row,col;
	
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
		
		row = (int)p.getX()/64;
		col = (int)p.getY()/64;
		
		int mouseX = game.getMouseManager().getMouseX()/64;
		int mouseY = game.getMouseManager().getMouseY()/64;
		
		
		g.setColor(c);
		playerHealth(g);
		coinCollected(g);
		if(p.isStats()) {
			g.drawString(row+","+col,10,70);
			g.drawString("Timer: "+timer, 10, 110);
			g.drawString("Fps: "+FPS, 10, 150);
			g.drawString(mouseX+","+mouseY, 10, 190);

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
	
	public void coinCollected(Graphics g) {
 
		g.setFont(Assets.font24); 
		String rupee = String.format("%03d", p.getRupees());
		g.drawImage(Assets.rupee,650,500,42,42,null);
		g.drawString(rupee, 600, 525);
	}
	
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
	public int getCommandNum() {
		return commandNum;
	}
	public void setCommandNum(int commandNum) {
		this.commandNum = commandNum;
	}
	
	
	
}
