package eisenbahnstrecke;


public class Block {
	Strecke rode = new Strecke(0);

	String signal;
	int strecke1;
	
	Block( int strecke1){
		//this.signal = signal;
		this.strecke1 = strecke1;
		
	}
	
	String setSignalRot(){
		return setSignalRot();
	}
	
	String setSignalGruen(){
		return setSignalGruen();
	}
	
	//Strecke streckenlaenge
	public String createBlock(int strecke1){
		String block = ("|")+rode.streckeInStrichen(strecke1) ;
		return block;
	}
	/*
	public String checkSignal( Block strecke2){
		while(signal.startsWith("|")){
			return checkFreeRunway();
		}
		return signal;
	}
	*/
	/*
	public String checkFreeRunway( ){
		String a;
		
		if(signal.startsWith("|")){
			if(){
				
			}
		}
	}
	*/
		
		
		

	
	
	/*
	public String zugEntersBlock(){

	}
	*/
	
	
	
	
	
	
	
	
	
	
	
}
