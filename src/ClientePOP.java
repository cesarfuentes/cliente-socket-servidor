import java.io.*;
import java.net.*;
public class ClientePOP {
    //todo auto generated method stub
    String Servidor = "mail.ficct.uagrm.edu.bo";
    //String servidor ="172.20.172.254"
    String user="grupo06sa";
    String pass="grupo06grupo06";
    String line;
    String comando="";
    String demoCorreo="demo Correo";
    int puerto=110;
    
    public ClientePOP(){
        try {
            //se establece conexion abriendo un socket especificando el servidor 
            //y el puerto SMTP
            Socket socket=new Socket(Servidor, puerto);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
            //escribimos datos en el canal de salida establecido con el puerto del protocolo SMTP del servidor
            if (socket!=null && entrada!=null && salida!=null ) {
                System.out.println("S: "+entrada.readLine());
                
                comando="USER "+ user+ "\r\n";   //escribi comando
                System.out.println("C: "+comando);    //mostre al usuario
                salida.writeBytes(comando);    //    lo que devuelve el servidor
                System.out.println("S: "+entrada.readLine());    //mostramos al usuario
                
                comando="PASS "+ pass + "\r\n";   //escribi comando
                System.out.println("C: "+comando);    //mostre al usuario
                salida.writeBytes(comando);    //    lo que devuelve el servidor
                System.out.println("S: "+entrada.readLine());    //mostramos al usuario
                
                comando="STAT \r\n";   //escribi comando
                System.out.println("C: "+comando);    //mostre al usuario
                salida.writeBytes(comando);    //    lo que devuelve el servidor
                System.out.println("S: "+entrada.readLine());    //mostramos al usuario
                
                comando="LIST \r\n";   //escribi comando
                System.out.println("C: "+comando);    //mostre al usuario
                salida.writeBytes(comando);    //    lo que devuelve el servidor
                System.out.println("S: "+entrada.readLine());    //mostramos al usuario
                
                
                comando="QUIT \r\n";   //escribi comando
                System.out.println("C: "+comando);    //mostre al usuario
                salida.writeBytes(comando);    //    lo que devuelve el servidor
                System.out.println("S: "+entrada.readLine());    //mostramos al usuario
                
            
            }
            salida.close();
            entrada.close();
            socket.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        ClientePOP s = new ClientePOP();
    }


}
