package leonhar001.com.github;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ResponseBody {
	
	public String getResponse(String url) throws IOException, InterruptedException {
		URI uri = URI.create(url);
		
		HttpClient client = HttpClient.newHttpClient();
		
		System.out.println("Requesting body from HTTP.");
		HttpRequest request = HttpRequest.newBuilder(uri).build();
		System.out.println("Request was successfully.");
		
		return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
	}
}
