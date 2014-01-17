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
import static com.google.common.base.Preconditions.checkState;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;

/**
 * 
 *[Bitcoin Websocket API - blockchain.info](https://blockchain.info/api/api_websocket)
 */
public class BcWsAddrSub {

	private String op;
	private Map x;

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}
	
	public List<BcWsAddrSubTxItem> getOutTxs(){
		checkState(x.containsKey("out"));
		ArrayList<Map> list = (ArrayList<Map>) x.get("out");
		List<BcWsAddrSubTxItem> rlist = Lists.newArrayList();
		for (Map v : list) {
			BcWsAddrSubTxItem item = new BcWsAddrSubTxItem();
			item.setValue((Double) v.get("value"));
			item.setType((Double) v.get("type"));
			item.setAddr((String) v.get("addr"));
			rlist.add(item);
		}
		return rlist;
	}
	
}
