package org.blackbananacoin.common.json;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkPositionIndex;

import java.util.List;
import java.util.Map;

public class BcApiSingleAddrTx {

	private long blockHeight = -1L;
	private long unixTime = -1L;
	private List<Map> inputs;
	private List<Map> out;

	public BcApiSingleAddrTxItem getFirstTxInputItem() {
		checkNotNull(inputs);
		checkPositionIndex(0, inputs.size());
		BcApiSingleAddrTxItem item = null;
		Map input0 = (Map) inputs.get(0);
		// System.out.println(input0);
		Map prevOut = (Map) input0.get("prev_out");
		checkNotNull(prevOut);
		// System.out.println(prevOut);
		item = new BcApiSingleAddrTxItem();
		item.setValue(Utils.toLong(prevOut.get("value")));
		item.setAddr((String) prevOut.get("addr"));
		item.setTxIndex(Utils.toLong(prevOut.get("tx_index")));
		return item;
	}

	public BcApiSingleAddrTxItem getTxOutputItem(String addr) {
		checkNotNull(out);
		BcApiSingleAddrTxItem item = null;
		for (Map o : out) {
			if (o.containsKey("addr")) {
				String addrInOut = (String) o.get("addr");
				if (addr.equals(addrInOut)) {
					item = new BcApiSingleAddrTxItem();
					item.setAddr(addrInOut);
					if (o.containsKey("value")) {
						item.setValue(Utils.toLong(o.get("value")));
					} else {
						item.setValue(-1L);
					}

					if (o.containsKey("tx_index")) {
						item.setTxIndex(Utils.toLong(o.get("tx_index")));
					} else {
						item.setTxIndex(-1L);
					}
				}
			}
		}
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

	public List<Map> getOut() {
		return out;
	}

	public void setOut(List<Map> out) {
		this.out = out;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BcApiSingleAddrTx [blockHeight=" + blockHeight + ", unixTime="
				+ unixTime + ", inputs=" + inputs + ", out=" + out + "]";
	}

}
