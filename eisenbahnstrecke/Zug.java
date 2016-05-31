package eisenbahnstrecke;

public class Zug extends Thread {

	/**
	 * Variablen deklaration
	 */
	String name;
	int speed; // km pro sekunde
	int timeProKm;
	int position;
	Strecke route;
	Block block;

	/**
	 * Konstruktor
	 */
	Zug(String name, int speed) {
		this.name = name;
		this.speed = speed;
		this.timeProKm = 1000 / speed;
	}

	public Strecke getroute() {
		return route;
	}

	void setroute(Strecke s) {
		route = s;
	}

	public Block getBlock() {
		return block;
	}

	public void setBlock(Block block) {
		this.block = block;
	}

	public String toString() {
		return name;
	}

	public int getspeed() {
		return speed;
	}

	public void setspeed(int speed) {
		this.speed = speed;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	/*
	public void run() {
		while (route.getRouteLength() > position) {
			position = position + speed;
		}
		if (getPosition() == getBlock().getend()) {
			while (getBlock().hasNextBlockATrain().isUsed()) {
				 getBlock().hasNextBlockATrain().sleep(timeProKm);
				}
			}
		//setBlock(getBlock().move(this));
	
		System.out.println(getroute());
		position++;
		Thread.sleep(timeProKm);
	
		synchronized (getBlock()) {
			getBlock().quit(this);
			getBlock().notifyAll();
		
		}

	}
	*/
}