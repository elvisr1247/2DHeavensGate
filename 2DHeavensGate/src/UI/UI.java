package UI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import entitys.Player;
import gfx.Assets;
import main.Game;

public class UI {
	
	public static int health;
	
	public static boolean visible = false;

	private static Game game;
	private static Player player;
	private int keys = 0;
	private static int FPS;
	public static int commandNum = 0;
	public static String dialodgeText = "";
	private int row,col;
	public static int slotCol = 0;
	public static int slotRow = 0;

	
//	public UI() {}
	
	public UI(Game game,Player player) {
		this.player = player;
		this.game = game;
		health = player.getHealth();
		
	}
	
	public void update() {
	}
	
	public void draw(Graphics g) {
		Color c = new Color(255,255,255);
		
		row = (int)player.getX()/64;
		col = (int)player.getY()/64;
		
		int mouseX = game.getMouseManager().getMouseX()/64;
		int mouseY = game.getMouseManager().getMouseY()/64;
		
		if(!game.getKeyManager().pause &&
				!game.getKeyManager().inventory) {
			g.setColor(c);
			playerHealth(g);
			coinCollected(g);
			keysCollected(g);
		}
		drawDialogueScreen(g,dialodgeText);
	

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
		String rupee = String.format("%03d", player.getRupees());
		g.drawImage(Assets.rupee,720,500,42,42,null);
		g.drawString(rupee, 680, 525);
	}
	
	private void keysCollected(Graphics g) {
	g.setFont(Assets.font24); 
	String keys = String.format("%03d", player.getKeys());
	g.drawImage(Assets.key,730,460,32,32,null);
	g.drawString(keys, 690, 490);
	
}
	
	public static void drawDialogueScreen(Graphics g,String text) {
		g.setFont(Assets.font24); 
		int  x = 90,y = 400,width = 600,height = 100,
				rwidth = 20,rheight = 20;
		Color c = new Color(0,0,0,210);
		Graphics2D g2 = (Graphics2D)g;
		
		if(visible) {
			
			g.setColor(c);
			g.fillRoundRect(x,y, width, height, rwidth, rheight);
		
			c = new Color(255,255,255);
			g.setColor(c);
			g2.setStroke(new BasicStroke(5));
			g2.drawRoundRect(x+5, y+5,width-10, height-10,rwidth-5, rheight-5);
			
			g.drawString(text, 100, 430);
			
		}
	}
	
	public static void paused(Graphics g) {
		
		Color c = new Color(0,0,0,150);
		g.setColor(c);
		g.fillRect(0, 0,game.getWidth(),game.getHeight());
		g.setColor(Color.white);
		g.drawString("PAUSED", 350, 270);
	
	}
	
	public static void inventory(Graphics g) {
		final int size = 64;
		final int frameX = size*3;
		final int frameY = size;
		final int frameWidth = size*5;
		final int frameHeight = size*5;
		
		g.setColor(new Color(0,0,0,100));
		g.fillRect(0, 0, game.getWidth(), game.getHeight());
		//Player Stats temporary code
		drawSubWindow(g,size,size,size*2,size*2);
		int locationX = (int) player.getX();
		int locationY = (int) player.getY();
		g.drawString(locationX+","+locationY, size+11, size+30);
		//Item Slot Window
		drawSubWindow(g,frameX,frameY,frameWidth,frameHeight);
		
		//Slots
		final int slotXstart = frameX + 20;
		final int slotYstart = frameY + 20;
		int slotX = slotXstart;
		int slotY = slotYstart;
		int slotSize = size -5;
		
		//Draw Players Items
		for(int i = 0;
				i<game.getMap().getEntityManager().
				getPlayer().inventory.size();i++) {
			g.drawImage(game.getMap().getEntityManager().
					getPlayer().inventory.get(i).getTexture(),slotX,slotY,null);
			slotX += slotSize;
			if(i == 4 || i == 9 || i == 14) {
				slotX = slotXstart;
				slotY +=slotSize;
			}
		}
		
		//Cursor
		int cursorX = slotXstart + (size+slotCol);
		int cursorY = slotYstart + (size+slotRow);
		int cursorWidth = size;
		int cursorHeight = size;
		
		//Draw Cursor
		g.setColor(Color.white);
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(3));
		g2.drawRoundRect(cursorX, cursorY, cursorWidth, cursorHeight,10,10);
		
		//Cursor Scroll
		int translation = 5;
		if(game.getKeyManager().pause
				|| game.getKeyManager().inventory) {
			if(game.getKeyManager().up) {
				if(slotRow != -60)
				slotRow-=translation;
			}
			if(game.getKeyManager().down) {
				if(slotRow != translation*24)
				slotRow+=translation;
			}
			if(game.getKeyManager().right) {
				if(slotCol != translation*32)
				slotCol+=translation;
			}
			if(game.getKeyManager().left) {
				if(slotCol !=-70)
				slotCol-=translation;
			}
		}
		//Description Frame
		int dFrameX = frameX;
		int dFrameY = frameY + frameHeight;
		int dFrameWidth = frameWidth;
		int dFrameHeight = size * 3;
		drawSubWindow(g,dFrameX,dFrameY,dFrameWidth,dFrameHeight);
		//Description Frame Text
		int textX = dFrameX + 20;
		int textY = dFrameY + size;
		g.setFont(Assets.font16);
		
		int itemIndex = getItemIndexOnslot();
		
		if(itemIndex < game.getMap().getEntityManager().
				getPlayer().inventory.size()) {
			if(itemIndex != -1) {
				//splits the item  text to the next line
				for(String line : game.getMap().getEntityManager().
						getPlayer().inventory.get(itemIndex).description.split("\n")) {
					g.drawString(line, textX, textY);
					textY +=10;
				}
			}
		}
		
	}
	
	public static int getItemIndexOnslot() {
		int itemIndex = slotCol +(slotRow*5);
		//item slots
		if(itemIndex == -370)return 0;
		if(itemIndex == -315)return 1;
		if(itemIndex == -255)return 2;
		if(itemIndex == -195)return 3;
		
		if(itemIndex == -140)return 4;
		if(itemIndex == -95)return 5;
		if(itemIndex == -15)return 6;
		if(itemIndex == -45)return 7;

		if(itemIndex == 100)return 8;
		if(itemIndex == 160)return 9;
		if(itemIndex == 285)return 10;
		if(itemIndex == 345)return 11;

		if(itemIndex == 405)return 12;
		if(itemIndex == 460)return 13;
		if(itemIndex == 530)return 14;
		if(itemIndex == 585)return 15;
		
		if(itemIndex == 645)return 16;
		if(itemIndex == 710)return 17;
		if(itemIndex == 760)return 18;
		return -1;
	}
	
	
	private static void drawSubWindow(Graphics g,int x, int y, int width, int height) {
		Color c = new Color(0,0,0,210);
		Graphics2D g2 = (Graphics2D)g;
		g.setColor(c);
		g.fillRoundRect(x,y, width, height, 35, 35);
	
		c = new Color(255,255,255);
		g.setColor(c);
		g2.setStroke(new BasicStroke(5));
		g2.drawRoundRect(x+5, y+5,width-10, height-10,25, 25);
		
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
	public static boolean isVisible() {
		return visible;
	}
	public static void setVisible(boolean visible) {
		UI.visible = visible;
	}
	public static String getDialodgeText() {
		return dialodgeText;
	}
	public static void setDialodgeText(String dialodgeText) {
		UI.dialodgeText = dialodgeText;
	}
	
	
	
	
}
