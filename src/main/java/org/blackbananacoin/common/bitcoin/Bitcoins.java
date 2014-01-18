package org.blackbananacoin.common.bitcoin;

import static com.google.common.base.Preconditions.checkNotNull;

public class Bitcoins {

	public static final long COIN = 100000000L;;

	public static String buildUri(String addr, double amount) {
		checkNotNull(addr);
		final StringBuilder uri = new StringBuilder("bitcoin:");
		uri.append(addr);
		uri.append("?amount=").append(String.format("%.8f", amount));
		return uri.toString();
	}
}
