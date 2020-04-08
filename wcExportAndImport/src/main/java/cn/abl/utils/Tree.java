package cn.abl.utils;

import java.io.Serializable;
import java.util.List;

public class Tree implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String text;
	
	private List<Tree> children;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public List<Tree> getChildren() {
		return children;
	}
	public void setChildren(List<Tree> children) {
		this.children = children;
	}

	
	
}
