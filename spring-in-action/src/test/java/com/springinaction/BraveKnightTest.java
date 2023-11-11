package com.springinaction;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import com.springinaction.ch01.BraveKnight;
import com.springinaction.ch01.Quest;
import com.springinaction.ch01.QuestException;

public class BraveKnightTest {

	@Test
	public void knightShouldEmbarkOnQuest() throws QuestException {
		Quest mockQuest = mock(Quest.class);
		BraveKnight knight = new BraveKnight(mockQuest);
		knight.embarkOnQuest();
		verify(mockQuest, times(1)).embark();
	}
}
