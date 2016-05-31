package eisenbahnstrecke;

public class Simulation {
	
	public Simulation() throws InterruptedException {
		Block[] bloecke = {
			new Block(10),
			new Block(5),
			new Block(10),
			new Block(10),
			new Block(15),
			new Block(10),
			new Block(5),
			new Block(5)	
		};
		Strecke strecke = new Strecke(bloecke);
		Zug a = new Zug('A', 7);
		Zug b = new Zug('B', 5);
		Zug c = new Zug('C', 7);
		Zug d = new Zug('D', 3);
		Zug e = new Zug('E', 10);
		strecke.addZug(a, 1);
		strecke.addZug(b, 3);
		strecke.addZug(c, 13);
		strecke.addZug(d, 21);
		strecke.addZug(e, 24);
		
		for(Zug t : strecke.getTrains()) {
			t.join();
		}
		System.out.println("\n\nResult:\n");
		System.out.println(strecke);
	}

	public static void main(String[] args) throws InterruptedException {
		new Simulation();
	}
}
