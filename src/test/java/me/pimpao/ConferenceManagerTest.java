package me.pimpao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import me.pimpao.util.ConferenceUtil;

public class ConferenceManagerTest {

	@Test(expected = FileNotFoundException.class)
	public void testTalksFileNotFound() throws FileNotFoundException {
		ConferenceUtil.getContentFile(new File("input-test-random.txt"));		
	}

	@Test
	public void testTalksValidFile() throws FileNotFoundException {
		List<String> talks = ConferenceUtil.getContentFile(new File("input-test-two-talks.txt"));
		Assert.assertEquals(2, talks.size());
	}

	@Test
	public void testTalksEmptyFile() throws FileNotFoundException {
		List<String> talks = ConferenceUtil.getContentFile(new File("input-test-two-talks.txt"));;
		Assert.assertEquals(0, talks.size());
	}

	@Test(expected = NumberFormatException.class)
	public void testTalksInvalidFile() throws FileNotFoundException {
		List<String> talks = ConferenceUtil.getContentFile(new File("input-test-two-talks.txt"));
	}
}
