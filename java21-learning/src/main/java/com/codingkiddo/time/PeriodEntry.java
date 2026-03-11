package com.codingkiddo.time;

import java.util.List;

public class PeriodEntry {
	private String period; // e.g. "2026-01-23T12:00:00.000Z"
	private List<WebsiteBlock> website_blocks;

	public PeriodEntry() {
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public List<WebsiteBlock> getWebsite_blocks() {
		return website_blocks;
	}

	public void setWebsite_blocks(List<WebsiteBlock> website_blocks) {
		this.website_blocks = website_blocks;
	}

	@Override
	public String toString() {
		return "PeriodEntry{period='" + period + "', website_blocks=" + website_blocks + "}";
	}

}
