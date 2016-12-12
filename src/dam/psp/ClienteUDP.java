package dam.psp;

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
			socket=new DatagramSocket(Constantes.PUERTO_CLIENTE,InetAddress.getByName(Constantes.HOST_CLIENTE));
			System.out.println("conectado socket cliente: "+socket.getLocalAddress());
			
			lector=new BufferedReader(new InputStreamReader(System.in));
			while(true){
				System.out.println("el mensaje a enviar");
				String mensaje=lector.readLine();//leer la entrada por teclado
				
				if(mensaje.trim().length()!=0){
					String envio= "El cliente dice: "+mensaje;
					//datosEnviados=envio.getBytes();
					
					DatoUDP datosEnviar= new DatoUDP(envio, 1234);//creacion opbjeto
					
					datosEnviados=datosEnviar.toByteArray().clone();//serializado y agregado a la variable local de datos enviados
					
					datosEnvi= new DatagramPacket(datosEnviados,datosEnviados.length,
													InetAddress.getByName(Constantes.HOST_SERVER),
													Constantes.PUERTO_SERVIDOR);
					//datosEnvi= new DatagramPacket(datosEnviar.toByteArray(),datosEnviar.toByteArray().length,
						//					InetAddress.getByName("192.168.3.63"),
							//				5557);
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
