package eisenbahnstrecke;

import java.util.Scanner;


public class Strecke {

	/**
	 * Variablen deklaration
	 */
	float streckenlaenge;
	
	/**
	 * Konstruktor
	 */
	public Strecke(float streckenlaenge) {
		this.streckenlaenge = streckenlaenge;
	}
	
	/**
	 * @return streckenlaenge 
	 */
	float getStreckenlaenge(){
		return streckenlaenge;
	}

	//bestimmte anzahl  von blöcken verlangen
	/**
	 * @return gibt die Strecke in strichen aus
	 */
	public String streckeInStrichen(float streckenlaenge){
		 String rode;
		 if(streckenlaenge >0){
			 return rode = new String(new char[(int) streckenlaenge]).replace("\0", "-");
		 }else{
			 return null;
		 }
	}
	
}
