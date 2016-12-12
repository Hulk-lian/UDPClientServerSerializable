package dam.psp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class DatoUDP implements Serializable{
	
	private static final long serialVersionUID = 1L;
	public String cadenaTexto;
	public Integer cadenaNumero;
	
	public DatoUDP(String cadena,Integer numero){
		this.cadenaNumero=numero;
		this.cadenaTexto=cadena;
	}
	
	//serializador
	public byte[] toByteArray(){
		//conversion a bites mediante ByteArrayOutputStream
		// y un objeto objectOutputStream
		ByteArrayOutputStream bytes=new ByteArrayOutputStream();
		
		ObjectOutputStream os;
		try {
			os = new ObjectOutputStream(bytes);
			os.writeObject(this);
			
			//cerrar el flujo
			os.close();	//deberia de ser en el finally		
		} catch (IOException e) {
			
			return null;
		}
		
		return bytes.toByteArray();
				
	}

	//deserializador
	public static DatoUDP fromByteArray(byte[] bytes){
			
		try {
			ByteArrayInputStream byteArray= new ByteArrayInputStream(bytes);
			ObjectInputStream is= new ObjectInputStream(byteArray);
			
			DatoUDP datoAux=(DatoUDP)is.readObject();
			is.close();
			return datoAux;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

}
