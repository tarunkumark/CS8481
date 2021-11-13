import java.net.*;
import java.io.*;
public class Client {
    public static void main(String agrs[]) {
        Socket s;
        BufferedReader in , br;
        PrintWriter pw;
        String spath, dpath;
        FileOutputStream fos;
        int c;
        try {
            s = new Socket("localhost", 1111); in = new BufferedReader(new InputStreamReader(System.in));
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            pw = new PrintWriter(s.getOutputStream(), true);
            System.out.println("Enter the Source path to copy file:");
            spath = in .readLine();
            System.out.println("Enter the destination path to transfer:");
            dpath = in .readLine();
            fos = new FileOutputStream(dpath);
            pw.println(spath);
            while ((c = br.read()) != -1) {
                fos.write((char) c);
                fos.flush();
            }
            System.out.println("File transfer completed");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}