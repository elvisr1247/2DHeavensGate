package state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import gfx.Assets;
import main.Game;



public class TitleState extends State {
	
	

	//TODO:ADD BLINKING TEXT & background img
	private Game game;
	
	private Font arial,copyRight;
	private String title = "Title",
			title2="Screen",copy ="\u00a9 2021 Tengoku",
			text = "[press enter]";
	public TitleState(Game game) {
		super(game);
		this.game = game;
		arial = Assets.Ariel64;
		copyRight = Assets.Ariel32;
	}
	@Override
	public void update() {
		if(!(game == null))
	
		if(game.getKeyManager().enter) {
			State.setState(game.getGameState());
		}
		
	}

	@Override
	public void draw(Graphics g) {
//		g.drawImage(ImageLoader.loadImage("/img/bluemoon.png"),
//				0,0,t.getWidth(),t.getHeight(), null);
		if(!(game == null))
		g.drawImage(Assets.background,
				0, 0, game.getWidth(),game.getHeight(), null);
		g.setFont(arial);
		g.setColor(Color.yellow);
		g.drawString(title, 250, 140);
		g.drawString(title2, 200, 220);
		
		
		g.setFont(copyRight);
		g.drawString(text, 270, 260);
		g.drawString(copy, 250, 390);
		
	}

}
