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
                System.out.println("S: "+LeerLineas(entrada));    //mostramos al usuario
                
                comando="RETR 7\r\n";   //escribi comando
                System.out.println("C: "+comando);    //mostre al usuario
                salida.writeBytes(comando);    //    lo que devuelve el servidor
                System.out.println("S: "+LeerLineas(entrada));    //mostramos al usuario
                
                
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
    
    static protected String LeerLineas(BufferedReader in) throws IOException{
        String lines="";
        while (true) {            
            String line=in.readLine();
            if (line==null) {
                // server closed connection
                throw new IOException("S : Server unawares closed the connection.");
            }
            if (line.equals(".")) {
                // no more lines in the server response
                //termino el correo
                break;
            }
            if ((line.length()>0)&& (line.charAt(0)=='.')) {
                // the line start whith a '.' - strip it off.
                line = line.substring(1);
            }
            //add read line to the list of lines
            lines=lines+"\n"+line;
        }
        return lines;
    }
    public static void main(String[] args) {
        ClientePOP s = new ClientePOP();
    }


}
