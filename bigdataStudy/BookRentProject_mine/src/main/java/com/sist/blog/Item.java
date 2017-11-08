package com.sist.blog;

import javax.xml.bind.annotation.XmlElement;

public class Item {
	private String description,link;
	

	public String getLink() {
		return link;
	}
	@XmlElement
	public void setLink(String link) {
		this.link = link;
	}

	public String getDescription() {
		return description;
	}

	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}

}
