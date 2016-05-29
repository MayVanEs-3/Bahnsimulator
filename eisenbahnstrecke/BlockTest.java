package eisenbahnstrecke;

import static org.junit.Assert.*;

import org.junit.Test;

public class BlockTest {

	@Test
	public void test() {
		Block block = new Block();
		System.out.print("Block: " + block.toString(1));
		System.out.print(block.toString(2));
		System.out.print(block.toString(3));
		System.out.print(block.toString(4));
	}

}
