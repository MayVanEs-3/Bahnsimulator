package eisenbahnstrecke;

import org.junit.Assert;
import org.junit.*;

public class StreckeTest extends Assert {
	Strecke strecke;

	@Before
	public void init() {
		Block[] bloecke = {
			new Block(10),
			new Block(5),
			new Block(10),
			new Block(10),
			new Block(15),
			new Block(10),
			new Block(5),
			new Block(5)	
		};
		strecke = new Strecke(bloecke);
	}
	
	@Test
	public void test() {
		for(int i = 1; i <= strecke.getLength(); i++) {
			if (strecke.getBlockFromTrainPosition(i) == null) {
				assertTrue("Eins war Null", false);
			}
			assertTrue("Alles ok", true);
		}
	}
	
	@Test (expected = NullPointerException.class)
	public void testKonstruktorWithNull() {
		new Strecke(null);
	}
	
	@Test
	public void testKonstruktorWithEmptyArray() {
		Strecke s = new Strecke();
		assertEquals(0, s.getLength());
		
	}
}
