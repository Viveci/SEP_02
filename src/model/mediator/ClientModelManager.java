package model.mediator;

import java.io.IOException;
import java.util.Observable;

import model.model.Data;

public class ClientModelManager extends Observable implements Model {
   private ClientModelProxy proxy;

   public ClientModelManager() {
      try {
         proxy = new ClientModelProxy(this);
      }
      catch (IOException e) {
         e.printStackTrace();
      }
   }

   @Override
   public void addMessage(String message) {
      proxy.addMessage(message);
   }

   @Override
   public void notifyAboutMessage(Data message) {
      System.out.println("ClientModelManagger: "  + message.toString());
      super.setChanged();
      super.notifyObservers(message);
   }

   @Override
   public void addMessage(Data message) {
      
   }
}
