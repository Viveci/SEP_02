package model.mediator;

import model.model.Data;

public interface Model {
   public void addMessage(String message);
   public void notifyAboutMessage(Data data);
   public void addMessage(Data message);
}
