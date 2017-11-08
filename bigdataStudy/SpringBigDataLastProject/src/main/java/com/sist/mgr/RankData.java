package com.sist.mgr;

import java.io.Serializable;

public class RankData implements Serializable{
    private String rank;
    private String data;
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
    
}
