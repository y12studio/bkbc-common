/*
 * Copyright 2013 Y12STUDIO
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
