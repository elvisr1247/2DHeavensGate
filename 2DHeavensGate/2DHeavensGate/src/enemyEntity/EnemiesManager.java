package enemyEntity;

import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

import entitys.Creature;
import main.Game;

public class EnemiesManager extends Creature {
	
	protected enum state{Wonder,Attack,Chase}
	protected state states = state.Wonder;
	protected int speed = 1;
	
	boolean flipped = false;
	
	public EnemiesManager(Game game, float x, float y, int width, int height) {
		super(game, x, y, width, height);
	}
	
	public void update() {
	
	}
	
	public void draw(Graphics g) {
		
	}


	public void directionMovement() {
		//direction movement
			switch(direction) {
				case "up":yMove-=speed;
					break;
				case "down":yMove+=speed;
					break;
				case "right":xMove+=speed;
					break;
				case "left":xMove-=speed;
					break;
			}
//			System.out.println(speed);
	}
}
