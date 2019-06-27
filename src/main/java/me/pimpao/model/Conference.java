package me.pimpao.model;

import java.util.ArrayList;
import java.util.List;

public class Conference {
	
	List<Track> tracks = new ArrayList<Track>();
	
	public List<Track> getTracks() {
		return tracks;
	}
	
	public void addTrack(Track track) {
		tracks.add(track);
	}
}
