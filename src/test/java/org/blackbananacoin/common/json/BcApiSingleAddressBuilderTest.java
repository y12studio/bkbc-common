package org.blackbananacoin.common.json;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.google.common.io.Files;

public class BcApiSingleAddressBuilderTest {

	private BcApiSingleAddressBuilder b;

	@Before
	public void setUp() throws Exception {
		b = new BcApiSingleAddressBuilder();
	}

	@Test
	public void testToModel() throws IOException {
		String json = Files.toString(new File(
				"testdata/bcapi_single_address_v140118.txt"), Charset
				.forName("UTF-8"));
		assertNotNull(json);
		BcApiSingleAddress model = b.toModel(json);
		System.out.println(b.toJson(model));
		assertNotNull(model);
		assertEquals(4, model.getN_tx());
		BcApiSingleAddrTx lastTx = b.getLastTx(model);
		assertNotNull(lastTx);
		assertEquals(1389425700L,lastTx.getUnixTime());
		BcApiSingleAddrTxItem item = lastTx.getFirstTxInputItem();
		assertNotNull(item);
		assertEquals("19yMoeDW4KRZ1651rs1tFe86YKi3vSuAVj", item.getAddr());
		assertEquals(868130, (int)item.getValue());
		
		
		assertNotNull(b.buildDemo());
		
	}

}
