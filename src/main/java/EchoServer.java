import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by h3dg3wytch on 8/30/16.
 */
public class EchoServer {

    public static void main(String[] args){
        if (args.length != 1) {
            System.err.println("Usage: java EchoServer <port number>");
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[0]);
        try(ServerSocket serverSocket = new ServerSocket(portNumber);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream()));
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())
        ){

        }



    }
}
