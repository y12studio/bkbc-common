package org.blackbananacoin.common.json;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkPositionIndex;

import java.util.List;
import java.util.Map;

public class BcApiSingleAddrTx {

	private long blockHeight;
	private long unixTime;

	private List<Map> inputs;

	public BcApiSingleAddrTxItem getFirstTxInputItem() {
		checkNotNull(inputs);
		checkPositionIndex(0, inputs.size());
		Map input0 = (Map) inputs.get(0);
		// System.out.println(input0);
		Map prevOut = (Map) input0.get("prev_out");
		// System.out.println(prevOut);
		BcApiSingleAddrTxItem item = new BcApiSingleAddrTxItem();
		item.setValue(Utils.toLong(prevOut.get("value")));
		item.setAddr((String) prevOut.get("addr"));
		item.setTxIndex(Utils.toLong(prevOut.get("tx_index")));
		return item;
	}

	/**
	 * @return the inputs
	 */
	public List<Map> getInputs() {
		return inputs;
	}

	/**
	 * @param inputs
	 *            the inputs to set
	 */
	public void setInputs(List<Map> inputs) {
		this.inputs = inputs;
	}

	public long getUnixTime() {
		return unixTime;
	}

	public void setUnixTime(long unixTime) {
		this.unixTime = unixTime;
	}

	public long getBlockHeight() {
		return blockHeight;
	}

	public void setBlockHeight(long blockHeight) {
		this.blockHeight = blockHeight;
	}

}
