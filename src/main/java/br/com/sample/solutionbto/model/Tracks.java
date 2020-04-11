package br.com.sample.solutionbto.model;

public class Tracks {

	private Integer index;
	private String title;
	private String singer;

	public Tracks(Integer index, String title, String singer) {
		this.index = index;
		this.title = title;
		this.singer = singer;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
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

	@Override
	public String toString() {
		return "Track [title=" + title + ", singer=" + singer + "]";
	}

}