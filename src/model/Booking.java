package model;

import java.util.Date;

public class Booking {

   private int bookingID;
   private String creatorID;
   private int eventID;
   private String RoomNumber;
   private Date from;
   private Date to;
   
   public Booking(int bookingID, String creatorID, String roomNumber, Date from, Date to) {
      this.bookingID = bookingID;
      this.creatorID = creatorID;
      RoomNumber = roomNumber;
      this.from = from;
      this.to = to;
   }

   public Booking(int bookingID, String creatorID, int eventID, Date from, Date to) {
      this.bookingID = bookingID;
      this.creatorID = creatorID;
      this.eventID = eventID;
      this.from = from;
      this.to = to;
   }
   
   public Booking(){
      
   }

   public int getBookingID() {
      return bookingID;
   }
   
   public void setBookingID(int bookingID) {
      this.bookingID = bookingID;
   }
   
   public String getCreatorID() {
      return creatorID;
   }
   
   public void setCreatorID(String creatorID) {
      this.creatorID = creatorID;
   }
   
   public int getEventID() {
      return eventID;
   }
   
   public void setEventID(int eventID) {
      this.eventID = eventID;
   }
   
   public String getRoomNumber() {
      return RoomNumber;
   }
   
   public void setRoomNumber(String roomNumber) {
      RoomNumber = roomNumber;
   }
   
   public Date getFrom() {
      return from;
   }
   
   public void setFrom(Date from) {
      this.from = from;
   }
   
   public Date getTo() {
      return to;
   }
   
   public void setTo(Date to) {
      this.to = to;
   }
   
}
