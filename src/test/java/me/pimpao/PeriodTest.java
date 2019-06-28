package me.pimpao;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import me.pimpao.model.Period;
import me.pimpao.model.Talk;
import me.pimpao.util.ConferenceUtil;

public class PeriodTest {

	@Test
	public void testHasRoomForTalk() {

		Calendar periodStartTime = ConferenceUtil.getCalendarTime(9, 00);
		Period period = new Period(50, periodStartTime);

		Talk talk1 = new Talk("Valid Talk", 45);
		Assert.assertTrue(period.hasRoomFor(talk1));

		Talk talk2 = new Talk("InValid Talk", 60);
		Assert.assertFalse(period.hasRoomFor(talk2));

	}

}
