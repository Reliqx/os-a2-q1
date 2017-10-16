package os.a2;

import java.net.*;
import java.io.*;

public class DateServer {

    public static void main(String[] args) {
        try {
            ServerSocket sock = new ServerSocket(6013);
            /* now listen for connections */
            while (true) {
                try (
                        Socket client = sock.accept();
                        PrintWriter out
                        = new PrintWriter(client.getOutputStream(), true);
                        BufferedReader in = new BufferedReader(
                                new InputStreamReader(client.getInputStream()));) {
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        out.println(inputLine);
                        
                    }
                    client.close();
                }
                
            catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port 6013"
                + " or listening for a connection");
            System.out.println(e.getMessage());
        }
        }

    }
catch (IOException ioe) {
            System.err.println(ioe);
        }
    }
}
