package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import UI.UI;
import main.Game;
import state.State;

public class KeyManager implements KeyListener {
    //keys
    public boolean up = false,down = false,
            right = false,left = false,attack = false,run = false,
            enter = false;
    private Game game;
    public KeyManager(Game game) {
    	this.game = game;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
    	if(State.getState() == game.getTitleState()) {
    		if(e.getKeyCode() == KeyEvent.VK_W
    				|| e.getKeyCode() == KeyEvent.VK_UP) {
    			UI.commandNum--;
    			if(UI.commandNum < 0)UI.commandNum = 2;
    		}
    		if(e.getKeyCode() == KeyEvent.VK_S
    				|| e.getKeyCode() == KeyEvent.VK_DOWN) {
    			UI.commandNum++;
    			if(UI.commandNum > 2)UI.commandNum = 0;
    		}
    		
    		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
    			if(UI.commandNum == 0) {
    				State.setState(game.getGameState());
    			}else if(UI.commandNum == 1) {
    				
    			}else if(UI.commandNum == 2) {System.exit(0);}
    		}
    		
    	}
    	
        if(e.getKeyCode() == KeyEvent.VK_W
                || e.getKeyCode() == KeyEvent.VK_UP){
            up = true;
        }else if(e.getKeyCode() == KeyEvent.VK_S
                || e.getKeyCode() == KeyEvent.VK_DOWN){
            down = true;
        }else if(e.getKeyCode() == KeyEvent.VK_D
                || e.getKeyCode() == KeyEvent.VK_RIGHT){
            right = true;
        }else if(e.getKeyCode() == KeyEvent.VK_A
                || e.getKeyCode() == KeyEvent.VK_LEFT){
            left = true;
        }else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
             attack = true;
        }else if(e.getKeyCode() == KeyEvent.VK_SHIFT) {
        	run = true;
        }else if(e.getKeyCode() == KeyEvent.VK_ENTER) {
        	enter = true;
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W
                || e.getKeyCode() == KeyEvent.VK_UP){
            up = false;
        }else if(e.getKeyCode() == KeyEvent.VK_S
                || e.getKeyCode() == KeyEvent.VK_DOWN){
            down = false;
        }else if(e.getKeyCode() == KeyEvent.VK_D
                || e.getKeyCode() == KeyEvent.VK_RIGHT){
            right = false;
        }else if(e.getKeyCode() == KeyEvent.VK_A
                || e.getKeyCode() == KeyEvent.VK_LEFT){
            left = false;
        }else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            attack = false;
       }else if(e.getKeyCode() == KeyEvent.VK_SHIFT) {
       		run = false;
       }else if(e.getKeyCode() == KeyEvent.VK_ENTER) {
       		enter = false;
       }
        
    }
}