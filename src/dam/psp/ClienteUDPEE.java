package dam.psp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClienteUDPEE {
	
	public ClienteUDPEE() {
		//abre socket udp y envia por el 3 mensajes que encapsulan 10 clases serializadas
		DatagramSocket socket=null;
		
		try {
			socket= new DatagramSocket(Constantes.PUERTO_CLIENTE,InetAddress.getByName(Constantes.HOST_CLIENTE));
			
			DatoUDP eldato= new DatoUDP("HandsOutOfRange",5689);
			
			byte[] elDatosEnBites=eldato.toByteArray();
			
			DatagramPacket dato= new DatagramPacket(elDatosEnBites, elDatosEnBites.length,
													InetAddress.getByName(Constantes.HOST_SERVER),
													Constantes.PUERTO_SERVIDOR);
			
			//enviamos el datagrama 3 veces esperado 1 s entre cada envio
			for(int i=0;i<3;i++){
				System.out.println("Envio dato "+ i);
			socket.send(dato);
			Thread.sleep(1000);
			}
			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			socket.close();
			System.out.println("Transmision finalizada");
		}
		
	}
	public static void main(String[] args) {
		new ClienteUDPEE();
	}

}
