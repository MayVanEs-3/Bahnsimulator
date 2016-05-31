package eisenbahnstrecke;


import java.util.ArrayList;
import java.util.List;

public class Block {
	
	/**
	 * Variablen deklariert
	 */
	private boolean isUsed;
	private int begin;
	private int end;
	private int length;
	private Strecke track;
	

	/**
	 * trainlist mit Z�gen die sich in dem Block befinden
	 */
	List<Zug> trainList = new ArrayList<>();
	
	/**
	 *train betritt block, signal schl�gt auf "Rot", hier setUsed
	 */
	void join(Zug train){
		trainList.add(train);
		setUsed();
	}
	
	/**
	 *train verl�sst block, signal schl�gt auf "Gr�n", hier setUnused
	 */
	void quit(Zug train){
		trainList.remove(train);
		if(getTrainList().isEmpty()){
			setUnused();
		}
	}
	/*
	void hasNextBlockATrain(Zug train){
		 train.getBlock().setUnused();
	}

	void haslastBlockATrain(Zug train){
		train.getBlock().setUsed();
	}
	*/
	/**
	 * zug verl�sst ein block, abfrage ob sich im vorletzten block sich ein Zug befindet
	 * wenn ja soll der weiterfahren, ansonsten
	 * return hat der n�ckste block ein zug
	 */
	/*
	 Block move(Zug train) {
		quit(train);
		notifyAll();
		haslastBlockATrain(train);
		join(train);
		return hasNextBlockATrain(train);
	}
	*/
	/**
	 * zug einnehmen in der liste
	 */
	public void add(Zug train) {
		getTrainList().add(train);
		setUsed();
	}
	
	public List<Zug> getTrainList() {
		return trainList;
	}
	
	/**
	 * @param Konstruktor f�r die l�nge
	 */
	Block(int length){
		this.length = length;
	}
	
	/**
	 * Strecke wird benutzt, Ampel ist auf "Rot", gibt true zur�ck
	 */
	public void setUsed(){
		isUsed = true;
	}
	
	/**
	 * Strecke wird nicht mehr benutzt, Ampel ist auf "Gr�n", gibt true zur�ck
	 */
	public void setUnused(){
		isUsed = false;
	}
	
	/**
	 * @return anfang des blockes
	 */
	public int getbegin(){
		return begin;
	}
	
	/**
	 * @return ende des blockes
	 */
	public int getend(){
		return end;
	}
	
	/**
	 * @return l�nge des Blockes
	 */
	public int getLength() {
		return length;
	}
	
	/**
	 * @param train in die trainliste hinzuf�gen
	 */
	public void addTrain(Zug train) {
		trainList.add(train);
	}
	
}
