package gfx;

import main.tt;

public class Camera {
	
	private tt t;
	float offsetMaxX,offsetMaxY;
	float offsetMinX = 0,offsetMinY = 0;
	public float camX;
	public float camY;
	

	public Camera (tt t){
		super();
		this.t = t;
		
	}
	public void update(float playerX,float playerY,float mapX, float mapY) {
		offsetMaxX = mapX - t.getWidth();
		offsetMaxY = mapY - t.getHeight();
		
		camX = playerX;
		camY = playerY;
		
		if(camX > offsetMaxX) {
			camX = offsetMaxX;
		}else if (camX < offsetMinX) {
			camX = offsetMinX;
		}
		if(camY > offsetMaxY) {
			camY = offsetMaxY;
		}else if (camY < offsetMinY) {
			camY = offsetMinY;
		}
		
	}
	public float getOffsetMaxX() {
		return offsetMaxX;
	}
	public void setOffsetMaxX(float offsetMaxX) {
		this.offsetMaxX = offsetMaxX;
	}
	public float getOffsetMaxY() {
		return offsetMaxY;
	}
	public void setOffsetMaxY(float offsetMaxY) {
		this.offsetMaxY = offsetMaxY;
	}
	public float getOffsetMinX() {
		return offsetMinX;
	}
	public void setOffsetMinX(float offsetMinX) {
		this.offsetMinX = offsetMinX;
	}
	public float getOffsetMinY() {
		return offsetMinY;
	}
	public void setOffsetMinY(float offsetMinY) {
		this.offsetMinY = offsetMinY;
	}
	public float getCamX() {
		return camX;
	}
	public void setCamX(float camX) {
		this.camX = camX;
	}
	public float getCamY() {
		return camY;
	}
	public void setCamY(float camY) {
		this.camY = camY;
	}


}
