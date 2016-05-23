package connection;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MultiThreadServer implements Runnable {
   
   private Socket socket;
   
   protected MultiThreadServer(Socket socket){
      this.socket = socket;
   }
  
   public static void main(String args[]) 
         throws Exception {
            ServerSocket ssock = new ServerSocket(6006);
            System.out.println("Server started...\nListening...");
            while (true) {
               Socket sock = ssock.accept();
               System.out.println("Connected");
               new Thread(new MultiThreadServer(sock)).start();
            }
         }

   @Override
   public void run() {
      try{
         InputStream inputStream = socket.getInputStream();
         ObjectInputStream in = new ObjectInputStream(inputStream);
         String msg = "Go";
         while(!msg.equalsIgnoreCase("Exit")){
            msg = (String)in.readObject();
            System.out.println(getTime()+": " + msg);
         }
         System.out.println("Thread is stopped");
      }
      catch(Exception e){
         e.printStackTrace();
      }
   }

   public static String getTime() {
      return new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance()
            .getTime());
   }

   
}