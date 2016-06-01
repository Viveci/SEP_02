package SQL;

import java.util.ArrayList;

import model.model.EventView;

public class SqlAdapterOld {
   
   private String message;
   
   public SqlAdapterOld(String s){
      message = s;
   }
   
   public String getAccount(){
      return "Name:auth:123:1";
   }
   
   public boolean registerAccount(String input){
      return true;
   }
   
   public String[] getDashBoardData(String input){
      String[] rtrn = {"Márton:auth:123:1",""};
      return rtrn;
   }
   
   public ArrayList<EventView> getAllEvents(){
      ArrayList<EventView> rtrn = new ArrayList<>();
      
      return null;     
   }

}
