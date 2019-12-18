package com.noraokeeffe.strive.services;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
public class NewsService {
	OkHttpClient client = new OkHttpClient();

	public JsonArray getNews() throws IOException {
	  Request request = new Request.Builder()
	      .url("https://newsapi.org/v2/everything?q=bitcoin&from=2019-11-18&sortBy=publishedAt&apiKey=1179566a351a4455be87f40df6065cca")
	      .build();

	  try (Response response = client.newCall(request).execute()) {
		  JsonParser jsonParser = new JsonParser();
		  String jsonResponse = response.body().string();
		  JsonElement jsonTree = jsonParser.parse(jsonResponse);
		  return jsonTree.getAsJsonObject().get("articles").getAsJsonArray();
	  }
	}
	
	
}
