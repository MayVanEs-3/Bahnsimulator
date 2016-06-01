package eisenbahnstrecke;

public class SimulationTest {

	public SimulationTest() throws InterruptedException {
		Block[] bloecke = { new Block(10), new Block(5), new Block(10), new Block(10), new Block(15), new Block(10),
				new Block(5), new Block(5) };
		Strecke strecke = new Strecke(bloecke);
		Zug a = new Zug('A', 5);
		Zug b = new Zug('B', 15);     
		Zug c = new Zug('C', 5);
		Zug d = new Zug('D', 10);
		Zug e = new Zug('E', 6);
		strecke.addZug(a, 6);
		strecke.addZug(b, 11);
		strecke.addZug(c, 20);
		strecke.addZug(d, 30);
		strecke.addZug(e, 45);

		for (Zug t : strecke.getTrains()) {
			t.join();
		}
		System.out.println("\n\nResult:\n");
		System.out.println(strecke);
	}

	public static void main(String[] args) throws InterruptedException {
		new SimulationTest();
	}
}
//