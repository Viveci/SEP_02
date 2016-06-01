package model.mediator;

import java.io.ObjectInputStream;
import java.net.SocketException;

import model.model.Data;

public class ClientReceiver implements Runnable {
   
   private ObjectInputStream inFromServer;
   private Model model;

   public ClientReceiver(ObjectInputStream inFromServer, Model model) {
      this.inFromServer = inFromServer;
      this.model = model;
   }

   public void run() {
      try {
         while (true) {
            Data message = (Data) inFromServer.readObject();
            model.notifyAboutMessage(message);
         }
      }
      catch (SocketException e) {
         e.printStackTrace();
      }
      catch (Exception e) {
         e.printStackTrace();
      }
   }
}
