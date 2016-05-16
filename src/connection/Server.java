package connection;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Server {
  
   public static String getTime() {
      return new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance()
            .getTime());
   }

   public static void main(String args[]) {
      System.out.println(getTime() + ":Server start...");
      
      final int port = 6006;
      
      try {
			ServerSocket serverSocket = new ServerSocket(port);
			Socket socket = serverSocket.accept();

			InputStream inputStream = socket.getInputStream();
			ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
			String input = (String) objectInputStream.readObject();
			
			PrintStream printStream = new PrintStream(socket.getOutputStream());
			
			while(!input.equalsIgnoreCase("exit")){
			   System.out.println(getTime() + ":Client: " +input);
			   input = (String) objectInputStream.readObject();
			   if(input.equals("asd")){
			      printStream.println("Stop fooling around");
			   }
			}
			
			System.out.println("The server has been terminated by the client");

			
			printStream.println("Server is down");
			printStream.println("also this line");
        
         inputStream.close();
         socket.close();
         serverSocket.close();
         
      } catch (Exception e) {
         System.out.println(e);
      }
   }

}