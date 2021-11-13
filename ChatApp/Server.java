import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(4444);
        System.out.println("server started");
        Socket client = ss.accept();
        System.out.println("client connected");
        BufferedReader bfr = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter pw = new PrintWriter(client.getOutputStream(), true);
        Scanner userInput = new Scanner(System.in);
        String dataFromClient = "null";
        String dataToClient = "null";
        do {
            dataFromClient = bfr.readLine();
            System.out.println("dataFromClient: " + dataFromClient);
            dataToClient = userInput.nextLine();

            pw.println(dataToClient);
        } while (!dataFromClient.equals("-1"));
        bfr.close();
        pw.close();
        ss.close();
        client.close();
        userInput.close();
    }
}