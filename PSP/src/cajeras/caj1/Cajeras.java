package caj1;

public class Cajeras extends Thread {

	private cli;
	public Cajeras (String s) {
	
	super(s);
	}
	
	@Override
	public void run(){
		
		System.out.println("<<<<<<<<<<<<<<<<< Iniciando Hilo "+getName());
		/*int cont=0;
		while(cont<20){
			
			dormir(1000);
			System.out.println(
		}*/
	}
	
	public void dormir(long t){
		try{
			sleep(t);
		}catch(InterruptedException e){
			System.err.println("Error: "+e.getMessage);
		}
	}

}