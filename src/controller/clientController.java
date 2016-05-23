package controller;

import javax.swing.JPanel;

import connection.Client;
import model.Account;
import model.Booking;

import view.BookingPanel;
import view.Dashboard;
import view.LoginPanel;
import view.MyBookingsPanel;
import view.RegisterPanel;

public class clientController {

   private JPanel panel;
   private Booking model;
   private Client client;
   
   //Constructors
   public clientController(BookingPanel panel, Booking model){
      this.panel = (BookingPanel) panel;
      this.model = (Booking) model;
   }
   
   public clientController(Dashboard panel){
      this.panel = (Dashboard) panel;
   }
   
   public clientController(MyBookingsPanel panel){
      this.panel = (MyBookingsPanel) panel;
   }
   
   public clientController(RegisterPanel panel){
      this.panel = (RegisterPanel) panel;
   }
   
   public clientController(LoginPanel panel){
      this.panel = (LoginPanel) panel;
   }
   
   //Controller logic
   public void setBookingID(int id){
      this.model = (Booking)model;
      model.setBookingID(id);
   }
   
   public boolean authenticate(){
      boolean valid = false;
            
      //Account dbAccount = (Account) client.msgServer("id")[0];
      Account dbAccount = new Account("Marton","240190","asd",4);
            
      if(((LoginPanel)panel).getInputEmail().getText().equalsIgnoreCase(dbAccount.getUserID()) && ((LoginPanel)panel).getInputPassword().getText().equalsIgnoreCase(dbAccount.getPassword())){
         valid = true;
      }
      
      return valid;
   }
}
