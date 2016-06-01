package model.model;

import java.io.Serializable;
import java.sql.Date;

public class Event implements Serializable {

   private int eventId;
   private String eventName;
   private int capacity;
   private String eventDescription;
   private Date signupDeadline;
   private String roomNumber;

   public Event() {
   }
   
   public Event(int eventId, String eventName, int capacity,
         String eventDescription, Date signupDeadline, String roomNumber) {
      super();
      this.eventId = eventId;
      this.eventName = eventName;
      this.capacity = capacity;
      this.eventDescription = eventDescription;
      this.signupDeadline = signupDeadline;
      this.roomNumber = roomNumber;
   }

   public int getEventId() {
      return eventId;
   }

   public String getEventName() {
      return eventName;
   }

   public int getCapacity() {
      return capacity;
   }

   public String getEventDescription() {
      return eventDescription;
   }

   public Date getSignupDeadline() {
      return signupDeadline;
   }

   public String getRoomNumber() {
      return roomNumber;
   }

   public void setEventId(int eventId) {
      this.eventId = eventId;
   }

   public void setEventName(String eventName) {
      this.eventName = eventName;
   }

   public void setCapacity(int capacity) {
      this.capacity = capacity;
   }

   public void setEventDescription(String eventDescription) {
      this.eventDescription = eventDescription;
   }

   public void setSignupDeadline(Date signupDeadline) {
      this.signupDeadline = signupDeadline;
   }

   public void setRoomNumber(String roomNumber) {
      this.roomNumber = roomNumber;
   }

}
