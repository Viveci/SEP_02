package model.mediator;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

import model.model.*;

public class ClientModelProxy implements Model, Observer {
   private ObjectInputStream inFromServer;
   private ObjectOutputStream outToServer;
   private Model model;
   private Socket socket;
   private ClientReceiver reciever;

   private static final String HOST = "localhost";
   private static final int PORT = 6006;

   public ClientModelProxy(Model model) throws IOException {
      this.model = model;
      try {
         socket = new Socket(HOST, PORT);
         outToServer = new ObjectOutputStream(socket.getOutputStream());
         inFromServer = new ObjectInputStream(socket.getInputStream());
         reciever = new ClientReceiver(inFromServer, model);
         new Thread(reciever, "Reciever").start();
      }
      catch (Exception e) {
         e.printStackTrace();
      }

   }

   @Override
   public void update(Observable arg0, Object arg1) {
      try {
         String message = (String) arg1;
         outToServer.writeObject(message);
      }
      catch (Exception e) {
         // no client connection
         System.out.println("DEBUG: Exception for client broadcast " + " - "
               + e.getMessage());
         ((Observable) model).deleteObserver(this);
         String m = new String("DEBUG: Server> A client has been disconnected");
         System.out.println("DEBUG: " + m);
         model.addMessage(m);
      }
   }

   @Override
   public void addMessage(String message) {
      try {
         outToServer.writeObject(message);
      }
      catch (IOException e) {
         e.printStackTrace();
      }
   }

   @Override
   public void notifyAboutMessage(Data message) {
      // nothing
   }

   @Override
   public void addMessage(Data message) {
      // TODO Auto-generated method stub

   }

}
