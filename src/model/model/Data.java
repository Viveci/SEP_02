package model.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Data implements Serializable{
   
   private ArrayList<String> data;
   
   public Data(ArrayList<String> data){
      this.data = data;
   }
   
   public String toString(){
      return data.get(0);
   }

}
