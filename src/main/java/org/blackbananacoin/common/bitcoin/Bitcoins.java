package org.blackbananacoin.common.bitcoin;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

import com.google.bitcoin.core.ECKey;
import com.google.bitcoin.core.Utils;

public class Bitcoins {

	public static final long COIN = 100000000L;;

	/**
	 * @param addr
	 * @param amount
	 * @return
	 */
	public static String buildUri(String addr, double amount) {
		checkNotNull(addr);
		final StringBuilder uri = new StringBuilder("bitcoin:");
		uri.append(addr);
		uri.append("?amount=").append(String.format("%.8f", amount));
		return uri.toString();
	}

	public static ECKey createECKeyByDoubleDigestString(String seed)
			throws UnsupportedEncodingException {
		ECKey eckey = new ECKey(new BigInteger(1, Utils.doubleDigest(seed
				.getBytes("UTF-8"))));
		return eckey;
	}
}
