package me.pimpao.model;

import java.util.ArrayList;
import java.util.List;

public class Track {

	private int trackId;
	private List<Period> periods = new ArrayList<Period>();

    public Track(int trackId) {
        this.trackId = trackId;        
    }

    public int getTrackId() {
    	return trackId;
    }
    
    public List<Period> getPeriods() {
        return periods;
    }

    public void addPeriod(Period period) {
        this.periods.add(period);
    }

}
