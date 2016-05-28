package eisenbahnstrecke;

import static org.junit.Assert.*;

import org.junit.Test;

public class BlockTest {

	@Test
	public void test() {
		Block block = new Block(0);
		System.out.print("Block: " + block.createBlock(1));
		System.out.print(block.createBlock(2));
		System.out.print(block.createBlock(3));
		System.out.print(block.createBlock(4));
	}

}
