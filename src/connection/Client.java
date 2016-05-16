package connection;

import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.io.*;

public class Client {
   
   public static void main(String args[]) {
      System.out.println(getTime() + "//Cleint start");
      
      try {
         Socket socket = new Socket("localhost", 6006);
         String list;
         Scanner dataFromServer = new Scanner(socket.getInputStream());
         
         OutputStream outputStream = socket.getOutputStream();
         ObjectOutputStream out = new ObjectOutputStream(outputStream);
         
         Scanner sc = new Scanner(System.in);
         String output = "open";

         while(!output.equalsIgnoreCase("no")){
            System.out.println("<Type your message>");
            output = sc.nextLine();
            out.writeObject(output);
         }
         out.writeObject("exit");
         
         list = dataFromServer.nextLine();
         System.out.println(list);
         
      } catch (Exception e) {
         System.out.println(e);
      }
   }
   
   public static String getTime() {
      return new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance()
            .getTime());
   }
   
}