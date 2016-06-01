package model.model;

public class EventView {

   /*
    * events.eventname, events.capacity, events.eventdescription,
    * events.signupdeadline, events.roomnumber, bookings.bookingsid,
    * bookings.createdby, bookings.eventid, bookings.reservationdate,
    * bookings.hoursfrom, bookings.hoursto, subscribe.userid
    */

   private String eventName;
   private String eventDescription;
   private int eventCapacity;
   private String eventSignup;
   private String roomNumber;
   private int bookingId;
   private String createdBy;
   private int eventId;
   private String reservationDate;
   private String from;
   private String to;

   public String getEventName() {
      return eventName;
   }

   public void setEventName(String eventName) {
      this.eventName = eventName;
   }

   public String getEventDescription() {
      return eventDescription;
   }

   public void setEventDescription(String eventDescription) {
      this.eventDescription = eventDescription;
   }

   public int getEventCapacity() {
      return eventCapacity;
   }

   public void setEventCapacity(int eventCapacity) {
      this.eventCapacity = eventCapacity;
   }

   public String getEventSignup() {
      return eventSignup;
   }

   public void setEventSignup(String eventSignup) {
      this.eventSignup = eventSignup;
   }

   public String getRoomNumber() {
      return roomNumber;
   }

   public void setRoomNumber(String roomNumber) {
      this.roomNumber = roomNumber;
   }

   public int getBookingId() {
      return bookingId;
   }

   public void setBookingId(int bookingId) {
      this.bookingId = bookingId;
   }

   public String getCreatedBy() {
      return createdBy;
   }

   public void setCreatedBy(String createdBy) {
      this.createdBy = createdBy;
   }

   public int getEventId() {
      return eventId;
   }

   public void setEventId(int eventId) {
      this.eventId = eventId;
   }

   public String getReservationDate() {
      return reservationDate;
   }

   public void setReservationDate(String reservationDate) {
      this.reservationDate = reservationDate;
   }

   public String getFrom() {
      return from;
   }

   public void setFrom(String from) {
      this.from = from;
   }

   public String getTo() {
      return to;
   }

   public void setTo(String to) {
      this.to = to;
   }

}
