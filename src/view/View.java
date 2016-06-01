package view;

import java.util.Observer;

import controller.ClientController;
import controller.Controller;

public interface View extends Observer {
   public void start(Controller controller);
}
