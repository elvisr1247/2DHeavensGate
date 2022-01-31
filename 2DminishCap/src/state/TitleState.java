package state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import gfx.Assets;
import gfx.ImageLoader;
import main.tt;



public class TitleState extends State {
	
	

	//TODO:ADD BLINKING TEXT & background img
	private tt t;
	
	private Font arial,copyRight;
	private String title = "Title",
			title2="Screen",copy ="\u00a9 2021 Tengoku",
			text = "[press enter]";
	public TitleState(tt t) {
		super(t);
		this.t = t;
		arial = new Font("Arial",Font.PLAIN,96);
		copyRight = new Font("Ariel",Font.PLAIN,15);
	}
	@Override
	public void update() {
		if(!(t == null))
	
		if(t.getKeyManager().enter) {
			State.setState(t.getGameState());
		}
		
	}

	@Override
	public void draw(Graphics g) {
//		g.drawImage(ImageLoader.loadImage("/img/bluemoon.png"),
//				0,0,t.getWidth(),t.getHeight(), null);
		if(!(t == null))
		g.drawImage(Assets.background,
				0, 0, t.getWidth(),t.getHeight(), null);
		g.setFont(arial);
		g.setColor(Color.yellow);
		g.drawString(title, 230, 140);
		g.drawString(title2, 170, 220);
		
		
		g.setFont(copyRight);
		g.drawString(text, 270, 260);
		g.drawString(copy, 250, 390);
		
	}

}
