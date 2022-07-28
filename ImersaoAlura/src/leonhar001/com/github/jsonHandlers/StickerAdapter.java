package leonhar001.com.github.jsonHandlers;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import leonhar001.com.github.models.IMDB;

public class StickerAdapter extends TypeAdapter<IMDB> {

	@Override
	public IMDB read(JsonReader reader) throws IOException {
		IMDB sticker = new IMDB();
		reader.beginObject();
		String fieldname = null;
		
		while(reader.hasNext()) {
			JsonToken token = reader.peek();
			
			if(token.equals(JsonToken.NAME)) {
				fieldname = reader.nextName(); //get token
			}
			if("id".equals(fieldname)) {
				token = reader.peek();
				sticker.setId(reader.nextString());
			}
			if("rank".equals(fieldname)) {
				token = reader.peek();
				sticker.setRank(reader.nextInt());
			}
			if("title".equals(fieldname)) {
				token = reader.peek();
				sticker.setTitle(reader.nextString());
			}
			if("fullTitle".equals(fieldname)) {
				token = reader.peek();
				sticker.setFullTitle(reader.nextString());
			}
			if("year".equals(fieldname)) {
				token = reader.peek();
				sticker.setYear(reader.nextInt());
			}
			if("image".equals(fieldname)) {
				token = reader.peek();
				sticker.setImage(reader.nextString());
			}
			if("crew".equals(fieldname)) {
				token = reader.peek();
				sticker.setCrew(reader.nextString());
			}
			if("imDbRating".equals(fieldname)) {
				token = reader.peek();
				sticker.setImDbRating(reader.nextDouble());
			}
			if("imDbRatingCount".equals(fieldname)) {
				token = reader.peek();
				sticker.setImDbRatingCount(reader.nextInt());
			}
		}
		reader.endObject();
		return sticker;
	}

	@Override
	public void write(JsonWriter writer, IMDB sticker) throws IOException {
		writer.beginObject();
		
		writer.name("id");
		writer.value(sticker.getId());
		
		writer.name("rank");
		writer.value(sticker.getRank());
		
		writer.name("title");
		writer.value(sticker.getTitle());
		
		writer.name("fullTitle");
		writer.value(sticker.getFullTitle());
		
		writer.name("year");
		writer.value(sticker.getYear());
		
		writer.name("image");
		writer.value(sticker.getImage());
		
		writer.name("crew");
		writer.value(sticker.getCrew());
		
		writer.name("imDbRating");
		writer.value(sticker.getImDbRating());
		
		writer.name("imDbRatingCount");
		writer.value(sticker.getImDbRatingCount());
		
		writer.endObject();
	}
}
