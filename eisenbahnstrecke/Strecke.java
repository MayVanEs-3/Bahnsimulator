package eisenbahnstrecke;
import java.util.ArrayList;

public class Strecke {
	/**
	 * Variablen deklaration
	 */
	private int length = 0;
	private ArrayList<Zug> trains = new ArrayList<>();
	private ArrayList<Block> blocks = new ArrayList<>();

	/**
	 * (Block...blocks)- notwendig um beliebig viele elemente auszugeben
	 */
	public Strecke(Block... blocks) {
		if(blocks == null) {
			throw new NullPointerException();
		}
		recursiveAddingBlocks(0, blocks);
	}
	/**
	 * Rekursiver durchlauf, da auch gleich ein neuer Block gesetzt wird
	 * rekursives hinzufügen der blöcke
	 * ..geht in den if blcok und verzeichnet die verlinkungen
	 * @param index position der Blöcke, der strecke
	 * @param blocks
	 */
	private void recursiveAddingBlocks(int index, Block...blocks) {
		if(index < blocks.length) {
			Block newOne = new Block(this, blocks[index].getLength(), index);
			addLength(newOne.getLength());
			getBlocks().add(newOne);
			recursiveAddingBlocks((index + 1), blocks);
			if(index < (blocks.length - 1)) {
				newOne.setNext(getBlocks().get(index + 1));
			}
		}
	}

	/**
	 * anhand der position wird der block ausgegeben, welcher sich dann
	 * an dieser stelle befindet
	 */
	Block getBlockFromTrainPosition(int position) {
		for(Block b : getBlocks()) {
			if(position >= b.getStartPos()&& position <= b.getEndPos()) {
				return b;
			}
		}
		return null;
	}

	/**
	 * Zug hinzufügen zu der Zugliste
	 */
	void addZug(Zug zug, int position) {
		Block b = getBlockFromTrainPosition(position); 
		if (b != null) {
			zug.setPosition(position);
			zug.setStrecke(this);
			b.enter(zug);
			zug.setBlock(b);
			getTrains().add(zug);
			zug.start();
		}
	}

	/**
	 * berechnet anfangspunkt eines blockes.
	 * Beispiel: 1 - 10  11 - 20
	 * @return anfang des Blocks
	 */
	int getFirstPositionOf(Block b) {
		return sumPosition(1, b);
	}

	/**
	 * berechnet endpunkt eines blockes.
	 * @return ende des Blocks plus die länge der strecke die sich zwichen den anfang
	 * und ende des Blockes sich befindet
	 */
	int getLastPosition(Block b) {
		return sumPosition(0, b) + b.getLength();
	}
	/**
	 * methode das sich der zug bewegt 
	 */
	void moveTo(Zug train, Block block) {
		synchronized (train.getBlock()) {
			train.getBlock().leave(train);
			train.getBlock().notifyAll();
			train.setBlock(train.getBlock().getNext());
			train.getBlock().enter(train);
		}
		notifyAll();
	}
	
	/**
	 * summiert die längen bis zu einem gegebenen block.
	 * @return
	 */
	private int sumPosition(int start, Block b) {
		int sum = start;
		for (Block block : getBlocks()) {
			if (block == b) {
				return sum;
			}
			sum += block.getLength();
		}
		return sum;
	}

	@Override
	public synchronized String toString() {
		String result = "";
		for (Block block : getBlocks()) {
			synchronized (block) {
				result += block;
			}
		}
		return result;
	}
	/**
	 * @param länge wird auf dem gegebenen length dazu addieren
	 */
	private void addLength(int length) {
		this.length += length;
	}

	int getLength() {
		return length;
	}
	/**
	 * @return Blockliste 
	 */
	ArrayList<Block> getBlocks() {
		return blocks;
	}
	/**
	 * @return Zugliste
	 */
	ArrayList<Zug> getTrains() {
		return trains;
	}
}