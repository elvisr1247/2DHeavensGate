package entitys;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import gfx.Assets;
import main.Game;
import map.Map;
import state.State;



public class Player extends Entity {

    private int rupees = 000;    
    private boolean attackActive = false;
    private boolean stats = false;
    private int DEFAULTSPEED = 4;
    private int MAX_SPEED = 7;
	private int speed = DEFAULTSPEED;
    private int count = 0;
    //attack cool down timer
    private long lastAttackTimer,attackCooldown = 800,attackTimer = attackCooldown;
   
    public Player(Game game,Map m,float x, float y) {
    	super(game,m,x, y,64,64);    
    	bounds = new Rectangle(18,38,27,25);  
     
        
        health = 3;
	}

	@Override
    public void update() {

    	xMove = 0;
        yMove = 0;   

       getInput();
       move();  
    	 
    } 
	
	@Override
	public void draw(Graphics g) {
    	g.setColor(Color.white);
      	g.drawImage(Assets.player[0],(int)x,(int)y,width,height,null);
      	
      	//draws collision box
      	g.setColor(Color.magenta);
      	g.drawRect((int)(x +bounds.x), (int)(y + bounds.y),bounds.width, bounds.height);
      	
      	attackCollisionBox(g);
	}

	private void getInput() {
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
	   	 
	   	 if(game.getKeyManager().run)
	   		speed = MAX_SPEED;
	   	else
	   		speed = DEFAULTSPEED;
	   	if(State.getState() == game.getGameState()) {
	   		if(game.getKeyManager().enter) { 
	   			count++;
	   			onorOff();
	   			}
	   		}
	   	if(game.getKeyManager().attack)attackActive = true;
	   	else attackActive = false;
	}
	
	private void attackCollisionBox(Graphics g) {
		attackTimer += System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer = System.currentTimeMillis();
		if(attackTimer < attackCooldown)
			return;
		
		int rsize = 30;
		Rectangle cb = getBounds(0,0);
		Rectangle ar = new Rectangle(10,10,rsize,rsize);
		if(attackActive) {
			if(direction.equals("up")) {
				ar.x = cb.x + cb.width/2 - rsize/2;
				ar.y = cb.y - rsize;
			}else if(direction.equals("down")) {
				ar.x = cb.x + cb.width / 2 - rsize /2;
				ar.y = cb.y + cb.height;
			}else if(direction.equals("left")) {
				ar.x = cb.x  - rsize;
				ar.y = cb.y + cb.height / 2 - rsize / 2;
			}else if(direction.equals("right")) {
				ar.x = cb.x + cb.width;
				ar.y = cb.y + cb.height /2 - rsize / 2;
			}
		
			attackTimer = 0;
			
			g.drawRect((int)(ar.x),
					(int)(ar.y),ar.width, ar.height);
			
		for(Entity e : m.getEntites()) {
			//if entity doesnt equal its self do this
			if(e.equals(this))continue;
			if(e.getBounds(0, 0).intersects(ar)) {
				e.hurt(1);
				return;
			}
		}
	 }
	
	}

	//check if odd or even 
   private void onorOff() {if(count % 2 == 0)stats = true;else stats = false;}
	
	@Override
	public void die() {
		// TODO Auto-generated method stub
		
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

	public int getHealth() {
		return health;
	}

}
