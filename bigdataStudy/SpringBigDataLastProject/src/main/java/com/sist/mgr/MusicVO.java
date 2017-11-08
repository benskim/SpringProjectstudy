package com.sist.mgr;

public class MusicVO {
	private int rank;
	private String title;
	private String singer;
	private String key;
	private String idIncrement;
	private String status;
	private String poster;

	public String getIdIncrement() {
		return idIncrement;
	}

	public void setIdIncrement(String idIncrement) {
		this.idIncrement = idIncrement;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}