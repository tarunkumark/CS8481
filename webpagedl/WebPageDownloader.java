import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
public class WebPageDownloader {
    public static void main(String[] args) {
        String hostAddres = "www.google.com";
        int port = 80;
        String data = null;
        PrintWriter pw = null;
        BufferedReader bfr = null;
        Socket client = null;
        try {
            client = new Socket(hostAddres, port);
            pw = new PrintWriter(client.getOutputStream(), true);
            bfr = new BufferedReader(new InputStreamReader(client.getInputStream()));

            String reqString = "GET / HTTP/1.1\nHOST:www.google.com\n\n";

            pw.println(reqString);

            do {

                data = bfr.readLine();
                System.out.println(data);

            } while (data != null);

        } catch (IOException e) {
            System.out.println("Stream Problem");
        }

    }
}
