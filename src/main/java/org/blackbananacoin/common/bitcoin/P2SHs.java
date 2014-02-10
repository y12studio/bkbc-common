/*
 * Copyright 2014 Y12STUDIO
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
package org.blackbananacoin.common.bitcoin;

import com.google.bitcoin.core.Address;
import com.google.bitcoin.core.AddressFormatException;
import com.google.bitcoin.core.ECKey;
import com.google.bitcoin.core.Utils;
import com.google.bitcoin.params.MainNetParams;
import com.google.bitcoin.script.Script;
import com.google.bitcoin.script.ScriptBuilder;
import com.google.common.collect.ImmutableList;

public class P2SHs {

	public static class MultiSigResult {
		private Address address;
		private String redeemScript;

		public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}

		public String getRedeemScript() {
			return redeemScript;
		}

		public void setRedeemScript(String redeemScript) {
			this.redeemScript = redeemScript;
		}
	}

	public static void main(String[] args) throws AddressFormatException {

	}

	public static MultiSigResult createMultiSigAddress(int threshold,
			ECKey... karr) {
		// 2-3
		Script script = ScriptBuilder.createMultiSigOutputScript(threshold,
				ImmutableList.copyOf(karr));
		// [bitcoin-multisig/index.html at master ·
		// OutCast3k/bitcoin-multisig](https://github.com/OutCast3k/bitcoin-multisig/blob/master/index.html)
		Address addr = Address.fromP2SHHash(MainNetParams.get(),
				Utils.sha256hash160(script.getProgram()));

		String redeemScript = Utils.bytesToHexString(script.getProgram());
		MultiSigResult r = new MultiSigResult();
		r.setAddress(addr);
		r.setRedeemScript(redeemScript);
		return r;
	}

}
