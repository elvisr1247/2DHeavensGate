package entitys;


//import
import java.awt.Graphics;
import java.awt.Rectangle;

import main.Game;
import map.Map;
import tiles.TileType;
import tiles.Tiles;



public abstract class Entity {
	

  protected float x,y;
  protected int width,height;
  protected Rectangle bounds = new Rectangle(0,0,width,height);
  protected Rectangle detecPlayer = new Rectangle(0,0,0,0);
  private Rectangle attackBounds = new Rectangle(0,0,32,32);
  protected boolean activeEntity = true;
  protected boolean unkillableEntity = false;
  protected int maxBaseLife = 4;
  protected boolean hpBarOn = false;
  protected int health;
  protected int hpBarCounter = 0;
  protected Game game;
  protected int attackDamage = 0;
  public Entity() {}
  
  public Entity(Game game,float x,float y,int width,int height){
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
      this.game = game;
      
      bounds = new Rectangle(0,0,width,height);
  }

  public abstract void update();
  
  public abstract void draw(Graphics g);
  
  public abstract void die();
  
  public Rectangle getBounds(float xOffset,float yOffset) {
		return new Rectangle((int)(x + bounds.x + xOffset)
					,(int)(y + bounds.y+yOffset),
					bounds.width,bounds.height);
	}
	 
   public void hurt(int amt) {
		hpBarOn = true;
		health -= amt;
		if(health <= 0) {
			activeEntity = false;
			die();
		}
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
	
	public boolean isActiveEntity() {
		return activeEntity;
	}

	public void setActiveEntity(boolean activeEntity) {
		this.activeEntity = activeEntity;
	}
	
	public boolean isUnkillableEntity() {
		return unkillableEntity;
	}

	public void setUnkillableEntity(boolean unkillableEntity) {
		this.unkillableEntity = unkillableEntity;
	}

	public Rectangle getAttackBounds() {
		return attackBounds;
	}

	public void setAttackBounds(Rectangle attackBounds) {
		this.attackBounds = attackBounds;
	}
}
