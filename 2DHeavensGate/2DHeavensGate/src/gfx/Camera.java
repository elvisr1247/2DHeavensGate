package gfx;

import entitys.Creature;
import main.Game;
import map.Map;

public class Camera {

	private float xOffset,yOffset;
	Game game;
	
	public Camera(Game game,float xOffset,float yOffset) {
		this.game = game;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	public void cameraLimits() {
		
		float worldX = game.getMap().getWidth()*64 - game.getWidth()+14;
		float worldY = game.getMap().getHeight()*64 - game.getHeight()+34;
		
		if(xOffset < 0) {//left
			xOffset = 0;
		}else if(xOffset > worldX) { //right
			xOffset = worldX;
		}
		
		if(yOffset < 0) {//up
			yOffset = 0;
		}else if(yOffset > worldY ) {//down
			yOffset = worldY ;
		}
		
	}
	
	public void update(Creature player){
		xOffset = (int)player.getX() - game.getWidth()/2 + 36;
		yOffset = (int)player.getY() - game.getHeight()/2 + 54;
		cameraLimits();
		
	}

	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}
	
	
}
