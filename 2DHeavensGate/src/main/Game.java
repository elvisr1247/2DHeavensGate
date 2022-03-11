package main;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Audio.Audio;
import UI.UI;
import gfx.Assets;
import gfx.Camera;
import gfx.FontLoader;
import input.KeyManager;
import input.MouseManager;
import map.Map;
import state.GameState;
import state.State;
import state.TitleState;


public class Game extends JPanel implements Runnable {
	 //screen
    private JFrame frame;
    private String title = "Heavens's Gate";
    //screen sizes 640x480,800x600,1366x768,1600x900,1920x1080
    private int width = 800,height = 600;
    private boolean running = false;

    //game loop
    private Thread thread;
    //frames per second
    private int FPS = 60;

    //Input
    private KeyManager keyManager;
    private MouseManager mouseManager;
    
    //States
    public State gameState;  
    public State titleState;
  
    //Camera
    private Camera cam;
    
    //Audio
    private Audio audio;
    
    //World map
    private Map map;
   
    
    public Game(){
        frame = new JFrame();
        keyManager = new KeyManager(this);
        mouseManager = new MouseManager();
        audio = new Audio();
        
        
        
        frame.add(this);
        frame.addMouseListener(mouseManager);
        frame.addMouseMotionListener(mouseManager);   
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyManager);
        this.addMouseListener(mouseManager);
        this.addMouseMotionListener(mouseManager);     
        this.setFocusable(true);

        frame.setTitle(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width,height);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        Assets.init();
       
        cam = new Camera(this,0,0);
        gameState = new GameState(this);
        titleState = new TitleState(this);
        //sets the current state
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
            	UI.fps(drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }
    public void update(){
//    	keyManager.update();
    	if(State.getState() != null) 
			State.getState().update();
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(State.getState() != null) 
			State.getState().draw(g);
        g.dispose();
    }
    
    public void playMusic(String path) {
    	audio.setFile(path);
		audio.play();
    	audio.loop();
    }
 
    public void stopMusic() {
    	audio.stop();
    }
    public void playSoundEffect(String path) {
    	audio.setFile(path);
    	audio.play();
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

	public Camera getCam() {
		return cam;
	}
	
	public void setCam(Camera cam) {
		this.cam = cam;
	}

	public MouseManager getMouseManager() {
		return mouseManager;
	}

	public State getTitleState() {
		return titleState;
	}

	public void setTitleState(State titleState) {
		this.titleState = titleState;
	}
	
	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}
	
	public Audio getAudio() {
		return audio;
	}

	public void setAudio(Audio audio) {
		this.audio = audio;
	}



	public static void main(String[]argh){
        Game game = new Game();
        game.start();
	}

}
