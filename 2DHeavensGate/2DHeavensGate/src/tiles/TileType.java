package tiles;

import java.awt.image.BufferedImage;

import gfx.Assets;

public enum TileType {
	

	Grass00(Assets.grass00,false),Grass01(Assets.grass01,false),
	Water00(Assets.water00,true),Water01(Assets.water01,true),
	Water02(Assets.water02,true),Water03(Assets.water03,true),
	Water04(Assets.water04,true),Water05(Assets.water05,true),
	Water06(Assets.water06,true),Water07(Assets.water07,true),
	Water08(Assets.water08,true),Water09(Assets.water09,true),
	Water10(Assets.water10,true),Water11(Assets.water11,true),
	Water12(Assets.water12,true),Water13(Assets.water13,true),
	Brick(Assets.brick,true),Tree(Assets.treeTile,true);
	

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
