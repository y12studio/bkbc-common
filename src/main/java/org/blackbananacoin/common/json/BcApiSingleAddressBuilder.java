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
		URL url = Resources.getResource("bcapi_v140118.txt");
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

	public BcApiSingleAddrTx parseLastTx(BcApiSingleAddress model) {
		return parseTx(model, 0);
	}

	public BcApiSingleAddrTx parseTx(BcApiSingleAddress model, int index) {
		checkNotNull(model);
		checkNotNull(model.getTxs());
		checkPositionIndex(index, model.getTxs().size());
		Map itemMap = model.getTxs().get(index);
		BcApiSingleAddrTx tx = new BcApiSingleAddrTx();
		// System.out.println(itemMap);
		if (itemMap.containsKey("block_height")) {
			// NOTE :
			// new tx block_height is NULL
			tx.setBlockHeight(Utils.toLong(itemMap.get("block_height")));
		} else {
			tx.setBlockHeight(-1);
		}
		if (itemMap.containsKey("time")) {
			tx.setUnixTime(Utils.toLong(itemMap.get("time")));
		}
		if (itemMap.containsKey("inputs")) {
			tx.setInputs((List<Map>) itemMap.get("inputs"));
		}
		if (itemMap.containsKey("out")) {
			tx.setOut((List<Map>) itemMap.get("out"));
		}
		return tx;
	}

}
