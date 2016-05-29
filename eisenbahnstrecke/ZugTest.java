package eisenbahnstrecke;

import static org.junit.Assert.*;

import org.junit.Test;

public class ZugTest {
	

	@Test
	public void test() {
		Zug t1 = new Zug("B", 200);
		t1.start();
		t1.interrupt();
		Block temp = new Block();
		System.out.println(temp.createBlock(5));
		System.out.println();
	}

}
