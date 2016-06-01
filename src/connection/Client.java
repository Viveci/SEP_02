package connection;

import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.io.*;

public class Client{

   private Socket socket;

   private OutputStream outputStream;
   private ObjectOutputStream out;
   
   private ObjectInputStream in;
   
   private ClientListener cl;

   public Client() {
      try {
         socket = new Socket("localhost", 6007);
         
         cl = new ClientListener(socket);
         
         outputStream = socket.getOutputStream();
         out = new ObjectOutputStream(outputStream);
         
         new Thread(cl).start();
      }
      catch (UnknownHostException e) {
         e.printStackTrace();
      }
      catch (IOException e) {
         e.printStackTrace();
      }
      
   }

   public void send(String msg) {
      try {
         out.writeObject(msg);
      }
      catch (IOException e) {
         e.printStackTrace();
      }
   }
   
   public static String getTime() {
      return new SimpleDateFormat("HH:mm:ss")
            .format(Calendar.getInstance().getTime());
   }
   
   public ClientListener getListener(){
      return this.cl;
   }

}