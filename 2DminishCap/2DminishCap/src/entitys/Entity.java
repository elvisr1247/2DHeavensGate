package entitys;

import java.awt.Graphics;
import java.awt.Rectangle;

import main.Game;
import tiles.TileType;
import tiles.Tiles;

public class Entity extends GameObject {


	
	  public String direction = "";
	  protected int xMove,yMove;
	  protected Rectangle collisionBox = new Rectangle(0,0,width,height);
	  protected Rectangle attackCollisionBox = new Rectangle(0,0,width,height);
	  
	  public static int size = 64;

	  public int DEFAULTSPEED = 5;
	  public int speed = DEFAULTSPEED;
//	  int maxSpeed = 5;


	  protected Tiles tiles;
	  
	  public Entity() {}
	  
	  public Entity(Game game, int x, int y,int width,int height) {
			super(game, x, y,width,height);
		}
	

	  public void move() {
	  	 moveX();
	  	 moveY();
	  }
	  
	  public void moveX() {
		  x += xMove;
//		  if(xMove > 0) {//right movement
////			  int tx = (int)(x+xMove + collisionBox.x + collisionBox.width)/64;
////			  if(!collision(tx,(int)(y+collisionBox.y)/64)) {
//				  x+=xMove;
////			  }
//			  
//				  x+=xMove;
//		  }else  if(xMove < 0){//left movement
//			  x+=xMove;
//		  }
	  }
	  
	  public void moveY() {
		  y += yMove;
//	  	 if(yMove > 0) {//top movement
//			  y+=yMove;
//		  }else  if(yMove < 0){//down movement
//			  y+=yMove;
//		  }
	  }
	  
		@Override
		public void update() {
			
			
		}



		@Override
		public void draw(Graphics g) {
			
			
		}
	  
	  public boolean collision(int i, int j) {
//		  System.out.println(i+","+j);
			if(x == i && y == j) 
				return true;
			else
				return false;
	  }
	  
	  
	  public float getX() {
	      return x;
	  }

	  public void setX(int x) {
	      this.x = x;
	  }
	  public float getY() {
	      return y;
	  }

	  public void setY(int y) {
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
