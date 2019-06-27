package me.pimpao;

import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import me.pimpao.config.ConferenceConfig;
import me.pimpao.model.Conference;
import me.pimpao.model.Event;
import me.pimpao.model.Period;
import me.pimpao.model.Talk;
import me.pimpao.model.TalksCompare;
import me.pimpao.model.Track;
import me.pimpao.util.ConferenceUtil;

public class ConferenceManager {

	public Conference processTalks(List<Talk> talks) {
		Conference conference = new Conference();

		Collections.sort(talks, new TalksCompare());
		int trackCount = 0;

		while (talks.size() != 0) {
			Period morning = new Period(ConferenceConfig.MORNING_TOTAL_TIME_MINUTES, ConferenceConfig.TRACK_START_TIME);
			fillPeriod(morning, talks);
			
			Period lunch = new Period(ConferenceConfig.LUNCH_DURATION_MINUTES, ConferenceConfig.LUNCH_START_TIME);
			lunch.addEvent(new Event(ConferenceConfig.LUNCH_START_TIME, "lunch", ConferenceConfig.LUNCH_DURATION_MINUTES));
			
			Period afternoon = new Period(ConferenceConfig.AFTERNOON_TOTAL_TIME_MINUTES, ConferenceConfig.POST_LUNCH_START_TIME);
			fillPeriod(afternoon, talks);
			
			Period networking = new Period(ConferenceConfig.NETWORKING_DURATION_MINUTES, ConferenceConfig.NETWORKING_START_TIME);
			networking.addEvent(new Event(ConferenceConfig.NETWORKING_START_TIME, "Networking Event", 0));
			
			Track track = new Track(++trackCount);
			track.addPeriod(morning);
			track.addPeriod(lunch);
			track.addPeriod(afternoon);
			track.addPeriod(networking);
			
			conference.addTrack(track);
		}		
		
		return conference;
	}

	private void fillPeriod(Period period, List<Talk> talks) {
		Calendar currentStartTime = period.getStartTime();
		for (Iterator<Talk> talksIterator = talks.iterator(); talksIterator.hasNext();) {
			Talk talk = talksIterator.next();
			if (period.hasRoomFor(talk)) {
				period.addEvent(new Event(currentStartTime, talk.getName(), talk.getDuration()));
				currentStartTime = ConferenceUtil.getNextStartTime(currentStartTime, talk);
				talksIterator.remove();
			}
		}
	}
}
