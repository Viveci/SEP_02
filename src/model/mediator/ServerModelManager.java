package model.mediator;

import java.util.Observable;

import model.mediator.Model;
import model.model.Data;

public class ServerModelManager extends Observable implements Model {
   private ServerConnection server;

   public ServerModelManager() {
      this.server = new ServerConnection(this);
      new Thread(server, "Server").start();
   }

   @Override
   public void addMessage(Data message) {
      
   }

   @Override
   public void notifyAboutMessage(Data message) {
      
   }

   @Override
   public void addMessage(String message) {
      System.out.println("Server Model Manager: "+ message);
   }

}
