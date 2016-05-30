package eisenbahnstrecke;


import java.util.ArrayList;
import java.util.List;



public class Block {
	
	private boolean isUsed;
	private int begin;
	private int end;
	private int length;
	private Strecke track;
	

	/**
	 * Züge die sich auf den Block befinden
	 */
	List<Zug> trainList = new ArrayList<>();
	
	/**
	 *train enters block, the signal setUsed appears, which stands for the Redlight
	 */
	void join(Zug zug){
		trainList.add(zug);
		setUsed();
	}
	
	/**
	 *train leaves block, the signal setUnused appears, which stands for the Greenlight
	 */
	void quit(Zug zug){
		trainList.remove(zug);
		if(getTrainList().isEmpty()){
			setUnused();
		}
	}
	void hasNextBlockATrain(Zug train){
		 train.getBlock().setUnused();
	}

	void lastBlockATrain(Zug train){
		train.getBlock().setUsed();
	}
	
	 Block move(Zug train) {
		quit(train);
		notifyAll();
		hasNextBlockATrain(train);
		join(train);
		return null;
	}
	/**
	 */
	public void add(Zug train) {
		getTrainList().add(train);
		setUsed();
	}
	
	public List<Zug> getTrainList() {
		return trainList;
	}

	Block(int length){
		this.length = length;
	}
	/**
	 * Red
	 */
	public void setUsed(){
		isUsed = true;
	}
	/**
	 * Green
	 */
	public void setUnused(){
		isUsed = false;
	}
	
	public int getbegin(){
		return begin;
	}
	
	public int getend(){
		return end;
	}
	
	public int getLength() {
		return length;
	}

	public void addTrain(Zug train) {
		trainList.add(train);
	}
	
}
