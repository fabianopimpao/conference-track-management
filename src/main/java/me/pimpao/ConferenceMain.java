package me.pimpao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import me.pimpao.config.ConferenceConfig;
import me.pimpao.model.Conference;
import me.pimpao.model.Talk;
import me.pimpao.util.ConferenceUtil;

public class ConferenceMain {
	
	public static void main(String[] args) {
		List<String> contentFile = ConferenceUtil.getContentFile(new File(ConferenceConfig.FILE_NAME));
		if (contentFile == null) {
			throw new RuntimeException("Arquivo inválido");
		}
		
		List<Talk> talks = new ArrayList<Talk>();
		contentFile.forEach(talkName -> {
			int min = ConferenceUtil.getTalkTime(talkName);
			Talk talk = new Talk(talkName, min);
			talks.add(talk);			
		});
		
		ConferenceUtil.printInputTalks(talks);
		
		Conference conference = new ConferenceManager().processTalks(talks);
		
		ConferenceUtil.printOutputTalks(conference);
	}
}
