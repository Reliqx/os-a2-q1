package os.a2;

import java.net.*;
import java.io.*;

public class EchoClient {

    public static void main(String[] args) {
        try {
            /* make connection to server socket */
            Socket sock = new Socket("127.0.0.1", 6013);
            //prints to the server the user value
            PrintWriter pout = new PrintWriter(sock.getOutputStream(), true);
            //reads the value of the server socket
            BufferedReader in
                    = new BufferedReader(
                            new InputStreamReader(sock.getInputStream()));
            //used as a scanner value for user input.
            BufferedReader stdIn
                    = new BufferedReader(new InputStreamReader(System.in));
            String userInput;
            //exit string to close the connection
            System.out.println("Hit 'x' to close connection");
            while ((userInput = stdIn.readLine()) != null) {
                if(userInput.equals("x")){
                    sock.close();
                }
                //prints the user input to the socket
                pout.println(userInput);
                //gets the readed value from the server socket and prints it out
                System.out.println("echo:" +in.readLine());
            }
            /* close the socket connection*/
            sock.close();
        } catch (IOException ioe) {
            System.err.println(ioe);
        }
    }
}
