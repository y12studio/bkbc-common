package org.blackbananacoin.common.json;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BcWsAddrSubBuilder {

	private Gson gson = new GsonBuilder().setDateFormat(
			"yyyy-MM-dd'T'HH:mm:ssz").setPrettyPrinting().create();

	public BcWsAddrSub toModel(String json) {
		checkNotNull(json);
		BcWsAddrSub model = gson.fromJson(json, BcWsAddrSub.class);
		return model;
	}
	
	public String toJson(BcWsAddrSub model){
		return gson.toJson(model);
	}

}
