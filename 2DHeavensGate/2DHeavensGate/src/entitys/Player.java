package entitys;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Item.Item;
import gfx.Animation;
import gfx.Assets;
import main.Game;



public class Player extends Creature {

    private int rupees = 000;    
    private boolean attackActive = false;
    private boolean stats = false;
    private int DEFAULTSPEED = 4;
    private int MAX_SPEED = 7;
	private int speed = DEFAULTSPEED;
    private int count = 0;
    
    //attack cool down timer
    private long lastAttackTimer,
    	attackCooldown = 500,attackTimer = attackCooldown;
  
    public ArrayList<Item> inventory = new ArrayList<>();
    private final int inventorySize = 20;
    private Animation animDown,animUp,animLeft,animRight;
    public Item currentWeapon;
    
    public Player(Game game,float x, float y) {
    	super(game,x, y,game.tileSize,game.tileSize);    
    	bounds = new Rectangle(18,38,27,25);  
        
        health = 6;
        currentWeapon = Item.grassSword;
        
        
        int animationSpeed = 0;
        if(game.getKeyManager().run == true) animationSpeed = 10;
        else animationSpeed = 100;
        
        animUp = new Animation(animationSpeed,Assets.playerUp);
        animDown = new Animation(animationSpeed,Assets.playerDown);
        animRight = new Animation(animationSpeed,Assets.playerRight);
        animLeft = new Animation(animationSpeed,Assets.playerLeft);
        setItems();
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
		g.drawImage(getCurrentAnimationFrame(),(int)x+10,(int)y+25,42,42,null);
      	hitBox(g);
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
	   	 
	   	 if(game.getKeyManager().run)speed = MAX_SPEED;
	   	 else speed = DEFAULTSPEED;

	   	if(game.getKeyManager().attack)setAttackActive(true);
	   	else setAttackActive(false);
	   	
	   	//animation
	   	if(game.getKeyManager().up == true ||
	    		   game.getKeyManager().down == true||
	    		    game.getKeyManager().left == true|| 
	    		     game.getKeyManager().right == true) {
	   	 animUp.update();
		 animDown.update();
		 animRight.update();
		 animLeft.update();
	   
		}
	}
	public void setItems() {
		inventory.add(Item.axe);
		inventory.add(Item.grassSword);
		inventory.add(Item.potion);
		inventory.add(Item.key);
	}
	private BufferedImage getCurrentAnimationFrame() {
		
//		if(xMove < 0) {//leftanimation
//			return animLeft.getCurrentFrame();
//		}else if(xMove > 0) {//right animation
//			return animRight.getCurrentFrame();
//		}else if(yMove < 0) {//up animation
//			return animUp.getCurrentFrame();
//		}else{//down animation
//			return animDown.getCurrentFrame();
//		}
		if(direction.equals("left")) {//leftanimation
			return animLeft.getCurrentFrame();
		}else if(direction.equals("right")) {//right animation
			return animRight.getCurrentFrame();
		}else if(direction.equals("up")) {//up animation
			return animUp.getCurrentFrame();
		}else{//down animation
			return animDown.getCurrentFrame();
		}
	}
	
	private void hitBox(Graphics g) {
		g.setColor(Color.yellow);
		attackTimer += System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer = System.currentTimeMillis();
		if(attackTimer < attackCooldown)
			return;
		
		if(game.getKeyManager().inventory)return;
		
		if(isAttackActive()) {
			switch(direction) {
				case "up":
					setAttackBounds(new Rectangle((int)x+22,(int)y,16,32));
					break;
				case "down":
					setAttackBounds(new Rectangle((int)x+23,(int)y+70,16,32));
					break;
				case "left":
					setAttackBounds(new Rectangle((int)x-5,(int)y+30,16,32));
					break;
				case "right":
					setAttackBounds(new Rectangle((int)x+50,(int)y+30,16,32));
					break;
				default:
					setAttackBounds(new Rectangle((int)x+50,(int)y+30,16,32));
					break;
			}
			attackTimer = 0;
			g.drawRect((int)getAttackBounds().x,(int)getAttackBounds().y,getAttackBounds().width,getAttackBounds().height);
			
			for(Entity entites : game.getMap().getEntityManager().getEntities()) {
				//if entity doesnt equal its self do this
				if(entites.equals(this))continue;
				if(entites.getBounds(0, 0).intersects(getAttackBounds())) {
					//how much enemys are hurt by
					entites.hurt(attackDamage);
					return;
				}
			}
		}
	}
	
		
	@Override
	public void die() {
		System.out.println("death");
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

	public void setHealth(int health) {
		this.health = health;
	}

	public void setRupees(int rupees) {
		this.rupees = rupees;
	}

	public boolean isAttackActive() {
		return attackActive;
	}

	public void setAttackActive(boolean attackActive) {
		this.attackActive = attackActive;
	}
}
