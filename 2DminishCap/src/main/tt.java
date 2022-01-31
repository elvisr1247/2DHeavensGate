package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

import gfx.Assets;
import input.KeyManager;
import state.GameState;
import state.State;
import state.TitleState;


public class tt extends JPanel implements Runnable {
	 //screen
    private JFrame frame;
    private String title = "2D";
    //screen sizes 640x480,800x600,1366x768,1600x900,1920x1080
    private int width = 650,height = 480;
    private boolean running = false;

    //game loop
    private Thread thread;
    //frames per second
    private int FPS = 60;

    //double buffer
    private Image image;
    private Graphics gg;


    //keys
    private KeyManager keyManager;
    
    public State gameState;
    
    private State titleState;
    
    public tt(){
        frame = new JFrame();
        keyManager = new KeyManager();

        frame.add(this);
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyManager);
        this.setFocusable(true);

        frame.setTitle(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width,height);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        Assets.init();
 
        gameState = new GameState(this);
        titleState = new TitleState(this);
//        State.setState(titleState);
        State.setState(gameState);
        
    }



    public synchronized void start(){
        if(running)
            return;

        running = true;
        //initializes thread and starts it
        thread = new Thread(this);
        thread.start();
    }

    public void run() {

        double drawInterval = 1000000000/FPS;//1000000000 means one second
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;


        while(thread !=null){
            currentTime = System.nanoTime();//checks current time
            delta +=(currentTime - lastTime)/drawInterval;//adds pasttime
            timer += (currentTime - lastTime);//gets fps
            lastTime = currentTime;

            if(delta >=1) {//when delta reaches paint if updates and repaint
                //UPDATE: update information such as character positions
                update();
                //DRAW:draw the screen with the updated info
                repaint();

                delta--;
                drawCount++;
            }
            //gets fps
            if(timer >=1000000000){
//                System.out.println("FPS "+drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }
    public void update(){

    	if(State.getState() !=null) 
			State.getState().update();
	
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if(State.getState() !=null) 
			State.getState().draw(g);
        
        g.dispose();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getTitle() {
        return title;
    }

    public Image getImage() {
        return image;
    }

    public void setWidth(int width) {
        this.width = width;
    }
	
	public KeyManager getKeyManager() {
		return keyManager;
	}

	public void setKeyManager(KeyManager keyManager) {
		this.keyManager = keyManager;
	}
	
	public State getGameState() {
		return gameState;
	}
	
	public void setGameState(State gameState) {
		this.gameState = gameState;
	}

	public static void main(String[]argh){
        tt p = new tt();
        p.start();

    }
}
