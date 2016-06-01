package connection;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Observable;
import java.util.Observer;

import model.mediator.Model;
import view.ServerFrame;

public class MultiThreadServer implements Runnable, Observer {

   private Socket socket;
   private ServerSocket ssock;

   public MultiThreadServer() {

   }

   @Override
   public void run() {
      try {
         ssock = new ServerSocket(6007);
         System.out.println("Server started...\nListening...");
         while (true) {
            Socket sock = ssock.accept();
            System.out.println("Connected");
            new Thread(new ServerListener(sock, ServerFrame.cntrl)).start();
         }
      }
      catch (IOException e) {
         e.printStackTrace();
      }
   }

   @Override
   public void update(Observable arg0, Object arg1) {

   }

}