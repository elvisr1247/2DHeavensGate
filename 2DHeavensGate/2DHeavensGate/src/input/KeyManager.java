package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import UI.UI;
import main.Game;
import state.State;

public class KeyManager implements KeyListener {
    //keys
    public boolean up = false,down = false,right = false,left = false,attack = false,run = false,
            enter = false,pause = false,inventory = false;
    
   
    private Game game;
    
    public KeyManager(Game game) {
    	this.game = game;
    }
  
    
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
    	int code = e.getKeyCode();
    	
    	if(code == KeyEvent.VK_W||code == KeyEvent.VK_UP) {
    		up = true;
    	}
    	if(code == KeyEvent.VK_S||code == KeyEvent.VK_DOWN) {
    		down = true;
    	}
    	if(code == KeyEvent.VK_D|| code == KeyEvent.VK_RIGHT) {
    		right = true;
    	}
    	if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
    		left = true;
    	}
    	if(code == KeyEvent.VK_SHIFT) {
    		run = true;
    	}
    	if(code == KeyEvent.VK_SPACE) {
    		attack = true;
    	}
    	if(code == KeyEvent.VK_ENTER) {
    		if(enter)enter = false; else enter = true; 
    	}
    	
    	
    	if(code == KeyEvent.VK_P) {
    		if(pause)pause = false;else pause = true;
    	}
    	
    	if(code == KeyEvent.VK_E) {
    		if(inventory)inventory = false;else inventory = true;
    	}
    		

    	
//    	inventory = keys[KeyEvent.VK_E];
    	
    	 if(pause)inventory = false;
         else if(inventory)pause = false;

    	
    	
    	if(pause)inventory = false;
        else if(inventory)pause = false;
    	
    	
    	
    	if(State.getState() == game.getTitleState()) {
    		if(up) {
    			UI.commandNum--;
    			if(UI.commandNum < 0)UI.commandNum = 2;
    		}
    		if(down) {
    			UI.commandNum++;
    			if(UI.commandNum > 2)UI.commandNum = 0;
    		}
    		
    		if(enter) {
    			if(UI.commandNum == 0) {
    				State.setState(game.getGameState());
    			}else if(UI.commandNum == 1) {
    				
    			}else if(UI.commandNum == 2) {System.exit(0);}
    			enter = false;
    			inventory = false;
    			pause = false;
    		}
    		
    		
    	}

       
      
       
    }
    @Override
    public void keyReleased(KeyEvent e) {
    	int code = e.getKeyCode();
    	
    	if(code == KeyEvent.VK_W||code == KeyEvent.VK_UP) {
    		up = false;
    	}
    	if(code == KeyEvent.VK_S||code == KeyEvent.VK_DOWN) {
    		down = false;
    	}
    	if(code == KeyEvent.VK_D|| code == KeyEvent.VK_RIGHT) {
    		right = false;
    	}
    	if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
    		left = false;
    	}
    	if(code == KeyEvent.VK_SHIFT) {
    		run = false;
    	}
    	if(code == KeyEvent.VK_SPACE) {
    		attack = false;
    	}
    }
}