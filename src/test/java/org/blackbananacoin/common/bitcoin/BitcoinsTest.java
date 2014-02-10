package org.blackbananacoin.common.bitcoin;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.google.bitcoin.core.Address;
import com.google.bitcoin.core.AddressFormatException;
import com.google.bitcoin.params.MainNetParams;

public class BitcoinsTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCreateBurnAddress() {
		try {
		String addr = Bitcoins.createMainBurnAddress("Y12TWPay123ToFooOne");
		System.out.println(addr);
		assertNotNull(addr);
		assertEquals(34, addr.length());
			Address baddr = new Address(MainNetParams.get(), addr);
			assertNotNull(baddr);
		} catch (AddressFormatException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
