package eisenbahnstrecke;
import java.util.ArrayList;


public class Block {
	/**
	 * Variablen deklaration
	 */
	private int length;
	private Signal signal = Signal.GREEN;
	private int positionOfSection;
	
	/**
	 * Verweise
	 */
	private Strecke section;
	private Block next;
	private ArrayList<Zug> trains = new ArrayList<>();
	
	/**
	 * Anfang und ende des blockes auf der strecke
	 */
	private int start;
	private int end;
 
	/**
	 * Konstruktor1
	 */
	public Block(int laenge) {
		this.length = laenge;
	}
	
	/**
	 * Konstruktor2
	 * @param section- Strecke
	 * @param length- länge
	 * @param position- position
	 */
	public Block(Strecke section, int length, int position) {
		this.length = length;
		this.positionOfSection = position;
		this.section = section;
		this.start = getSection().getFirstPositionOf(this);
		this.end = getSection().getLastPosition(this);
	}

	/**
	 * Train in die getTrainsliste aufnehmen
	 * und signal auf rot schalten
	 */
	void enter(Zug train) {
		getTrains().add(train);
		signal = Signal.RED;
	}
	
	/**
	 * Aus der liste train entfernen und im näcksten schritt bedingung stellen 
	 * wenn die liste leer ist dann signal auf grün schalten
	 */
	void leave(Zug train) {
		synchronized (this) {
			getTrains().remove(train);
			if(getTrains().isEmpty()) {
				signal = Signal.GREEN;
			}
		}
	}
	
	/**
	 * Wenn signal grün ist dann _ ausgeben ansonsten |
	 */
	private String getSign() {
		if(getSignal() == Signal.GREEN) {
			return "_";
		} else {
			return "|";
		}
	}
	
	/**
	 *  /
	  * @return stellt Kollision dar zwichen zwei züge
	  * wenn mehr als ein zug an der gleichen position ist dann 
	  * zeige, dass sie Kollidieren
	  * mit posInsect wird nachgeschaut wie viele züge sich an
	  * dieser postion sich befinden
	  * 
	  */
	String getTrainsAt(int posInSect) {
		String result = "";
		int counter = 0;
		for(Zug train : getTrains()) {
			if(train.getPosition() == posInSect) {
				result += train.getName();
				counter++;
			}
		}
		if(counter > 1) {
			result = "(" + result + ")";
		}
		if(counter == 0) {
			return "-";
		}
		return result;
	}
	
	/**
	 * ToStrinng methode
	 */
	@Override
	public String toString() {
		String result = getSign();
		for(int pos = getStartPos(); pos <= getEndPos(); pos++) {
			result += getTrainsAt(pos);
		}
		return result;
	}
	
	/**
	 * wenn signal gleich rot ist dann gebe true aus ansonsten
	 * false
	 */
	boolean isBlocked() {
		if(getSignal() == Signal.RED) {
			return true;
		}
		return false;
	}
	
	/**
	 * @return the length
	 */
	int getLength() {
		return length;
	}

	/**
	 * Signal
	 */
	Signal getSignal() {
		return signal;
	}

	/**
	 * @return die position
	 */
	int getPositionOfSection() {
		return positionOfSection;
	}
	
	/**
	 * @return die züge
	 */
	ArrayList<Zug> getTrains() {
		return trains;
	}
	
	/**
	 * @return die Strecke strecke
	 */
	Strecke getSection() {
		return section;
	}
	
	/**
	 * Ankunftsposition von Block
	 */
	int getStartPos() {
		return this.start;
	}
	
	/**
	 * Endposition von Block
	 */
	int getEndPos() {
		return this.end;
	}

	/**
	 * @return next Block
	 */
	Block getNext() {
		return next;
	}

	/**
	 * zeiger auf den nächsten Block
	 */
	void setNext(Block next) {
		this.next = next;
	}
	
	/**
	 * wenn der nextBlock vorhanden ist gebe true zurück ansonsten false
	 * @return
	 */
	boolean hasNext() {
		if(getNext() != null) {
			return true;
		}
		return false;
	}
}