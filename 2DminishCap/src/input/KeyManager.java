package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
    //keys
    public boolean up = false,down = false,
            right = false,left = false,attack = false,
            enter = false;
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
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
        }else if(e.getKeyCode() == KeyEvent.VK_E) {
             attack = true;
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
        }else if(e.getKeyCode() == KeyEvent.VK_E) {
            attack = false;
       }else if(e.getKeyCode() == KeyEvent.VK_ENTER) {
       	enter = true;
       }
        
    }
}