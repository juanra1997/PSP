package cajeras.caj1;
import static java.lang.Thread.sleep;

public class Principal{

	public static void main(String[] args){
	
	long ti=System.currentTimeMillis();
	Clientes c1, c2, c3;
	c1=new Clientes("Juan", new int[]{1,4,7,3,2});
	c2=new Clientes("Juan", new int[]{2,2,5});
	c3=new Clientes("Juan", new int[]{1,1,4,2});
	procesarCompra(c1);
	procesarCompra(c2);
	procesarCompra(c3);
	
	long tf=System.currentTimeMillis();
	System.out.println("-----> El tiempo Total ha sido de: "+(tf-ti)/1000);
	}
	
	public static void procesarCompra(Clientes cli){
		
		long ti=System.currentTimeMillis();
                cli.start();
                
	}
}