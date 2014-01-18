package org.blackbananacoin.common.json;

public class BcApiSingleAddrTxItem {

	private double value;
	private String addr;
	private double tx_index;
	/**
	 * @return the value
	 */
	public double getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(double value) {
		this.value = value;
	}
	/**
	 * @return the addr
	 */
	public String getAddr() {
		return addr;
	}
	/**
	 * @param addr the addr to set
	 */
	public void setAddr(String addr) {
		this.addr = addr;
	}
	/**
	 * @return the tx_index
	 */
	public double getTx_index() {
		return tx_index;
	}
	/**
	 * @param tx_index the tx_index to set
	 */
	public void setTx_index(double tx_index) {
		this.tx_index = tx_index;
	}

}
