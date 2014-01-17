package org.blackbananacoin.common.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TwdJsonBuilder {

	private Gson gson = new GsonBuilder().setDateFormat(
			"yyyy-MM-dd'T'HH:mm:ssz").setPrettyPrinting().create();

	public TwdBit toTwdBit(String json) {
		return gson.fromJson(json, TwdBit.class);
	}
	
	public String toJson(TwdBit tb) {
		return gson.toJson(tb);
	}
	
	

}
