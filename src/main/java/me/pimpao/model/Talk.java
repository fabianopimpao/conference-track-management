package me.pimpao.model;

public class Talk {
	
	private String name;
	private int duration;
	
	public Talk(String name, int duration) {
		this.name = name;
		this.duration = duration;
	}

	public String getName() {
		return name;
	}
	
	public int getDuration() {
		return duration;
	}	
	
}
