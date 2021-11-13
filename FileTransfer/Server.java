import java.net.*;
import java.io.*;
public class Server {
    public static void main(String args[]) {
        Socket s;
        ServerSocket server;
        FileInputStream fis;
        BufferedReader br;
        PrintWriter pw;
        String filename;
        int c;
        try {
            server = new ServerSocket(1111);
            System.out.println("Server wait for connetion");
            s = server.accept();
            System.out.println("Connection established");
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            pw = new PrintWriter(s.getOutputStream());
            filename = br.readLine();
            fis = new FileInputStream(filename);
            while ((c = fis.read()) != -1) {
                pw.print((char) c);
                pw.flush();
            }
            System.out.println(filename + " copied to destnation");
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}