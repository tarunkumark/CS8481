import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket Server = new Socket(InetAddress.getLocalHost(), 4444);
        BufferedReader bfr = new BufferedReader(new InputStreamReader(Server.getInputStream()));
        PrintWriter pw = new PrintWriter(Server.getOutputStream(), true);
        Scanner userInput = new Scanner(System.in);
        String dataToSend = "";

        String dataFromServer = "";
        //String dataFromSend="";
        do {
            dataToSend = userInput.nextLine();
            pw.println(dataToSend);
            dataFromServer = bfr.readLine();
            System.out.println("Reply:" + dataFromServer);
        } while (!dataFromServer.equals("-1"));
        bfr.close();
        pw.close();
        userInput.close();
        Server.close();
    }

}