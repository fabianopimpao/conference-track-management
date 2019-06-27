package me.pimpao.model;

import java.util.Comparator;

public class TalksCompare implements Comparator<Talk> {

	@Override
	public int compare(Talk talk1, Talk talk2) {
		if (talk1.getDuration() < talk2.getDuration()) {
			return 1;
		}
		
		return -1;
	}	
	
}
