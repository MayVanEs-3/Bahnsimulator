package eisenbahnstrecke;

public class Zug extends Thread {
	Block b= new Block();
	
	String name;
	int geschwindigkeit;
	
	Zug(String name,int geschwindigkeit ){
		this.name = name;
		this.geschwindigkeit = geschwindigkeit;
	}
	/*
	public String getName(){
		return name;
	}
	public void setName(String newName){
		return name = newName;
	}
	*/
	public String toString(){
		return "Der Zug" + name+ 
				"mit der Geschwindigkeit von" + geschwindigkeit+
				"km/h fährt.";
	}

	@Override
	public void run() {
		System.out.println("Starte Thread: " + name);
	}
	
	
	
	
	
		
	
	
	
	
	
	

}
