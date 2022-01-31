package entitys;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import main.Game;
import tiles.Tiles;



public class Player extends GameObject {

    private int health = 2,coins = 0;    
    private boolean attackActive = false;
    private boolean stats = false;
    private int count = 0;
  
    public Player(Game game, int x, int y) {
        super(game, x, y);    
        rect = new Rectangle(18,38,27,25);      
        arect = new Rectangle(80,25,15,30);
    }

    @Override
    public void update() {

    	xMove = 0;
        yMove = 0;   
        
        if(!(game.getKeyManager()==null))
        	
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
        if(game.getKeyManager().run && game.getKeyManager().up ||
        		game.getKeyManager().run && game.getKeyManager().down ||
        		game.getKeyManager().run && game.getKeyManager().right ||
        		game.getKeyManager().run && game.getKeyManager().left) {
        	if(maxSpeed >= speed)
        		speed++; 
        }else {
        	speed = DEFAULTSPEED;
        }
        
        if(game.getKeyManager().enter) count++;
        onorOff();
        
        if(game.getKeyManager().attack)attackActive = true;
        else attackActive = false;
    	
//        System.out.println(speed);
//        collisdes();
//        collisdes(tiles);
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
