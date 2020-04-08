package cn.abl.utils;

import java.io.Serializable;
import java.util.List;

public class PageBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long total;
	
	private List list;

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}
	
	
}
