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


/**
 * 
 * [Bitcoin Websocket API -
 * blockchain.info](https://blockchain.info/api/api_websocket)
 */
public class BcWsAddrSubTxItem {

	private double value;

	private String addr;

	private double type;

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public double getType() {
		return type;
	}

	public void setType(double type) {
		this.type = type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BcWsAddrSubTxItem [value=" + value  + ", addr="
				+ addr + ", type=" + type + "]";
	}


}
