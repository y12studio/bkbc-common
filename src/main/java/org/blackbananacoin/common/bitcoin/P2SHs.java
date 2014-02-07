package org.blackbananacoin.common.bitcoin;

import com.google.bitcoin.core.Address;
import com.google.bitcoin.core.AddressFormatException;
import com.google.bitcoin.core.ECKey;
import com.google.bitcoin.core.Utils;
import com.google.bitcoin.params.MainNetParams;
import com.google.bitcoin.script.Script;
import com.google.common.collect.Lists;

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
		byte[] x1 = Script.createMultiSigOutputScript(threshold,
				Lists.newArrayList(karr));
		// [bitcoin-multisig/index.html at master ·
		// OutCast3k/bitcoin-multisig](https://github.com/OutCast3k/bitcoin-multisig/blob/master/index.html)
		Address addr = Address.fromP2SHHash(MainNetParams.get(),
				Utils.sha256hash160(x1));

		String redeemScript = Utils.bytesToHexString(x1);
		MultiSigResult r = new MultiSigResult();
		r.setAddress(addr);
		r.setRedeemScript(redeemScript);
		return r;
	}

}
