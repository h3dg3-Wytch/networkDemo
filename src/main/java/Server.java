import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by h3dg3wytch on 8/30/16.
 */
public class Server {

    public static void main(String[] args){
        ServerSocket myService = null;
        Socket serviceSocket = null;
        try{
            myService = new ServerSocket(20);
        }catch (IOException e){
            System.out.println(e);
        }

        Socket clientSocket = null;
        try {
            serviceSocket = myService.accept();
        }
        catch (IOException e) {
            System.out.println(e);
        }

        DataInputStream input;
        try {
            input = new DataInputStream(serviceSocket.getInputStream());
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

}
