package controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import SQL.SqlAdapter;
import SQL.SqlAdapterOld;
import connection.MultiThreadServer;
import model.mediator.Model;
import view.View;

public class ServerController implements Controller {

   private MultiThreadServer server;
   private View view;
   private SqlAdapterOld adapter;

   public ServerController(View view, MultiThreadServer server) {
      this.view = view;
      this.server = server;
      this.adapter = new SqlAdapterOld("need for speed");
   }

   @Override
   public ArrayList<String> execute(String what) {
      ArrayList<String> reply = new ArrayList<>();
      String[] parseAction = what.split(":");
      switch (parseAction[0]) {
         case "auth":
            System.out.println(getTime() + ":ServerController: Beggining authorization...");
            reply.add("Account");
            reply.add(adapter.getAccount());
            break;
         case "reg":
            System.out.println(getTime() + ":ServerController: Registration....");
            reply.add("Register");
            reply.add(adapter.registerAccount(what.substring(3)) + "");
            break;
         case "dash":
            System.out.println(getTime() + ":ServerController: Dashboard data....");
            reply.add("Dashboard");
            String[] sql = adapter.getDashBoardData(parseAction[1]);
            for (int i = 0; i < sql.length; i++) {
               System.out.println(sql[i]);
               reply.add(sql[i]);
            }
            break;
         case "events":
            System.out.println(getTime() + ":ServerController: getin events ....");
            reply.add("Events");
            break;
         case "booking":
            System.out.println(getTime() + ":ServerController: inserting new booking ....");
            reply.add("Booking");
            break;
         default:
            break;
      }
      return reply;
   }

   public String Auth() {
      return adapter.getAccount();
   }

   public static String getTime() {
      return new SimpleDateFormat("HH:mm:ss")
            .format(Calendar.getInstance().getTime());
   }

}
