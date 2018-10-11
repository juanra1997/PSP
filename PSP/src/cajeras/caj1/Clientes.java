package cajeras.caj1;

public class Clientes/* extends Thread*/{
	
		private String nombreCli;
		private int[] carritoCli;
		
		//--------------------------------------------------------------------------------------------------
		
		public Clientes(String n, int[] c){
			
			nombreCli=n;
			carritoCli=c;
		}
		
		public Clientes(){
			
		}
		
		//--------------------------------------------------------------------------------------------------
		
		public void setNombreCli(String n){
			
			nombreCli=n;
		}
		
		public String getNombreCli(){
			
			return nombreCli;
		}
		
		public void setCarritoCli(int[] c){
			
			carritoCli=c;
		}
		
		public int[] getCarritoCli(){
			
			return carritoCli;
		}
}