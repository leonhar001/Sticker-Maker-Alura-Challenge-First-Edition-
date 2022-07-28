package leonhar001.com.github;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.imageio.ImageIO;

public class ImageHandler{

	public void loadImage(String url, String msg, String fileName, 
			Boolean hasText) throws IOException {
		
		InputStream inputStream = new URL(url).openStream();
		BufferedImage originalImage = ImageIO.read(inputStream);
		
		int customPlace = 0;
		int width = originalImage.getWidth();
		int high = originalImage.getHeight();
		
		if(hasText)
			customPlace = (int)(high*0.1);

		BufferedImage newImage = new BufferedImage(width, high+customPlace, BufferedImage.TRANSLUCENT);
		
		Graphics2D graphics = (Graphics2D) newImage.getGraphics();
		Font font = new Font(Font.SERIF, Font.BOLD, (int)(high*0.06));
		String text = msg;
		
		graphics.drawImage(originalImage, 0, 0, null);
		graphics.setFont(font);
		graphics.setColor(Color.WHITE);
		graphics.drawString(text, textPositionX(graphics, text, originalImage),
				(int) (high+(customPlace*0.7)));
		
		System.out.println("-> Writing image...");
		ImageIO.write(newImage, "png", new File("../ImersaoAlura/output/"+fileName+".png"));
		System.out.println("-> Imagem was written.");
	}
	
	private int textPositionX(Graphics2D graphics, String string,BufferedImage originalImage) {
		int stringWidthLength = (int)
				graphics.getFontMetrics().getStringBounds(string, graphics).getWidth();

		return originalImage.getWidth() / 2 - stringWidthLength / 2;
	}
}

