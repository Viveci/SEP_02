package main;

import connection.Client;
import controller.ClientController;
import controller.Controller;
import model.mediator.ClientModelManager;
import model.mediator.Model;
import view.ClientFrame;
import view.View;

public class ClientMain {
   public static void main(String args[]) {
      try {
         View view = new ClientFrame();
         
         Client client = new Client();
         
         Controller controller = new ClientController(view, client);
         view.start(controller);
      }
      catch (Exception e) {
         e.printStackTrace();
      }
   }
}
