package entitys;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import main.Game;



public class Player extends Entity {

    private int health = 2,rupees = 000;    
    private boolean attackActive = false;
    private boolean stats = false;
    private int count = 0;
  
    
    public Player(Game game, int x, int y) {
        super(game, x, y,size,size);    
        collisionBox = new Rectangle(18,38,27,25);      
        attackCollisionBox  = new Rectangle(80,25,15,30);
    }

    @Override
    public void update() {

    	xMove = 0;
        yMove = 0;   
        
        	
        if(game.getKeyManager().up){
            direction = "up";
            yMove -= speed;
        }else if(game.getKeyManager().down){
        	direction = "down";
        	yMove += speed;
        }else if(game.getKeyManager().right){
            direction = "right";
            xMove += speed;
        }else if(game.getKeyManager().left){
            direction = "left";
            xMove -= speed;
        }
        
        if(game.getKeyManager().enter) { 
        	count++;
        	onorOff();
        }
        if(game.getKeyManager().attack) {attackActive = true;}
        else {attackActive = false;}
        
      
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
      	g.drawRect((x +collisionBox.x), (y + collisionBox.y),collisionBox.width, collisionBox.height);
      	
      	attackCollisionBox(g);
	}

	private void attackCollisionBox(Graphics g) {
		//draws collision box
		if(attackActive) {
			switch(direction) {
				case "up"://top is good
					g.drawRect((x + attackCollisionBox .x)-55, (y + attackCollisionBox .y)-60,attackCollisionBox .width, attackCollisionBox .height);
					break;
				case "down":
					g.drawRect((x + attackCollisionBox .x)-55, (y + attackCollisionBox .y)+50,attackCollisionBox .width, attackCollisionBox .height);
					break;
				case "left"://left is good
					g.drawRect((x + attackCollisionBox .x)-110, (y + attackCollisionBox .y),attackCollisionBox .width, attackCollisionBox .height);
					break;
				case "right"://right is good
					g.drawRect((x + attackCollisionBox .x), (y + attackCollisionBox .y),attackCollisionBox .width, attackCollisionBox .height);
					break;
				default:
					g.drawRect((x + attackCollisionBox .x), (y + attackCollisionBox .y),attackCollisionBox .width, attackCollisionBox .height);
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

	public int getRupees() {
		return rupees;
	}

}
