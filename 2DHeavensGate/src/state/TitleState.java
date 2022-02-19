package state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;

import gfx.Assets;
import main.Game;



public class TitleState extends State {
	
	

	//TODO:ADD BLINKING TEXT & background img
	private Game game;
	
	private String title = "Heaven's",
			title2="Gate",copy ="\u00a9 2021 Tengoku",
			text = "[Left & Right Click]",startButton = "START",
			settingsButton = "SETTINGS";
	
	JButton button;
	
	public TitleState(Game game) {
		super(game);
		this.game = game;
		button = new JButton(startButton);
	
	}
	@Override
	public void update() {
		if(!(game == null))
		if(game.getMouseManager().isLeftPressed()
				&& game.getMouseManager().isRightPressed()) 
			State.setState(game.getGameState());
		
		
	}

	@Override
	public void draw(Graphics g) {
	
		
		if(!(game == null))
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
		g.drawString(text,319, 260);
		
		//start&settings buttons
		g.drawString(startButton,360, 290);
		g.drawString(settingsButton,350, 320);
		
//		c = new Color(255, 255, 255);
//		g.setColor(c);
		g.drawString(copy, 325, 500);
		
		g.drawImage(Assets.button[0],100,100,64,64, null);
		g.drawImage(Assets.button[1],100,200,64,64, null); 
		
//		for(int x = 0;x<game.getWidth();x+=64)
//			for(int y = 0; y < game.getHeight();y+=64)
//				g.drawRect(x, y, 64, 64);
		
	}

}
