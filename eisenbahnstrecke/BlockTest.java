package eisenbahnstrecke;

import static org.junit.Assert.*;

import org.junit.Test;

public class BlockTest {

	@Test
	public void test() {
<<<<<<< HEAD
		Block block = new Block();
		System.out.print("Block: " + block.toString(1));
		System.out.print(block.toString(2));
		System.out.print(block.toString(3));
		System.out.print(block.toString(4));
=======
		Block block = new Block(0);
		System.out.print("Block: " + block.createBlock(1));
		System.out.print(block.createBlock(2));
		System.out.print(block.createBlock(3));
		System.out.print(block.createBlock(4));
>>>>>>> e2bb8365ff28b70b262baca064c409f2a5845e57
	}

}
