package connection;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Observable;
import java.util.Scanner;

import controller.ClientController;
import view.ClientFrame;

public class ClientListener extends Observable implements Runnable {

   private ObjectInputStream inFromServer;
   private Socket socket;

   public ClientListener(Socket sock){
      this.socket = sock;
   }

   public void run() {
      try {
         inFromServer = new ObjectInputStream(socket.getInputStream());
         ArrayList<String> msg = new ArrayList<>();
         while (true) {
            msg = (ArrayList<String>) inFromServer.readObject();
            setChanged();
            notifyObservers(msg);
         }
      }
      catch (IOException e) {
         e.printStackTrace();
      }
      catch (ClassNotFoundException e) {
         e.printStackTrace();
      }
   }
   
   public static String getTime() {
      return new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
   }

}
