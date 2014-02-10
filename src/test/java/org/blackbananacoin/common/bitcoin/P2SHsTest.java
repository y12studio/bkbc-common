package org.blackbananacoin.common.bitcoin;

import static org.junit.Assert.*;

import org.blackbananacoin.common.bitcoin.P2SHs.MultiSigResult;
import org.junit.Before;
import org.junit.Test;

import com.google.bitcoin.core.Address;
import com.google.bitcoin.core.AddressFormatException;
import com.google.bitcoin.core.DumpedPrivateKey;
import com.google.bitcoin.core.ECKey;
import com.google.bitcoin.core.Utils;
import com.google.bitcoin.params.MainNetParams;

public class P2SHsTest {

	// https://gist.github.com/gavinandresen/3966071

	public static String pub1 = "0491bba2510912a5bd37da1fb5b1673010e43d2c6d812c514e91bfa9f2eb129e1c183329db55bd868e209aac2fbc02cb33d98fe74bf23f0c235d6126b1d8334f86";
	public static String pri1 = "5JaTXbAUmfPYZFRwrYaALK48fN6sFJp4rHqq2QSXs8ucfpE4yQU";
	public static String pub2 = "04865c40293a680cb9c020e7b1e106d8c1916d3cef99aa431a56d253e69256dac09ef122b1a986818a7cb624532f062c1d1f8722084861c5c3291ccffef4ec6874";
	public static String pri2 = "5Jb7fCeh1Wtm4yBBg3q3XbT6B525i17kVhy3vMC9AqfR6FH2qGk";
	public static String pub3 = "048d2455d2403e08708fc1f556002f1b6cd83f992d085097f9974ab08a28838f07896fbab08f39495e15fa6fad6edbfb1e754e35fa1c7844c41f322a1863d46213";
	public static String pri3 = "5JFjmGo5Fww9p8gvx48qBYDJNAzR9pmH5S389axMtDyPT8ddqmw";

	public static String P2SH_ADDR = "3QJmV3qfvL9SuYo34YihAf3sRCW3qSinyC";

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testCreateMultiSigAddress() throws AddressFormatException {
		DumpedPrivateKey dpri1 = new DumpedPrivateKey(MainNetParams.get(), pri1);
		DumpedPrivateKey dpri2 = new DumpedPrivateKey(MainNetParams.get(), pri2);
		DumpedPrivateKey dpri3 = new DumpedPrivateKey(MainNetParams.get(), pri3);
		ECKey k1 = dpri1.getKey();
		ECKey k2 = dpri2.getKey();
		ECKey k3 = dpri3.getKey();

		Address addr1 = k1.toAddress(MainNetParams.get());
		Address addr2 = k2.toAddress(MainNetParams.get());
		Address addr3 = k3.toAddress(MainNetParams.get());

		System.out.println(Utils.bytesToHexString(k1.getPubKey()));
		System.out.println(addr1);
		System.out.println(Utils.bytesToHexString(k2.getPubKey()));
		System.out.println(addr2);
		System.out.println(Utils.bytesToHexString(k3.getPubKey()));
		System.out.println(addr3);

		MultiSigResult r = P2SHs.createMultiSigAddress(2, k1, k2, k3);
		assertNotNull(r);
		assertEquals(P2SH_ADDR, r.getAddress().toString());
	}

}
