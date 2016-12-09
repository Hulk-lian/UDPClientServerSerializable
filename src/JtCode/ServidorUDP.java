package JtCode;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ServidorUDP {
	
	public ServidorUDP() {
		DatagramSocket socket=null;
		try {
			socket= new DatagramSocket(Constantes.PUERTO_SERVIDOR,InetAddress.getByName(Constantes.HOST_SERVER));
			
			DatagramPacket dato= new DatagramPacket(new byte[255],255);
			//servicio en bucle infinito	
			while(true){
				System.out.println("Escuchando en el puerto: "+ socket.getLocalPort());
				
				//bloqueo a la espera de recibir conexion...
				socket.receive(dato);
				System.out.println("Recibido el dato de:\" "+dato.getAddress().getHostName()+" \" : ");
				
				//Deserializamos 
				
				DatoUDP datoRecib= DatoUDP.fromByteArray(dato.getData());

				//mostrar
				System.out.println(datoRecib.cadenaTexto+System.lineSeparator()+datoRecib.cadenaNumero);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new ServidorUDP();
	}

}
