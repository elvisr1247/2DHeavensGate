package tiles;

import java.awt.image.BufferedImage;

import gfx.Assets;

public enum TileType {
	
//	Grass00("/img/tiles/grass00.png"),Grass01("/img/tiles/grass01.png"),
//	Brick("/img/tiles/brick.png"), Tree("/img/tiles/tree2.png");

	Grass00(Assets.grass00),Grass01(Assets.grass01),
	Brick(Assets.brick),Tree(Assets.tree);
//	String name;
	BufferedImage img;
	
	TileType(BufferedImage img) {
		this.img = img;
	}
	
}
