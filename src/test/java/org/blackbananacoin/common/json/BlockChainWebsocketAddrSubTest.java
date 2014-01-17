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

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import org.junit.Test;

import com.google.common.io.Files;

public class BlockChainWebsocketAddrSubTest {

	@Test
	public void testAddrSub() throws IOException {
		BcWsAddrSubBuilder b = new BcWsAddrSubBuilder();
		String json = Files.toString(new File("testdata/bcws_addr_sub_v140117.txt"), Charset.forName("UTF-8"));
		BcWsAddrSub model = b.toModel(json);
		System.out.println(b.toJson(model));
		assertNotNull(model);
		assertEquals("utx", model.getOp());
		
		//  "value": 3330000.0 = 0.0333 BTC
		//  "value": 2.569471E7, = 0.2569471 BTC
		
		List<BcWsAddrSubTxItem> outs = model.getOutTxs();
		assertEquals(2, outs.size());
		for (BcWsAddrSubTxItem bcWsAddrSubTxItem : outs) {
			System.out.println(bcWsAddrSubTxItem);
		}
	}

}
