package leonhar001.com.github.consumers;

import java.io.IOException;
import java.util.List;

import leonhar001.com.github.ResponseBody;
import leonhar001.com.github.jsonHandlers.JsonExtractor;
import leonhar001.com.github.jsonHandlers.StickerAdapter;
import leonhar001.com.github.models.IMDB;
import leonhar001.com.github.properties.APIProperties;
import leonhar001.com.github.properties.Url;

public class IMDBConsumer implements Consumer{

	@Override
	public List<IMDB> consumeAPI() throws IOException, InterruptedException {
		APIProperties api = new APIProperties();
		String url = api.getProperties(Url.imdb);
		
		ResponseBody responseBody = new ResponseBody();
		String response = responseBody.getResponse(url);
		
		JsonExtractor<IMDB> jsonHandlerIMDB = 
				new JsonExtractor<>(IMDB.class, new StickerAdapter());
		
		List<IMDB> stickers = jsonHandlerIMDB.Parser(response);
		return stickers;			
	}
	
}
