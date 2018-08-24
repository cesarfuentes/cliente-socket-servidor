import java.io.*;
import java.net.*;
class Servidor{
    static final int PUERTO = 5000;
    public Servidor() {
        try {
            ServerSocket skServidor = new ServerSocket (PUERTO);
            System.out.println("escucho el puerto" + PUERTO);
            for (int numCli = 0; numCli < 3; numCli++) {
                Socket skCliente = skServidor.accept(); // crea el objeto
                System.out.println("sirvo al cliente nro: " + numCli);
                OutputStream aux = skCliente.getOutputStream();
                DataOutputStream flujo = new DataOutputStream(aux);
                flujo.writeUTF("hola cliente:_" + numCli);
                skCliente.close();
            }
            System.out.println("demasiados clientes por hoy");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Servidor s = new Servidor();
    }

}
