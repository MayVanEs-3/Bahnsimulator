package eisenbahnstrecke;
/*
 * Als Thread wäre besser, weil wir dann die Objekte griffbereit 
 * haben zum Stoppen der Threads. 
 */
public class Zug extends Thread {
	/**
	 * Variablen deklaration
	 */
	private int position;
	private int geschwindigkeit;
	private Strecke strecke;
	private Block block;
	private boolean hasCollidated = false;

	/**
	 * Konstruktor
	 */
	public Zug(char name, int geschwindigkeit) {
		super.setName(Character.toString(name));
		this.setGeschwindigkeit(geschwindigkeit);
	}

	/**
	 * run Methode , bedingungen gestellt wie sich die Methode verhält
	 */
	@Override
	public void run() {
		try {
			while (getPosition() <= getStrecke().getLength() && !interrupted()) {
				// train is at end of block
				if (getPosition() == getBlock().getEndPos()) {
					// leave it is the last block
					if(!getBlock().hasNext()) {
						synchronized (getBlock()) {
							getBlock().leave(this);
							getBlock().notifyAll();
						}
						show();
						return;
					}
					
					// warte bis der näckste block frei ist
					while (getBlock().getNext().isBlocked()) {
						synchronized (getBlock().getNext()) {
							getBlock().getNext().wait();
						}
					}
					synchronized (getStrecke()) {
						getStrecke().moveTo(this, getBlock());
					}
				}
				position++;
				
				// überprüfe ob ein zug mit einem anderen kollidiert
				synchronized (getBlock()) {
					checkCollision();
				}
				
				show();
				Thread.sleep(getMilliseconds());
			}
		} catch (InterruptedException e) {
			// TODO: nothing....
		} catch (SimulationException e) {
			System.out.println("Kollision: " + getBlock().getTrainsAt(getPosition()));
		}
	}
	/**
	 * strecke ist synchronized weil keiner Syso noch dazu benutzen kann
	 * strecke wird (reserviert) und ausgegeben
	 */
	private void show() {
		synchronized (getStrecke()) {
			System.out.println(getStrecke());
		}
	}

	/**
	 * es wird geprüft ob eine kollision stattfindet
	 * @throws SimulationException
	 */
	void checkCollision() throws SimulationException {
		for (Zug z : getBlock().getTrains()) {
			if (this != z && getPosition() == z.getPosition()) {
				// is changeable because not all is needed
				z.interrupt();
				z.collidate();
				collidate();
				throw new SimulationException();
			}
		}
	}

	/**
	 * @return berechnung eines feldes
	 */
	private int getMilliseconds() {
		return 1000 / getGeschwindigkeit();
	}

	/**
	 * @return die geschwindigkeit
	 */
	int getGeschwindigkeit() {
		return geschwindigkeit;
	}

	void setGeschwindigkeit(int geschwindigkeit) {
		this.geschwindigkeit = geschwindigkeit;
	}
	/**
	 * Gibt die position des zuges auf der strecke.
	 * @return position des zuges 
	 */
	int getPosition() {
		return position;
	}

	/**
	 * Setzt die position des zuges.
	 * @param position des zuges
	 */
	void setPosition(int position) {
		this.position = position;
	}

	/**
	 * 
	 * @return strecke
	 */
	Strecke getStrecke() {
		return strecke;
	}

	void setStrecke(Strecke strecke) {
		this.strecke = strecke;
	}

	/**
	 * 
	 * @return block
	 */
	Block getBlock() {
		return block;
	}

	/**
	 * 
	 * @param block durch neuen block ersetzen
	 */
	void setBlock(Block block) {
		this.block = block;
	}

	/**
	 * 
	 * @return hasCollidated
	 */
	boolean hasCollidated() {
		return hasCollidated;
	}

	/**
	 * wenn es kollidiert dann gib tru zurück
	 */
	void collidate() {
		this.hasCollidated = true;
	}
}