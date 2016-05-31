package jUnitTests;

import static org.junit.Assert.*;
import org.junit.Test;
import eisenbahnstrecke.Strecke;

public class StreckeTest {

	@Test
	public void parameterMatchestest() {
		Strecke eins = new Strecke(null);
		eins.addTrain(train, 5);
	
	}

}
