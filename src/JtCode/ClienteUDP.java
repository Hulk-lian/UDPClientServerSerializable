package JtCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClienteUDP {
	private byte[] datosEnviados= new byte[255];
	
	public ClienteUDP() {
		DatagramSocket socket=null;
		DatagramPacket datosEnvi=null;
		BufferedReader lector=null;
		try{
			lector=new BufferedReader(new InputStreamReader(System.in));
			while(true){
				System.out.println("el mensaje a enviar");
				String mensaje=lector.readLine();//leer la entrada por teclado
				
				if(mensaje.equals("Q")){
					System.out.println("has decidido salir.");
					break;//si metes solo una Q es que quieres salir
				}
				if(mensaje.trim().length()!=0){
					String envio= "El cliente dice: "+mensaje;
					datosEnviados=envio.getBytes();
					
					datosEnvi= new DatagramPacket(datosEnviados,datosEnviados.length,
													InetAddress.getByName(Constantes.HOST_SERVER),
													Constantes.PUERTO_SERVIDOR);					
					socket.send(datosEnvi);
					System.out.println("enviado el mensaje");
				}
				else{
					System.out.println("no se envian mensajes vacios");
				}
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		new ClienteUDP();
	}

}
