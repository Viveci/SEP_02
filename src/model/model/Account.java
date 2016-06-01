package model.model;

import java.io.Serializable;

public class Account implements Serializable{
   
   private String UserName;
   private String UserID;
   private String Password;
   private int type;
   
   public Account(){
      UserName = "EMPTY";
      UserID = "EMPTY";
      Password = "EMPTY";
      type = -1;
   }

   public Account(String userId, String pass){
      this.UserID = userId;
      this.Password = pass;
   }
   
   public Account(String userName, String userID, String password, int type) {
      super();
      this.UserName = userName;
      this.UserID = userID;
      this.Password = password;
      this.type = type;
   }

   public void setUserName(String userName) {
      UserName = userName;
   }

   public void setUserID(String userID) {
      UserID = userID;
   }

   public void setPassword(String password) {
      Password = password;
   }

   public void setType(int type) {
      this.type = type;
   }

   public String getUserName() {
      return UserName;
   }

   public String getUserID() {
      return UserID;
   }

   public String getPassword() {
      return Password;
   }

   public int getType() {
      return type;
   }

}
