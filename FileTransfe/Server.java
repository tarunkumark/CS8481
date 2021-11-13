import java.awt.*;  
import javax.swing.JFrame;  
  
public class Server extends Canvas{  
      
    public void paint(Graphics g) {  
  
        Toolkit t=Toolkit.getDefaultToolkit();  
        Image i=t.getImage("friendship.jpg");  
        g.drawImage(i, 120,100,this);  
          
    }  
        public static void main(String[] args) {
	System.out.println("Server Waiting for image\nClient Connected.\nImage Size:12KB");  
        MyCanvas m=new MyCanvas();  
        JFrame f=new JFrame();  
        f.add(m);  
        f.setSize(400,400);  
        f.setVisible(true);  
    }  
  
}  
