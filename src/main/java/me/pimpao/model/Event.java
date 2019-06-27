package me.pimpao.model;

import java.util.Calendar;

public class Event {

	private String name;
	private Calendar startTime;
	private int duration;
	
	public Event() {
		
	}
	
	public Event(Calendar startTime, String name, int duration) {
		this.startTime = startTime;
		this.name = name;
		this.duration = duration;
	}

	public String getName() {
		return name;
	}

	public Calendar getStartTime() {
		return startTime;
	}

	public int getDurationInMinutes() {
		return duration;
	}

}
