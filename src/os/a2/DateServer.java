package os.a2;

import java.net.*;
import java.io.*;

public class DateServer {

    public static void main(String[] args) {
        try {
            ServerSocket sock = new ServerSocket(6013);
          //accepts connections 
            while (true) {
                Socket client = sock.accept();
                try (
                        //this will get whatever the client has written in the socket
                        PrintWriter out
                        = new PrintWriter(client.getOutputStream(), true);
                        //reads the socket
                        BufferedReader in = new BufferedReader(
                                new InputStreamReader(client.getInputStream()));) {
                    String inputLine;
                    //prints the information within the socket
                    while ((inputLine = in.readLine()) != null) {
                        out.println(inputLine);

                    }

                } catch (IOException e) {
                    System.out.println("Exception caught when trying to listen on port 6013"
                            + " or listening for a connection");
                    System.out.println(e.getMessage());
                }
                client.close();
                 //sock.close();
            }
            
           

        } catch (IOException ioe) {
            System.err.println(ioe);
        }
    }
}
