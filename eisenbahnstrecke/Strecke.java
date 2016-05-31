package eisenbahnstrecke;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicSliderUI.TrackListener;

public class Strecke {

	/**
	 * Variablen deklaration plus zwei Listen erstellt, zu
	 * dem geh�rt eine trainlist in der werden alle z�ge 
	 * die sich auf der gesamten Strecke befinden aufgelistet 
	 * und das gleiche mit den Bl�cken, wie viele bl�cke erstellt wurden
	 */
	private int routeLength; // in km
	List<Zug> trainList = new ArrayList<>();
	List<Block> blockList = new ArrayList<>();

	/**
	 * Konstruktor mit einer BlockArray-Liste
	 * Addiert die blockl�nge zu der routeLength
	 * f�gt am Ende ein block zu der Blockliste
	 */
	public Strecke(Block[] blockList) {
		for (Block block : blockList) {
			this.routeLength += block.getLength();
			this.blockList.add(block);
		}
	}
	/**
	 * mit Hilfe der position kann der blockanfang und ende ermittelt werden
	 * @param position der Bl�cke in der Strecke
	 * @return block
	 */
	private Block findBlockByPosition(int position) {
		for (Block block : blockList) {
			if (position > block.getbegin() && position <= block.getend()) {
				return block;
			}
		}
		return null;
	}
	/**
	 * 
	 * @param train unser Zug den wir erstellen und in die 
	 * trainListe hinzuf�gen
	 * @param position
	 */
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
	/**
	 *�berpr�fe ob das n�ckste Block eine train hat
	 */
	 void hasNextBlockATrain(){
		 getBlockList().get(getRouteLength()+1).join(train);
	}
	 /*
	void lastBlockATrain(Zug train){
		getBlockList().get(getRouteLength()-1).
	}
	*/
	
	 /**
	  * @return routeLength= streckenl�nge
	  */
	public int getRouteLength() {
		return routeLength;
	}
	
	/**
	 * @return trainliste
	 */
	public List<Zug> getTrainList() {
		return trainList;
	}

	/**
	 * @return blockliste
	 */
	public List<Block> getBlockList() {
		return blockList;
	}

}
