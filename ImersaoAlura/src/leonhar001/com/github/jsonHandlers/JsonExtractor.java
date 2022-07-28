package leonhar001.com.github.jsonHandlers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonExtractor<T> {
	
	private Class<T> type = null;
	private Object adapter = null;
	
	public JsonExtractor (Class<T> type, Object adapter){
		this.type = type;
		this.adapter = adapter;
	}
	
	public List<T> Parser(String json) {
		String data = json.substring(json.indexOf("[")+1, json.indexOf("]"));
		String[] items = data.split("\\},\\{");
		
		List<String> itemsList = Arrays.asList(items);
		
		List<String> jsonObjects = new ArrayList<String>();
		
		itemsList.forEach(i -> {
			if(i.contains("{") && i.contains("}"))
				jsonObjects.add(i);
			else {
				if(i.contains("}"))
					jsonObjects.add("{"+i);
				else if(i.contains("{"))
					jsonObjects.add(i+"}");
				else
					jsonObjects.add("{"+i+"}");
			}
		});
		return JsonToObjects(jsonObjects);
	}
	public List<T> JsonToObjects(List<String> jsonObjects) {
		
		GsonBuilder builder = new GsonBuilder(); 
		builder.registerTypeAdapter(type, adapter);
	    builder.setPrettyPrinting(); 
	    
	    Gson gson = builder.create();
	    List<T> objetcs = new ArrayList<>();
	    jsonObjects.forEach(s -> objetcs.add(gson.fromJson(s, type)));
	    return objetcs;
	    
	}
}
