package cn.abl.vo;

import java.io.Serializable;

public class OrderStatistics implements Serializable{

	private static final long serialVersionUID = 1L;

	private String evermonth;
	
	private String size;
	
	private String totalPrice;

	public String getEvermonth() {
		return evermonth;
	}

	public void setEvermonth(String evermonth) {
		this.evermonth = evermonth;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
}
