package ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Exec {

	public static void main(String[] args) {
		
		System.out.println(ejecutarComando("ls"));
		System.out.println();
		System.out.println(ejecutarComando("pwd"));
		System.out.println();
		System.out.println(ejecutarComando("lsb_release -a"));
	}
		
		
		public static String ejecutarComando(String comando){
		    String cadenaRetorno = "";
		    try {
		        Runtime tiempoEjecucion = Runtime.getRuntime();
		        Process proceso = tiempoEjecucion.exec(comando);
				
		        InputStream is = proceso.getInputStream();
		        InputStreamReader isr = new InputStreamReader(is);
		        BufferedReader br = new BufferedReader(isr);
				
		        String linea;
		        while ((linea = br.readLine()) != null) {
			    cadenaRetorno = cadenaRetorno.concat(linea) + "\n";
		        }
		        br.close();
		    } catch (IOException e) {
			e.printStackTrace();
		    }
		    return cadenaRetorno;
		}
		
	
}
