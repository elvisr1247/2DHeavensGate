package plants;

import java.awt.Graphics;
import java.awt.Rectangle;

import Item.Item;
import entitys.Entity;
import gfx.Assets;
import main.Game;

public class Grass extends Entity{
	
	
	public Grass(Game game,float x,float y){
		super(game,x,y,64,64);
		bounds = new Rectangle(0,0,0,0);
	
		health = 1;
	}

	@Override
	public void update() {
		detecPlayer = new Rectangle((int)x,(int) y,width,height);
		if(playerDetected()) {
				die();
		}
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(Assets.grass,(int)x, (int)y, width, height,null);
	}
	
	 public boolean playerDetected() {
			if(game.getMap().getEntityManager().getPlayer().getAttackBounds().intersects(detecPlayer)) {
				return true;
			}
			return false;
		}
	
	@Override
	public void die() {
		setActiveEntity(false);
		game.getMap().getItemManager().addItem(Item.ruppe.createNew((int)x+15, (int)y+15));
		
	}
	

}
