package tiles;

import java.awt.image.BufferedImage;

import gfx.Assets;

public enum TileType {
	

	Grass00(Assets.grass00,false),Grass01(Assets.grass01,false),
	Brick(Assets.brick,true),Tree(Assets.tree,true);

	public BufferedImage img;
	public boolean solid;
	
	TileType(BufferedImage img,boolean solid) {
		this.img = img;
		this.solid = solid;
	}

	public boolean isSolid() {
		return solid;
	}

	public void setSolid(boolean solid) {
		this.solid = solid;
	}

	
}
