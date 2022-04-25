package tiles;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import gfx.ImageLoader;
import map.Map;

public class Tiles {
		
		public BufferedImage texture;
		public int x,y,width,height,tileSize = 64;
		public TileType type;
		public boolean solid = false;
		
		public Tiles(int x,int y,TileType type) {		
			this.x = x;
			this.y = y;
			this.width = tileSize;
			this.height = tileSize;
			this.type = type;
			this.texture = type.img;
			solid = type.isSolid();
	
		}
		public void update() {
			
		}
		public void draw(Graphics g) {
			g.drawImage(texture,x,y,width,height,null);
		}
		public int getXPlace() {
			return (int) x / 64;
		}
		public int getYPlace() {
			return (int) y / 64;
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
		public BufferedImage getTexture() {
			return texture;
		}
		public void setTexture(BufferedImage texture) {
			this.texture = texture;
		}

		public TileType getType() {
			return type;
		}

		public void setType(TileType type) {
			this.type = type;
		}

		public boolean isSolid() {
			return solid;
		}

		public void setSolid(boolean solid) {
			this.solid = solid;
		}
	
}