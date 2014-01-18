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

import java.util.List;
import java.util.Map;

/**
 * http://blockchain.info/address/$bitcoin_address?format=json
 * @author user
 *
 */
public class BcApiSingleAddress {
	
	private String address;
	private int n_tx;
	private long total_received;
	private long total_send;
	private long final_balance;
	private List<Map> txs;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the n_tx
	 */
	public int getN_tx() {
		return n_tx;
	}
	/**
	 * @param n_tx the n_tx to set
	 */
	public void setN_tx(int n_tx) {
		this.n_tx = n_tx;
	}
	/**
	 * @return the total_received
	 */
	public long getTotal_received() {
		return total_received;
	}
	/**
	 * @param total_received the total_received to set
	 */
	public void setTotal_received(long total_received) {
		this.total_received = total_received;
	}
	/**
	 * @return the total_send
	 */
	public long getTotal_send() {
		return total_send;
	}
	/**
	 * @param total_send the total_send to set
	 */
	public void setTotal_send(long total_send) {
		this.total_send = total_send;
	}
	/**
	 * @return the final_balance
	 */
	public long getFinal_balance() {
		return final_balance;
	}
	/**
	 * @param final_balance the final_balance to set
	 */
	public void setFinal_balance(long final_balance) {
		this.final_balance = final_balance;
	}
	/**
	 * @return the txs
	 */
	public List<Map> getTxs() {
		return txs;
	}
	/**
	 * @param txs the txs to set
	 */
	public void setTxs(List<Map> txs) {
		this.txs = txs;
	}
	
}
