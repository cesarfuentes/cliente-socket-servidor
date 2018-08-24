import java.io.*;
import java.net.*;
class Cliente {
    static final String Host = "localhost";
    static final int PUERTO = 5000;
    
    public Cliente(){
        try {
            Socket skCliente = new Socket(Host,PUERTO);
            InputStream aux =skCliente.getInputStream();
            DataInputStream flujo = new DataInputStream(aux);
            System.out.println(flujo.readUTF());
            skCliente.close();
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public static void main(String[] args) {
        Cliente c = new Cliente();
    }
    
}
