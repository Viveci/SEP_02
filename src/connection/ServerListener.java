package connection;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import controller.Controller;
import controller.ServerController;

public class ServerListener implements Runnable {

   private Socket socket;
   
   private InputStream inputStream;
   private ObjectInputStream in;
   
   private OutputStream outStream;
   private ObjectOutputStream out;
   
   private ServerController cnrtl;
   
   private ArrayList<String> reply;

   public ServerListener(Socket sock, Controller controler) {
      this.reply = new ArrayList<>();
      this.socket = sock;
      this.cnrtl = (ServerController)controler;
      try {
         this.inputStream = socket.getInputStream();
         this.in = new ObjectInputStream(inputStream);
         
         this.outStream = socket.getOutputStream();
         this.out = new ObjectOutputStream(outStream);
      }
      catch (IOException e) {
         e.printStackTrace();
      }
   }

   @Override
   public void run() {
      System.out.println("ServerListner: Running...");
      try {
         String msg = "Go";
         while (!msg.equalsIgnoreCase("Exit")) {
            msg = (String) in.readObject();
            System.out.println(getTime() + ":ServerListener: Incoming:" + msg);
            reply = cnrtl.execute(msg);
            out.writeObject(reply);
            System.out.println(getTime() + ":ServerListener: Out:" + reply.get(0));
         }
         System.out.println("Thread is stopped");
      }
      catch (IOException e) {
         e.printStackTrace();
      }
      catch (ClassNotFoundException e) {
         e.printStackTrace();
      }
      catch (NullPointerException e) {
         e.printStackTrace();
      }
   }

   public static String getTime() {
      return new SimpleDateFormat("HH:mm:ss")
            .format(Calendar.getInstance().getTime());
   }

}
