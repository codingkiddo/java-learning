package com.codingkiddo.time;

import java.util.List;

public class WebsiteBlock {
	private String domain;
	private int count;
	private List<String> categories;

	public WebsiteBlock() {
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return "WebsiteBlock{domain='" + domain + "', count=" + count + ", categories=" + categories + "}";
	}

}
