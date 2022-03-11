package state;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.io.IOException;
import java.io.InputStream;

import UI.UI;
import gfx.Assets;
import main.Game;



public class TitleState extends State {
	
	

	//TODO:ADD BLINKING TEXT & background img
	private Game game;
	
	private String title = "Heaven's",
			title2="Gate",copy ="\u00a9 2021 Tengoku",
			startButton = "Start",settingsButton = "Settings",
			quitButton = "Quit";
	
	Font font1;
	
	public TitleState(Game game) {
		super(game);
		this.game = game;
		
		
		
	}
	@Override
	public void update() {
		
	}

	@Override
	public void draw(Graphics g) {
	
//		g.drawImage(Assets.GateBackground,
//				0, 0, game.getWidth(),game.getHeight(), null);
		
		g.drawImage(Assets.Moonbackground,
				0, 0, game.getWidth(),game.getHeight(), null);
		
		g.setFont(Assets.font64);
	
		Color c = new Color(255,255,240);//white(ivory)
		g.setColor(c);
		g.drawString(title, 250, 140);
		g.drawString(title2, 315, 220);
		
		
		g.setFont(Assets.font16);	
		
		//start&settings buttons
		g.drawString(startButton,360, 290);
		g.drawString(settingsButton,350, 320);
		g.drawString(quitButton, 370, 350);
		

		if(UI.commandNum == 0) {
			g.drawString(">", 340, 290);
		}else if(UI.commandNum == 1) {
			g.drawString(">", 330, 320);
		} else if(UI.commandNum == 2) {
			g.drawString(">", 350, 350);
		}
		
		g.drawString(copy, 325, 500);
		
	}

}
