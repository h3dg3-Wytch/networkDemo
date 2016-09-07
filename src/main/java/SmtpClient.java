import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by h3dg3wytch on 8/30/16.
 */
public class SmtpClient {
    public static void main(String[] args){
        Socket smtpSocket = null;
        DataOutputStream outputStream = null;
        DataInputStream inputStream = null;
        try{
            smtpSocket = new Socket("hostname", 25);
            outputStream = new DataOutputStream(smtpSocket.getOutputStream());
            inputStream = new DataInputStream(smtpSocket.getInputStream());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(smtpSocket != null && outputStream != null && inputStream != null){
            try {
                outputStream.writeBytes("HELO\n");
                outputStream.writeBytes("MAIL From: k3is@fundy.csd.unbsj.ca\n");
                outputStream.writeBytes("RCPT To: k3is@fundy.csd.unbsj.ca\n");
                outputStream.writeBytes("DATA\n");
                outputStream.writeBytes("From: k3is@fundy.csd.unbsj.ca\n");
                outputStream.writeBytes("Subject: testing\n");
                outputStream.writeBytes("Hi there\n"); // message body
                outputStream.writeBytes("\n.\n");
                outputStream.writeBytes("QUIT");

                String responseLine;
                while((responseLine = inputStream.readLine()) != null){
                    System.out.println("server: " + responseLine);
                    if(responseLine.indexOf("Ok") != -1)
                        break;

                }

                outputStream.close();
                inputStream.close();
                smtpSocket.close();
            }catch (IOException e){

            }
        }
    }
}
