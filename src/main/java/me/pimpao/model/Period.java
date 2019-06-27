package me.pimpao.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Period {

	private int remainingDuration;
	private Calendar startTime;
	private List<Event> events = new ArrayList<Event>();

	public Period(int duration, Calendar startTime){        
        this.remainingDuration = duration;
        this.startTime = startTime;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void addEvent(Event event) {
		this.events.add(event);
		this.remainingDuration -= event.getDurationInMinutes();
	}

	public Calendar getStartTime() {
		return startTime;
	}
	
	public boolean hasRoomFor(Talk talk) {
		return remainingDuration >= talk.getDuration();
	}

}
