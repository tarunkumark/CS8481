import java.io.*;
import java.net.*;
import java.util.*;
import java.util.regex.*;
public class Server{
public static boolean isValidIP(String ip)
    {
        String zeroTo255
            = "(\\d{1,2}|(0|1)\\"
              + "d{2}|2[0-4]\\d|25[0-5])";
        String regex
            = zeroTo255 + "\\."
              + zeroTo255 + "\\."
              + zeroTo255 + "\\."
              + zeroTo255;

        Pattern p = Pattern.compile(regex);
        if (ip == null) {
            return false;
        }

        Matcher m = p.matcher(ip);

        return m.matches();
    }
  public static void main(String args[]) {
    try {
      DatagramSocket server = new DatagramSocket(1309);
      InetAddress host;
      while (true) {
        byte[] sendbyte = new byte[1024];
        byte[] receivebyte = new byte[1024];
        DatagramPacket receiver = new DatagramPacket(receivebyte, receivebyte.length);
        server.receive(receiver);
        String str = new String(receiver.getData());
        String s = str.trim();
        //System.out.println(s);
        InetAddress addr = receiver.getAddress();
        int port = receiver.getPort();
	System.out.println("Server is running");
        if(isValidIP(s)){
          host = InetAddress.getByName(s);
          sendbyte = host.getHostName().getBytes();
          DatagramPacket sender = new DatagramPacket(sendbyte, sendbyte.length, addr, port);
          server.send(sender);
        }
        else{
          host = InetAddress.getByName(s);
          sendbyte = host.getHostAddress().getBytes();
          DatagramPacket sender = new DatagramPacket(sendbyte, sendbyte.length, addr, port);
          server.send(sender);
        }
        
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
