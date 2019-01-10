
import java.net.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MiCliente2 {

    public static void main(String[] args) {

        String cadI = "", cadO = "";
        InetAddress ipDestino = null;
        try {
            ipDestino = InetAddress.getByName("localhost");
        } catch (UnknownHostException ex) {
            //Logger.getLogger(MiCliente2.class.getName()).log(Level.SEVERE, null, ex);
        }
        int puerto = 15000;
        Scanner teclado = new Scanner(System.in);

        try (
                Socket concli = new Socket(ipDestino, puerto);
                PrintWriter salida = new PrintWriter(concli.getOutputStream(), true);
                BufferedReader entrada = new BufferedReader(new InputStreamReader(concli.getInputStream()));) {
            cadI = entrada.readLine();
            System.out.println(cadI);
            do {
                cadO = teclado.nextLine();
                salida.println(cadO);
            } while (!cadO.equals("EXIT") || !cadO.equals("Exit") || !cadO.equals("exit"));

        } catch (Exception ex) {
        }
    }
}
