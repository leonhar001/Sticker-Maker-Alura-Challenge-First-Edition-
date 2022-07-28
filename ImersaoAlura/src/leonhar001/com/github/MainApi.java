package leonhar001.com.github;

import java.io.IOException;
import java.util.List;

import leonhar001.com.github.consumers.Consumer;
import leonhar001.com.github.consumers.IMDBConsumer;
import leonhar001.com.github.models.IMDB;

public class MainApi {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.out.println("IMDB API: consuming...");
		Consumer imdb = new IMDBConsumer();
		List<IMDB> stickers = imdb.consumeAPI();
		System.out.println("IMDB API: Finished.\n");
		
		System.out.println("Getting first image for testing pourpose...");
		ImageHandler imgHandler = new ImageHandler();
		imgHandler.loadImage(stickers.get(0).getImage(), 
				"API Testing...",
				stickers.get(0).getTitle(), 
				true);
		System.out.println("Image generated.");
	}
}
