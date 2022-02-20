package gfx;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class FontLoader {

	public static Font loadFont(String path,float size) {
	
//		try {
//			InputStream is = getClass().getResourceAsStream(path);
//			return Font.createFont(Font.TRUETYPE_FONT,is).deriveFont(Font.PLAIN,size);
//		} catch (FontFormatException | IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		try {
			return Font.createFont(Font.TRUETYPE_FONT,new File(path)).deriveFont(Font.PLAIN,size);
//			return Font.createFont(Font.TRUETYPE_FONT, FontLoader.class.getResourceAsStream(path));
			
//			return Font.createFont(Font.TRUETYPE_FONT,class.getClassLoader().getResourceAsStream("neuropol x rg.ttf"));
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			System.exit(1);
		}
		return null;
	}
	
	
}
