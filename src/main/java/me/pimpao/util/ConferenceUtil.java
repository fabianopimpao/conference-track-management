package me.pimpao.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import me.pimpao.config.ConferenceConfig;
import me.pimpao.model.Conference;
import me.pimpao.model.Period;
import me.pimpao.model.Talk;

public class ConferenceUtil {
	
	public static Calendar getCalendarTime(int hours, int minutes) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, hours);
		cal.set(Calendar.MINUTE, minutes);
		return cal;
	}
	
	public static List<String> getContentFile(File fileName) {
		ArrayList<String> contentFile = new ArrayList<String>();
		BufferedReader bufferedReader = null;		
		String strContent;
		try {
			bufferedReader = new BufferedReader(new FileReader(fileName));
			while ((strContent = bufferedReader.readLine()) != null) {
				if (strContent.contains("//") || strContent.isEmpty())
					continue;
				contentFile.add(strContent);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		return contentFile;		
	}
	
	public static int getTalkTime(String talkName) {
		if (talkName.endsWith(ConferenceConfig.TIME_MIN_SUFIX)) {
			String strMin = talkName.substring(talkName.lastIndexOf(" ") + 1);
			strMin = strMin.substring(0, strMin.indexOf("m"));
			return Integer.valueOf(strMin);
		} else {
			return ConferenceConfig.LIGHTNING_TALK_MINUTES;
		}
	}
	
	public static Calendar getNextStartTime(Calendar currentStartTime, Talk currentTalk) {
        Calendar newTime = Calendar.getInstance();
        newTime.set(Calendar.HOUR_OF_DAY, currentStartTime.get(Calendar.HOUR_OF_DAY));
        newTime.set(Calendar.MINUTE, currentStartTime.get(Calendar.MINUTE));
        newTime.add(Calendar.MINUTE, currentTalk.getDuration());
        return newTime;
    }
	
		
	public static void printInputTalks(List<Talk> talks) {		
		System.out.println("Test Input :- ");
		System.out.println("------------");
		System.out.println();
		talks.forEach(talk -> {
			System.out.println(talk.getName());
		});
	}
	
	public static void printOutputTalks(Conference conference) {
		SimpleDateFormat sdf = ConferenceConfig.DATE_FORMAT;
		System.out.println();
		System.out.println("Test Output :-");
        System.out.println("-------------");
        conference.getTracks().forEach(track -> {
        	System.out.println();
        	System.out.println("Track " + track.getTrackId() + ":");
            List<Period> periods = track.getPeriods();
            
            periods.forEach(period -> {
            	period.getEvents().forEach(event -> {            		
                    System.out.println(sdf.format(event.getStartTime().getTime()) + " " + event.getName());
            	});
            	
            });            
                    	
        });        
        
	}
}
