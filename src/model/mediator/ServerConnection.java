package model.mediator;

import java.net.ServerSocket;
import java.net.Socket;

import model.mediator.Model;

public class ServerConnection implements Runnable {
   
   private static final int PORT = 6006;
   private Model model;

   public ServerConnection(Model model) {
      this.model = model;
   }

   public void run() {
      try {
         System.out.println("Starting Server...");

         // create welcoming socket at specified port
         ServerSocket welcomeSocket = new ServerSocket(PORT);
         while (true) {
            System.out.println("Waiting for a client...");

            // Wait, on welcoming socket for contact by client
            Socket connectionSocket = welcomeSocket.accept();
            // Start a thread with the client communication
            ServerCommunication c = new ServerCommunication(connectionSocket,
                  model);
            new Thread(c).start();

         }
      }
      catch (Exception e) {
         System.out.println("Exception in connection to server: " + e.getMessage());
      }
   }

}