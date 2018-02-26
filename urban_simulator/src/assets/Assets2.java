package assets;

import java.awt.image.BufferedImage;

public class Assets2 {
	
	private static final int width = 15, height = 16;
	
	public static BufferedImage face1, face2, face3, left1, left2, left3, right1, right2, right3, down1, down2, down3;

	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/images/character2.png"));
		
		//particulars of each sprite in the spritesheet		

		face1 = sheet.crop(0, 0, width, height);
		face2 = sheet.crop(width, 0, width, height);
		face3 = sheet.crop(width * 2, 0, width, height);
		left1 = sheet.crop(0, height, width, height);
		left2 = sheet.crop(width, height, width, height);
		left3 = sheet.crop(width * 2, height, width, height);
	  right1 = sheet.crop(0, height * 2, width, height);
		right2 = sheet.crop(width, height * 2, width, height);
		right3 = sheet.crop(width * 2, height * 2, width, height);
		down1 = sheet.crop(0, height * 3, width, height);
		down2 = sheet.crop(width, height * 3, width, height);
		down3 = sheet.crop(width * 2, height * 3, width, height);

	}
	
}
