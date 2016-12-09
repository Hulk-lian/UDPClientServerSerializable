package JtCode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ClienteUDP {
	private byte[] datosEnviados= new byte[255];
	
	public ClienteUDP() {
		DatagramSocket socket=null;
		DatagramPacket datosEnvi=null;
		BufferedReader lector=null;
		try{
			lector=new BufferedReader(new InputStreamReader(System.in));
			
		}catch(SocketException | UnknownHostException e){
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		new ClienteUDP();
	}

}
