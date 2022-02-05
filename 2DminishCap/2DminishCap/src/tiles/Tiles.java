package tiles;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import gfx.ImageLoader;
import map.Map;

public class Tiles {
		
		//STATIC VARIABLES
//		public static Tiles[] tiles = new Tiles[256];
		
		
		//CLASS
		public static final int TILESIZE = 64;
		
		public BufferedImage texture;
		public int x;

		public int y;

		public int width;

		public int height;
		
		public Tiles() {
			
		}

		public Tiles(int x,int y,int width,int height,TileType type) {
			this.texture = type.img;
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;

		}
		public void update() {
			
		}
		public void draw(Graphics g) {
			g.drawImage(texture,x,y,width,height,null);
		}
	
		public boolean isSolid() {
			return false;
		}
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		public int getWidth() {
			return width;
		}
		public void setWidth(int width) {
			this.width = width;
		}
		public int getHeight() {
			return height;
		}
		public void setHeight(int height) {
			this.height = height;
		}
		public static int getTilesize() {
			return TILESIZE;
		}
		public BufferedImage getTexture() {
			return texture;
		}
		public void setTexture(BufferedImage texture) {
			this.texture = texture;
		}
	
}
