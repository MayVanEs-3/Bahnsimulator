package eisenbahnstrecke;

import java.util.ArrayList;
import java.util.List;

public class Block {
	/**
	 * Liste erstellen um die züge einzunehmen
	 */
	List<String> list = new ArrayList<>();

	/**
	 * Klasse Strecke in Block initialisiert
	 */
	Strecke rode = new Strecke(0);

	/**
	 * Variablen signal, die strecke deklariert
	 */
	String signal;
	int strecke;

	/**
	 * @return strecke
	 */
	public int getStrecke() {
		return strecke;
	}

	/**
	 * @param newStrecke
	 *            die zweite Strecke die neben der ersten eingegeben wird
	 * @return die zweite soeben eingegebene Strecke
	 */
	public int setStrecke(int newStrecke) {
		return strecke = newStrecke;
	}

	/**
	 * @return signal Rot
	 */
	String setSignalRot() {
		return setSignalRot();
	}

	/**
	 * @return signal Gruen
	 */
	String setSignalGruen() {
		return setSignalGruen();
	}

	/**
	 * Die Strecke in Strichen ausgeben
	 */
	public String toString(int strecke) {
		String block = ("|") + rode.streckeInStrichen(strecke);
		return block;
	}
	
	public int checkPosition(){
		int position = 0;
		for(int i = 0; i <= strecke; i++){
			return position++;
		}
	}

	/**
	 * Signale überprüfen
	 * @return
	 */
	public String checkSignal() {
		if (signal.startsWith("_")) {
			return setSignalGruen();
		} else {
			return setSignalRot();
		}
	}

}
