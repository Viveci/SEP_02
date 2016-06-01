package model.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class Booking implements Serializable{

   private int bookingID;
   private String creatorID;
   private int eventID;
   private String RoomNumber;
   private Date reservationDate;
   private Timestamp to;
   private Timestamp from;
   
   public Booking(int bookingID, String creatorID, String roomNumber, Date reservationDate, Timestamp to, Timestamp from) {
      this.bookingID = bookingID;
      this.creatorID = creatorID;
      RoomNumber = roomNumber;
      this.reservationDate = reservationDate;
      this.to = to;
      this.from = from;
   }

   public Booking(int bookingID, String creatorID, int eventID, Date reservationDate, Timestamp to, Timestamp from) {
      this.bookingID = bookingID;
      this.creatorID = creatorID;
      this.eventID = eventID;
      this.reservationDate = reservationDate;
      this.to = to;
      this.from = from;
   }

   public int getBookingID() {
      return bookingID;
   }

   public String getCreatorID() {
      return creatorID;
   }

   public int getEventID() {
      return eventID;
   }

   public String getRoomNumber() {
      return RoomNumber;
   }

   public Date getReservationDate() {
      return reservationDate;
   }

   public Timestamp getTo() {
      return to;
   }

   public Timestamp getFrom() {
      return from;
   }
   
   
   
}
