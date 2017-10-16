package os.a2;

import java.net.*;
import java.io.*;

public class DateClient {

    public static void main(String[] args) {
        try {
            /* make connection to server socket */
            Socket sock = new Socket("127.0.0.1", 6013);
            PrintWriter pout = new PrintWriter(sock.getOutputStream(), true);
            BufferedReader in
                    = new BufferedReader(
                            new InputStreamReader(sock.getInputStream()));
            BufferedReader stdIn
                    = new BufferedReader(new InputStreamReader(System.in));
            String userInput;

            System.out.println("Hit 'x' to close connection");
            while ((userInput = stdIn.readLine()) != null) {
                if(userInput.equals("x")){
                    sock.close();
                }
                pout.println(userInput);
                System.out.println("echo:" +in.readLine());
            }
            /* close the socket connection*/
            sock.close();
        } catch (IOException ioe) {
            System.err.println(ioe);
        }
    }
}
