package assets;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 15, height = 16;
	private static String path; //"/images/character1.png"
	
	public static BufferedImage [] player_down, player_up, player_left, player_right;
	
	public Assets(String path){
		
		Assets.path = path;
		
	}
	
	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage(path));
		
		//particulars of each sprite in the spritesheet		

		player_down = new BufferedImage[2];
		player_up = new BufferedImage[2];
		player_left = new BufferedImage[2];
		player_right = new BufferedImage[2];
		
		player_down [0] = sheet.crop(0, 0, width, height);
		player_down [1] = sheet.crop(width, 0, width, height);
		player_down [2] = sheet.crop(width * 2, 0, width, height);
		player_left [0] = sheet.crop(0, height, width, height);
		player_left [1] = sheet.crop(width, height, width, height);
		player_left [2] = sheet.crop(width * 2, height, width, height);
		player_right [0] = sheet.crop(0, height * 2, width, height);
		player_right [1] = sheet.crop(width, height * 2, width, height);
		player_right [2] = sheet.crop(width * 2, height * 2, width, height);
		player_up [0] = sheet.crop(0, height * 3, width, height);
		player_up [1] = sheet.crop(width, height * 3, width, height);
		player_up [2] = sheet.crop(width * 2, height * 3, width, height);

	}
	
}

