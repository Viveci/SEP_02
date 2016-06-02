package model.model;

public class EventView {

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

   private String parse;
   
   public EventView(String eventName, String eventDescription,
         int eventCapacity, String eventSignup, String roomNumber,
         int bookingId, String createdBy, int eventId, String reservationDate,
         String from, String to) {
      super();
      this.eventName = eventName;
      this.eventDescription = eventDescription;
      this.eventCapacity = eventCapacity;
      this.eventSignup = eventSignup;
      this.roomNumber = roomNumber;
      this.bookingId = bookingId;
      this.createdBy = createdBy;
      this.eventId = eventId;
      this.reservationDate = reservationDate;
      this.from = from;
      this.to = to;
   }

   public EventView(String string) {
      this.parse = string;
   }
   
   public String toString(){
      return this.parse;
   }

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
