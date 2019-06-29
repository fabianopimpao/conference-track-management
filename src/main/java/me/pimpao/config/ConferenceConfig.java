package me.pimpao.config;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import me.pimpao.util.ConferenceUtil;

public class ConferenceConfig {
		
	public static final String FILE_NAME = "input.txt";
	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("hh:mm a");
	
	public static final int MORNING_TOTAL_TIME_MINUTES = 180;	
	public static final int AFTERNOON_TOTAL_TIME_MINUTES = 240;
	public static final int TOTAL_TIME_MINUTES = 420;
	public static final String TIME_MIN_SUFIX = "min";
	
	public static final int LIGHTNING_TALK_MINUTES = 5;
	
	public static Calendar TRACK_START_TIME = ConferenceUtil.getCalendarTime(9, 0);
	public static Calendar LUNCH_START_TIME = ConferenceUtil.getCalendarTime(12, 0);
	public static Calendar POST_LUNCH_START_TIME = ConferenceUtil.getCalendarTime(13, 0);
	public static Calendar NETWORKING_START_TIME = ConferenceUtil.getCalendarTime(17, 0);
	
	public static final int LUNCH_DURATION_MINUTES = 60;
	public static final int NETWORKING_DURATION_MINUTES = 60;
	
}
