package eisenbahnstrecke;

public class SimulationException extends Exception {
	/**
	 * Konstruktor der Exception
	 */
	public SimulationException() {
		super();
	}
	/**
	 * Konstruktor der die nachricht übergibt
	 */
	public SimulationException(String message) {
		super(message);
	}
}
