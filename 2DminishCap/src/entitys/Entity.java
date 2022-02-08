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
	  
//	  Map m;
	  
	  public static int size = 64;

	  public int DEFAULTSPEED = 5;
	  public int speed = DEFAULTSPEED;

	  protected Rectangle bounds;
		protected Rectangle attackCollisionBox = new Rectangle(0,0,width,height);
	  
	  
	  protected Tiles tiles;
	  
	  Map m;
	  
	  public Entity() {}
	  
	  public Entity(Game game,Map m, float x, float y,int width,int height) {
			super(game, x, y,width,height);
			this.m = m;
//			m = new Map();
		}
	

	  public void move() {
	  	 moveX();
	  	 moveY();
	  }
	  
	  public void moveX() {
//		  x += xMove;
		  int tx;
		  if(xMove > 0) {//right movement
			  tx  = (int)(x + xMove + bounds.x + bounds.width)/64;
			  
			  if(!a(tx,(int)(y + bounds.y)/64)&&
					  !a(tx,(int)(y + bounds.y + bounds.height)/64))
	                x += xMove;
			  else
				  x = tx * 64 - bounds.x - bounds.width - 1;
			  
		  }else  if(xMove < 0){//left movement
			  tx = (int)(x+ xMove + bounds.x)/64;
			  if(!a(tx,(int)(y+bounds.y)/64)&&
					  !a(tx,(int)(y+bounds.y+bounds.height)/64))
			  		x+=xMove;
			  else
				  x = tx * 64 + 64 - bounds.x;
		  }
		  
		  int xp = (int)(x+bounds.x)/64,yp = (int)(y+bounds.y)/64;
	       
//			System.out.println(m.getTile(xp, yp).getType()
//					+","+m.getTile(xp, yp).isSolid());
	  }
	  
	  public void moveY() {
//		  y += yMove;
		  int ty;
	  	 if(yMove > 0) {//top movement
	  		  ty = (int)(y + yMove + bounds.y)/64;
	  		 
	  		 if(!a((int)(x+bounds.x)/64,ty)&&
	  				 !a((int)(x+bounds.x+bounds.width)/64,ty))
	  			 y+=yMove;
//	  		 else
//	  			 y = ty * 64 + 64 - bounds.y;
	  		 
		  }else  if(yMove < 0){//down movement
			  
			  ty = (int)(y + yMove + bounds.y + bounds.height)/64;
		  		 
		  		 if(!a((int)(x+bounds.x)/64,ty)&&
		  				 !a((int)(x+bounds.x+bounds.width)/64,ty))
		  			 y+=yMove;
//		  		 else
//		  			 y = ty * 64 + 64 - bounds.y;
		  }
	
	  }
	  
		@Override
	 public void update() {}

		@Override
	 public void draw(Graphics g) {}
	  
		public boolean a(int xco,int yco) {
			return m.getTile(xco, yco).isSolid();
		}
//	public void mm(Map m) {
//			this.m = m;
//	}
		
//	 public boolean co(int x,int y) {
//		 Map m = new Map();
//			return m.getTile(x, y).isSolid();
//	 }
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
