package entitys;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import main.tt;



public class Player extends GameObject {

    private int health = 2,coins = 0;    
    private boolean attackActive = false;
    private boolean stats = false;
    private int count = 0;

    public Player(tt t, int x, int y) {
        super(t, x, y);    
        rect = new Rectangle(18,38,27,25);      
        arect = new Rectangle(80,25,15,30);
    }

    @Override
    public void update() {

    	xMove = 0;
        yMove = 0;     
        if(!(t.getKeyManager()==null))
        if(t.getKeyManager().up){
            direction = "up";
            yMove -= speed;
        }else if(t.getKeyManager().down){
        	direction = "down";
        	yMove += speed;
        }else if(t.getKeyManager().right){
            direction = "right";
            xMove += speed;
        }else if(t.getKeyManager().left){
            direction = "left";
            xMove -= speed;
        }
        
        if(t.getKeyManager().enter) count++;
        onorOff();
        
        if(t.getKeyManager().attack)attackActive = true;
        else attackActive = false;
    	
    	 move();   
    }
    
    
    private void onorOff() {
		if(count == 1) {
			 stats = true;
		}
		
	}

	@Override
	public void draw(Graphics g) {
    	g.setColor(Color.white);
      	g.drawRect(x,y,width,height);	
      	//draws collision box
      	g.setColor(Color.magenta);
      	g.drawRect((x +rect.x), (y + rect.y),rect.width, rect.height);
      	
      	attackCollisionBox(g);
	}

	private void attackCollisionBox(Graphics g) {
		//draws collision box
		if(attackActive) {
			switch(direction) {
				case "up"://top is good
					g.drawRect((x + arect.x)-55, (y + arect.y)-60,arect.width, arect.height);
					break;
				case "down":
					g.drawRect((x + arect.x)-55, (y + arect.y)+50,arect.width, arect.height);
					break;
				case "left"://left is good
					g.drawRect((x + arect.x)-110, (y + arect.y),arect.width, arect.height);
					break;
				case "right"://right is good
					g.drawRect((x + arect.x), (y + arect.y),arect.width, arect.height);
					break;
				default:
					g.drawRect((x + arect.x), (y + arect.y),arect.width, arect.height);
			}
		}
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public boolean isStats() {
		return stats;
	}

	public void setStats(boolean stats) {
		this.stats = stats;
	}

}
