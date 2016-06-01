package main;

import connection.MultiThreadServer;
import controller.Controller;
import controller.ServerController;
import model.mediator.Model;
import model.mediator.ServerModelManager;
import view.ServerFrame;
import view.View;

public class ServerMain {
   public static void main(String args[]) {
      try {
         View view = new ServerFrame();
         
         MultiThreadServer server = new MultiThreadServer();
         Thread mserver= new Thread(server);
         mserver.start();
         
         Controller controller = new ServerController(view,server);
         view.start(controller);
      }
      catch (Exception e) {
         e.printStackTrace();
      }
   }
}
