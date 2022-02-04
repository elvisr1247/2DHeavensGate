package entitys;


//import
import java.awt.Graphics;
import java.awt.Rectangle;

import main.Game;
import map.Map;
import tiles.TileType;
import tiles.Tiles;



public abstract class GameObject {
	

  public int x,y;
  protected int width,height;

  protected Game game;

  public GameObject() {}
  
  public GameObject(Game game, int x , int y,int width,int height){
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
      this.game = game;
  }

  public abstract void update();
  
  public abstract void draw(Graphics g);
  
  
}
