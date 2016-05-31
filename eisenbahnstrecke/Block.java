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
	 * trainlist mit Zügen die sich in dem Block befinden
	 */
	List<Zug> trainList = new ArrayList<>();
	
	/**
	 *train betritt block, signal schlägt auf "Rot", hier setUsed
	 */
	void join(Zug train){
		trainList.add(train);
		setUsed();
	}
	
	/**
	 *train verlässt block, signal schlägt auf "Grün", hier setUnused
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
	 * zug verlässt ein block, abfrage ob sich im vorletzten block sich ein Zug befindet
	 * wenn ja soll der weiterfahren, ansonsten
	 * return hat der näckste block ein zug
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
	 * @param Konstruktor für die länge
	 */
	Block(int length){
		this.length = length;
	}
	
	/**
	 * Strecke wird benutzt, Ampel ist auf "Rot", gibt true zurück
	 */
	public void setUsed(){
		isUsed = true;
	}
	
	/**
	 * Strecke wird nicht mehr benutzt, Ampel ist auf "Grün", gibt true zurück
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
	 * @return länge des Blockes
	 */
	public int getLength() {
		return length;
	}
	
	/**
	 * @param train in die trainliste hinzufügen
	 */
	public void addTrain(Zug train) {
		trainList.add(train);
	}
	
}
