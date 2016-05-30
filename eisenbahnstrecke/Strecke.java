package eisenbahnstrecke;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicSliderUI.TrackListener;

public class Strecke {

	/**
	 * Variablen deklaration
	 */
	private int routeLength; // in km
	List<Zug> trainList = new ArrayList<>();
	List<Block> blockList = new ArrayList<>();

	/**
	 * Konstruktor
	 */
	public Strecke(Block[] blockList) {
		for (Block block : blockList) {
			this.routeLength += block.getLength();
			this.blockList.add(block);
		}
	}

	private Block findBlockByPosition(int position) {
		for (Block block : blockList) {
			if (position > block.getbegin() && position <= block.getend()) {
				return block;
			}
		}
		return null;
	}

	public void addTrain(Zug train, int position) {
		if (train != null && position >= 0) {
			Block block = findBlockByPosition(position);

			train.setPosition(position);
			train.setroute(this);
			train.setBlock(block);

			block.addTrain(train);
			trainList.add(train);

			train.start();
		}
	}
	
	void hasNextBlockATrain(Zug train){
		 train.getBlock().setUnused();
	}

	

	public int getRouteLength() {
		return routeLength;
	}

	public List<Zug> getTrainList() {
		return trainList;
	}

	public List<Block> getBlockList() {
		return blockList;
	}

}
