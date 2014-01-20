package org.blackbananacoin.common.json;

public class BcApiSingleAddrTxItem {

	private long value;
	private String addr;
	private long txIndex;

	/**
	 * @return the addr
	 */
	public String getAddr() {
		return addr;
	}

	/**
	 * @param addr
	 *            the addr to set
	 */
	public void setAddr(String addr) {
		this.addr = addr;
	}

	public void setValue(long value) {
		this.value = value;
	}

	public long getTxIndex() {
		return txIndex;
	}

	public void setTxIndex(long txIndex) {
		this.txIndex = txIndex;
	}

	/**
	 * @return the value
	 */
	public long getValue() {
		return value;
	}

}
