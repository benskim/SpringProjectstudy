package com.sist.naver;

import javax.xml.bind.annotation.XmlElement;

public class Item {
	private String description;//댓글

	public String getDescription() {
		return description;
	}

	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}

}
