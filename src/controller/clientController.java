package controller;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import connection.Client;
import connection.ClientListener;
import model.mediator.Model;
import model.model.Account;
import model.model.EventView;
import view.View;

public class ClientController implements Controller, Observer {

   private View view;
   private Client client;
   private ClientListener listen;
   private ArrayList<String> msg;

   // Constructors
   public ClientController(View view, Client client) {
      this.view = view;
      this.client = client;
      this.listen = client.getListener();
      listen.addObserver(this);
      this.msg = new ArrayList<>();
   }

   @Override
   public ArrayList<String> execute(String what) {
      return null;
   }

   public boolean auth(String input) {
      boolean rtrn = false;

      String[] parseString = input.split(":");
      Account login = new Account(parseString[1], parseString[2]);

      client.send(input);

      try {
         Thread.sleep(200);
      }
      catch (InterruptedException e) {
         e.printStackTrace();
      }

      if (msg.get(0).equals("Account")) {

         // Parsing the message to Account
         String[] AccountParse = msg.get(1).split(":");
         Account account = new Account(AccountParse[0], AccountParse[1],
               AccountParse[2], Integer.parseInt(AccountParse[3]));

         // Logic
         if (login.getUserID().equals(account.getUserID())
               && login.getPassword().equals(account.getPassword())) {
            rtrn = true;
         }
      }
      return rtrn;
   }

   public boolean register(String input) {
      boolean rtrn = false;
      client.send(input);

      try {
         Thread.sleep(200);
      }
      catch (InterruptedException e) {
         e.printStackTrace();
      }

      if (msg.get(0).equals("Register")) {
         if (msg.get(1).equals("true")) {
            rtrn = true;
         }
      }

      return rtrn;
   }

   public void saveBooking(String input){
      client.send(input);
      try {
         Thread.sleep(200);
      }
      catch (InterruptedException e) {
         e.printStackTrace();
      }
   }

   public Account getAccount(String input) {
      client.send(input);
      Account account = new Account();
      try {
         Thread.sleep(200);
      }
      catch (InterruptedException e) {
         e.printStackTrace();
      }
      if (msg.get(0).equals("Dashboard")) {
         String[] AccountParse = msg.get(1).split(":");
         account = new Account(AccountParse[0], AccountParse[1],
               AccountParse[2], Integer.parseInt(AccountParse[3]));
      }
      return account;
   }

   public ArrayList<EventView> getAllEvents(String input) {
      ArrayList<EventView> temp = new ArrayList<>();
      client.send(input);
      try {
         Thread.sleep(200);
      }
      catch (InterruptedException e) {
         e.printStackTrace();
      }
      if(msg.get(0).equals("Events")){
         for (int i = 1; i < msg.size(); i++) {
            temp.add(new EventView(msg.get(i)));
         }
      }
      return temp;
   }
   
   @Override
   public void update(Observable o, Object arg) {
      this.msg = (ArrayList<String>) arg;
   }

}
