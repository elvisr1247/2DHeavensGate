package entitys;


//import
import java.awt.Graphics;
import java.awt.Rectangle;

import main.Game;
import map.Map;
import tiles.TileType;
import tiles.Tiles;



public abstract class GameObject {
	
  protected int width = 64, height = 64;
  public String direction = "";
  public int x;
  public int y;
  protected int xMove,yMove;
  public Rectangle rect = new Rectangle(0,0,width,height);
  protected Rectangle arect = new Rectangle(0,0,width,height);
  
  int size = 64;

  public int DEFAULTSPEED = 3;
  public int speed = DEFAULTSPEED;
  int maxSpeed = 5;

  protected Game game;
  protected Tiles tiles;
  
  public GameObject(Game game, int x , int y){
      this.x = x;
      this.y = y;
      this.game = game;
  }

  public abstract void update();
  
  public abstract void draw(Graphics g);
  
  public void move() {
  	 moveX();
  	 moveY();
  }
  
  public void moveX() {
	  
	  if(xMove > 0) {//right movement
		  int tx = (int)(x+xMove + rect.x + rect.width)/64;
		  if(!collision(tx,(int)(y+rect.y)/64)) {
			  x+=xMove;
		  }
	  }else  if(xMove > 0){//left movement
		  
	  }
  }
  
  public void moveY() {
  	y += yMove;
  }
  
  public boolean collision(int x,int y) {
	  Tiles t = new Map(game).map[x][y];
	  boolean brick = TileType.Brick.solid;
	  boolean tree = TileType.Tree.solid;
	  	
	  if(brick||tree)
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
