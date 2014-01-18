package org.blackbananacoin.common.json;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkPositionIndex;

import java.util.List;
import java.util.Map;

public class BcApiSingleAddrTx {

	private long block_height;
	
	private List<Map> inputs;

	public BcApiSingleAddrTxItem getFirstTxInputItem() {
		checkNotNull(inputs);
		checkPositionIndex(0, inputs.size());
		Map input0 = (Map) inputs.get(0);
		// System.out.println(input0);
		Map prevOut = (Map) input0.get("prev_out");
		// System.out.println(prevOut);
		BcApiSingleAddrTxItem item = new BcApiSingleAddrTxItem();
		item.setValue((Double) prevOut.get("value"));
		item.setAddr((String) prevOut.get("addr"));
		item.setTx_index((Double) prevOut.get("tx_index"));
		return item;
	}

	public long getBlock_height() {
		return block_height;
	}

	public void setBlock_height(long block_height) {
		this.block_height = block_height;
	}

	/**
	 * @return the inputs
	 */
	public List<Map> getInputs() {
		return inputs;
	}

	/**
	 * @param inputs the inputs to set
	 */
	public void setInputs(List<Map> inputs) {
		this.inputs = inputs;
	}

}
