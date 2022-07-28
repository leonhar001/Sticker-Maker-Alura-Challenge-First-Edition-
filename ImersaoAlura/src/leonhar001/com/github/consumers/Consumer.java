package leonhar001.com.github.consumers;

import java.io.IOException;
import java.util.List;

import leonhar001.com.github.models.IMDB;

public interface Consumer{
	List<IMDB> consumeAPI() throws IOException, InterruptedException;
}
