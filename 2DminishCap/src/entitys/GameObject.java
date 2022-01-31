package entitys;


//import
import java.awt.Graphics;
import java.awt.Rectangle;

import main.tt;
import map.Map;



public abstract class GameObject {
	
  protected int width = 64, height = 64;
  public String direction = "";
  public int x;
  public int y;
  protected int xMove,yMove;
  public Rectangle rect = new Rectangle(0,0,width,height);
  protected Rectangle arect = new Rectangle(0,0,width,height);
  
  int size = 64;

  
  public int speed = 3;

  protected tt t;
  
  public GameObject(tt t, int x , int y){
      this.x = x;
      this.y = y;
      this.t = t;
  }

  public abstract void update();
  
  public abstract void draw(Graphics g);
  
  public void move() {
  	 moveX();
  	 moveY();
  }
  
  public void moveX() {
	  x+=xMove;
  }
  
  public void moveY() {
  	y += yMove;
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
