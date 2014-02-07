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

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.bitcoin.core.ECKey;
import com.google.bitcoin.core.NetworkParameters;
import com.google.bitcoin.core.Utils;

public class Bitcoins {

	public static final long COIN = 100000000L;;
	public static final SimpleDateFormat FMDateKeyContent = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

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

	public static String walletPrivateKeyFormat(ECKey k,
			NetworkParameters params, int hrAgo) {
		// wallet key save to /mnt/sdcard/datelabel.key
		// private key file content
		// BitcoinxxxxxxxxxxxxxxxAddress 2014-01-28T09:13:54Z
		long time = new Date().getTime();
		long createTime = time - hrAgo * 60 * 60 * 1000;
		String timeInKey = FMDateKeyContent.format(new Date(createTime));
		String keyContent = "# KEEP YOUR PRIVATE KEYS SAFE !\n"
				+ k.getPrivateKeyEncoded(params).toString() + " " + timeInKey
				+ "\n# End of private keys";
		return keyContent;
	}
}
