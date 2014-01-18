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
import static com.google.common.base.Preconditions.checkPositionIndex;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BcApiSingleAddressBuilder {

	public static String getUrl(String addr) {
		return "http://blockchain.info/address/" + addr
				+ "?format=json&limit=5";
	}

	public BcApiSingleAddress buildDemo() throws IOException {
		URL url = Resources.getResource("bcapi_single_address_v140118.json");
		String json = Resources.toString(url, Charsets.UTF_8);
		return toModel(json);
	}

	private Gson gson = new GsonBuilder()
			.setDateFormat("yyyy-MM-dd'T'HH:mm:ssz").setPrettyPrinting()
			.create();

	public BcApiSingleAddress toModel(String json) {
		checkNotNull(json);
		return gson.fromJson(json, BcApiSingleAddress.class);
	}

	public String toJson(BcApiSingleAddress model) {
		return gson.toJson(model);
	}

	public BcApiSingleAddrTx getLastTx(BcApiSingleAddress model) {
		checkNotNull(model);
		checkNotNull(model.getTxs());
		checkPositionIndex(0, model.getTxs().size());
		Map itemMap = model.getTxs().get(0);
		BcApiSingleAddrTx tx = new BcApiSingleAddrTx();
		System.out.println(itemMap);
		tx.setBlock_height(((Double) (itemMap.get("block_height"))).longValue());
		tx.setInputs((List<Map>) itemMap.get("inputs"));
		return tx;
	}

}