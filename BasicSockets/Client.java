import java.io.*;
import java.net.*;
public class Client {
public static void main(String[] args) {
Socket soc;
try{
if(args.length==0)
soc = new Socket(InetAddress.getLocalHost(),4444);
else
soc = new Socket(InetAddress.getByName(args[0]),4444);
System.out.println("Client is running");
soc.close();
}catch(IOException e){
System.out.println("The exception is "+e);
}
}
}