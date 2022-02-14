package gfx;

import entitys.Entity;
import main.Game;

public class Camera {

	private float xOffset,yOffset;
	Game game;
	
	public Camera(Game game,float xOffset,float yOffset) {
		this.game = game;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	public void cameraLimits() {
		if(xOffset < 0) {//left
			xOffset = 0;
		}
//		else if(xOffset > game.getWidth()) {//right
//			xOffset = game.getWidth();
//		}
		if(yOffset < 0) {//up
			yOffset = 0;
		}
//		else if(yOffset > game.getHeight()-155) {//down
//			yOffset = game.getHeight()-155;
//		}
		
	}
	
	public void update(Entity player){
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
