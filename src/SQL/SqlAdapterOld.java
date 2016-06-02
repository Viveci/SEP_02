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
   
   public ArrayList<String> getAllEvents(){
      ArrayList<String> rtrn = new ArrayList<>();
      rtrn.add("Biggest cry session:Yeah, so why do we have semester project?:10:01/06/2016:E.201:1:240190:1:02/06/2016:1200:1300");
      return rtrn;     
   }

}
