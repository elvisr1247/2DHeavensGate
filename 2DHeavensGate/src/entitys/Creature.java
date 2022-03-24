package entitys;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import main.Game;
import tiles.Tiles;

public class Creature extends Entity {

	  protected String direction = "";
	  private boolean dialodgeboxavailable = false;
	  
	  
	  protected int xMove,yMove;  
	  protected Tiles tiles;
	  
	  public Creature(Game game,float x, float y,int width,int height) {
			super(game,x, y,width,height);
			bounds = new Rectangle(0,0,width,height);
			attackDamage = 1;
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
			  tx  = (int)(x + xMove + bounds.x + bounds.width)/game.tileSize;
			  if(!collisionWithTile(tx,(int)(y + bounds.y)/game.tileSize)&&
					  !collisionWithTile(tx,(int)(y + bounds.y + bounds.height)/game.tileSize))
	              x += xMove;
			  else x = (float) (tx * game.tileSize - bounds.x - bounds.width - 0.1);
		  }else  if(xMove < 0){//left movement
			  tx = (int)(x+ xMove + bounds.x)/game.tileSize;
			  if(!collisionWithTile(tx,(int)(y+bounds.y)/game.tileSize)&&
					  !collisionWithTile(tx,(int)(y+bounds.y+bounds.height)/game.tileSize))
			  		x+=xMove;
			  else x = tx * game.tileSize + game.tileSize - bounds.x;
		  }
		 
	  }
	  
	  public void moveY() {
		 int ty;
	  	 if(yMove > 0) {//top movement
	  		  ty = (int)(y + yMove + bounds.y+bounds.height)/game.tileSize;
	  		 if(!collisionWithTile((int)(x+bounds.x)/game.tileSize,ty)&&
	  				 !collisionWithTile((int)(x+bounds.x+bounds.width)/game.tileSize,ty))
	  			 y+=yMove;
	  		 else y = (float) (ty * game.tileSize - bounds.y - bounds.height - 0.1);
		  }else  if(yMove < 0){//down movement  
			  ty = (int)(y + yMove + bounds.y)/game.tileSize;
		  		 if(!collisionWithTile((int)(x+bounds.x)/game.tileSize,ty)&&
		  				 !collisionWithTile((int)(x+bounds.x+bounds.width)/game.tileSize,ty)) {
		  			 y+=yMove;
		  		 }else y = ty * game.tileSize + game.tileSize - bounds.y;
		  }
	
	  }
	  
	@Override
	public void update() {}

	@Override
	public void draw(Graphics g) {}
	  
	
	@Override
	public void die() {}
	
	public boolean collisionWithTile(int xco,int yco){return game.getMap().getTile(xco, yco).isSolid();}

	//x & y offset used to return a react
	public boolean collisionWithEntity(float xOffset,float yOffset) {
		for(Entity c : game.getMap().getEntityManager().getEntities()) {
			//skips to the next entity and check other entity's doesn't check the same entity twice
			if(c.equals(this))
				continue;
			if(c.getBounds(0f,0f).intersects(getBounds(xOffset,yOffset))) {
				return true;
			}
		}
		return false;
	}	
	
	
	protected void hpVar(Graphics g,int maxHp) {
		
	    	//health bar
			if(health < maxHp && hpBarOn) {
				double oneScale = (double)64/maxHp;
				double hpBarValue = oneScale * health;
				//draws black border
				g.setColor(new Color(35,35,35));
				g.fillRect((int)x-1,(int)y-16,64+2,7);
				//draws red bar
				g.setColor(new Color(255,0,30));
				g.fillRect((int)x,(int)y-15,(int)hpBarValue,5);
				hpBarCounter++;
				if(hpBarCounter > 600) {
					hpBarCounter = 0;
					hpBarOn = false;
				}
			}
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

	public boolean isDialodgeboxavaivle() {
		return dialodgeboxavailable;
	}

	public void setDialodgeboxavaivle(boolean dialodgeboxavaivle) {
		this.dialodgeboxavailable = dialodgeboxavaivle;
	}



}
