import java.io.*;
import java.net.*;
public class Server {
public static void main(String[] args)throws IOException{
ServerSocket ss = new ServerSocket(4444);
Socket cs;
try{
System.out.println("Server is running");
cs = ss.accept();
System.out.println("Client is connected");
cs.close();
}catch(IOException e){
System.out.println("The exception is "+e);
}
ss.close();
}
}

