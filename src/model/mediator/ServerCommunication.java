package model.mediator;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.Observable;
import java.util.Observer;

import controller.ServerController;
import model.mediator.Model;
import model.model.Data;
import view.ServerFrame;

public class ServerCommunication implements Observer, Runnable {
   
   private ObjectInputStream inFromClient;
   private ObjectOutputStream outToClient;
   private Model model;
   private ServerController cntrl;

   public ServerCommunication(Socket clientSocket, Model model)
         throws IOException {
      this.model = model;
      cntrl = ServerFrame.cntrl;
      outToClient = new ObjectOutputStream(clientSocket.getOutputStream());
      inFromClient = new ObjectInputStream(clientSocket.getInputStream());
   }

   public void run() {
      try {
         try {
            ((Observable) model).addObserver(this);
            System.out.println("Server communication: Client has been connected");
         }
         catch (Exception e2) {
         }

         Thread.sleep(1000);

         while (true) {
            String message = (String) inFromClient.readObject();
            model.addMessage(message);
         }
      }
      catch (SocketException e) {
         // ok
      }
      catch (Exception e) {
         e.printStackTrace();
      }
   }

   @Override
   public void update(Observable arg0, Object arg1) {
      try {
         Data message = (Data) arg1;
         outToClient.writeObject(message);
      }
      catch (Exception e) {
         // no client connection
         try {
            ((Observable) model).deleteObserver(this);
            String m = new String("Server> A client has been disconnected");
            System.out.println("DEBUG:" + m);
            model.addMessage(m);
         }
         catch (Exception e2) {
         }
      }
   }

}
