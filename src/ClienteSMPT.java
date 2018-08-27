import java.io.*;
import java.net.*;
public class ClienteSMPT {
    //todo auto generated method stub
    String Servidor = "mail.ficct.uagrm.edu.bo";
    //String servidor ="172.20.172.254"
    String user_receptor="grupo06sa@ficct.uagrm.edu.bo";
    String user_emisor="cesarfuentes0594@gmail.com";
    String line;
    String comando="";
    String demoCorreo="SALUDOS";
    int puerto=25;
    
    public ClienteSMPT(){
        try {
            //se establece conexion abriendo un socket especificando el servidor 
            //y el puerto SMTP
            Socket socket=new Socket(Servidor, puerto);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
            //escribimos datos en el canal de salida establecido con el puerto del protocolo SMTP del servidor
            if (socket!=null && entrada!=null && salida!=null ) {
                System.out.println("S: "+entrada.readLine());
                comando="HELO "+ Servidor+ "\r\n";   //escribi comando
                System.out.println("C: "+comando);    //mostre al usuario
                salida.writeBytes(comando);    //    lo que devuelve el servidor
                System.out.println("S: "+entrada.readLine());    //mostramos al usuario
                
                comando="MAIL FROM: "+ user_emisor+ "\r\n";   //escribi comando
                System.out.println("C: "+comando);    //mostre al usuario
                salida.writeBytes(comando);    //    lo que devuelve el servidor
                System.out.println("S: "+entrada.readLine());    //mostramos al usuario
                
                comando="RCPT TO: "+ user_receptor+ "\r\n";   //escribi comando
                System.out.println("C: "+comando);    //mostre al usuario
                salida.writeBytes(comando);    //    lo que devuelve el servidor
                System.out.println("S: "+entrada.readLine());    //mostramos al usuario
                
                comando="DATA" + "\r\n";   //escribi comando
                System.out.println("C: "+comando);    //mostre al usuario
                salida.writeBytes(comando);    //    lo que devuelve el servidor
                System.out.println("S: "+entrada.readLine());    //mostramos al usuario
                
                
                comando="SUBJECT: " + demoCorreo + "\r\n";   //escribi comando
                comando=comando+"Hola como estas atte Cesar xd xd.\r\n";   //escribi comando
                comando=comando+".\r\n";   //escribi comando
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
        ClienteSMPT s = new ClienteSMPT();
    }


}
