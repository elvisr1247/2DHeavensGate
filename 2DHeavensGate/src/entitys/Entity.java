package entitys;

import java.awt.Graphics;
import java.awt.Rectangle;

import main.Game;
import map.Map;
import tiles.TileType;
import tiles.Tiles;

public class Entity extends GameObject {

	  public String direction = "";
	  protected int xMove,yMove;
	  protected Rectangle bounds;
	  protected Rectangle attackCollisionBox;
	  protected Tiles tiles;
	  protected Map m;
	   
	  public Entity() {}
	  
	  public Entity(Game game,Map m,float x, float y,int width,int height) {
			super(game,x, y,width,height);
			this.m = m;
		}
	
	  public void move() {		 
		    //updates entity collision as player moves
		  	if(!collisionWithEntity(xMove,0f))
			  moveX();
			if(!collisionWithEntity(0f,yMove))
			  moveY();  
	  }
	  
	  public void moveX() {
		  int tx;
		  if(xMove > 0) {//right movement
			  tx  = (int)(x + xMove + bounds.x + bounds.width)/64;
			  if(!collisionWithTile(tx,(int)(y + bounds.y)/64)&&
					  !collisionWithTile(tx,(int)(y + bounds.y + bounds.height)/64))
	              x += xMove;
			  else x = tx * 64 - bounds.x - bounds.width - 1;
		  }else  if(xMove < 0){//left movement
			  tx = (int)(x+ xMove + bounds.x)/64;
			  if(!collisionWithTile(tx,(int)(y+bounds.y)/64)&&
					  !collisionWithTile(tx,(int)(y+bounds.y+bounds.height)/64))
			  		x+=xMove;
			  else x = tx * 64 + 64 - bounds.x;
		  }
		 
	  }
	  
	  public void moveY() {
		 int ty;
	  	 if(yMove > 0) {//top movement
	  		  ty = (int)(y + yMove + bounds.y+bounds.height)/64;
	  		 if(!collisionWithTile((int)(x+bounds.x)/64,ty)&&
	  				 !collisionWithTile((int)(x+bounds.x+bounds.width)/64,ty))
	  			 y+=yMove;
	  		 else y = ty * 64 - bounds.y - bounds.height - 1;

	  		
		  }else  if(yMove < 0){//down movement  
			  ty = (int)(y + yMove + bounds.y)/64;
		  		 if(!collisionWithTile((int)(x+bounds.x)/64,ty)&&
		  				 !collisionWithTile((int)(x+bounds.x+bounds.width)/64,ty)) {
		  			 y+=yMove;
		  		 }else {y = ty * 64 + 64 - bounds.y;}
		  }
	
	  }
	  
	@Override
	public void update() {}

	@Override
	public void draw(Graphics g) {}
	  
	public boolean collisionWithTile(int xco,int yco){return m.getTile(xco, yco).isSolid();}
	
	//x & y offset used to return a react
	public boolean collisionWithEntity(float xOffset,float yOffset) {
		for(Entity e : m.getE()) {
			//skips to the next entity and check other entity's doesn't check the same entity twice
			if(e.equals(this))
				continue;
			if(e.getBounds(0f,0f).intersects(getBounds(xOffset,yOffset))) {
				return true;
			}
		}
		return false;
	}
	
	public Rectangle getBounds(float xOffset,float yOffset) {
		return new Rectangle((int)(x + bounds.x + xOffset)
				,(int)(y + bounds.y+yOffset),
				bounds.width,bounds.height);
	}
	
	

	public float getX() {
	     return x;
	}

	public void setX(float x) {
	     this.x = x;
	}
	public float getY() {
	     return y;
	}

	public void setY(float y) {
	     this.y = y;
	}

	public int getWidth() {
		return width;
	 }

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	 }

	public void setHeight(int height) {
		this.height = height;
	}

	public int getxMove() {
		return xMove;
	}

	public void setxMove(int xMove) {
		this.xMove = xMove;
	}

	public int getyMove() {
		return yMove;
	}

	public void setyMove(int yMove) {
		this.yMove = yMove;
	}

}
