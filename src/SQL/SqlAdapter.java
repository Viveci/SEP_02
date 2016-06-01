package SQL;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

public class SqlAdapter
{
   private static final String testDriver = "org.postgresql.Driver";
   private static final String testURL = "jdbc:postgresql://localhost:5432/postgres?currentSchema=viaevents";

   private static org.postgresql.Driver driver;
   private Connection connection;

   public SqlAdapter()
   {
      driver = new org.postgresql.Driver();
      try
      {
         DriverManager.registerDriver(driver);
         connection = DriverManager.getConnection(testURL, "postgres",
               "0513az1az1");

      }
      catch (SQLException e)
      {
         e.printStackTrace();
      }
   }

   // EVERYTHING FROM EVENTS
   public ArrayList<String> getAllEvents() throws SQLException
   {

      ArrayList<String> rtrn = new ArrayList<>();

      PreparedStatement statement3 = connection
            .prepareStatement("SELECT * FROM events;");

      ResultSet result3 = statement3.executeQuery();

      while (result3.next())
      {
         String s = result3.getString("eventid") + ";";
         s += result3.getString("eventname") + ";";
         s += result3.getString("capacity") + ";";
         s += result3.getString("eventdescription") + ";";
         s += result3.getString("signupdeadline") + ";";
         s += result3.getString("roomnumber") + ";";

         rtrn.add(s);
      }
      return rtrn;
   }

   // EVERYTHING FROM FACILITIES
   public ArrayList<String> getAllFacilities() throws SQLException
   {

      ArrayList<String> rtrn = new ArrayList<>();

      PreparedStatement statement = connection
            .prepareStatement("SELECT * FROM facilities;");

      ResultSet result = statement.executeQuery();

      while (result.next())
      {
         String s = result.getString("roomnumber") + ";";
         s += result.getString("roomname") + ";";
         s += result.getString("capacity") + ";";

         rtrn.add(s);
      }
      return rtrn;
   }

   // EVERYTHING FROM USERS
   public ArrayList<String> getAllUsers() throws SQLException
   {

      ArrayList<String> rtrn = new ArrayList<>();

      PreparedStatement statement = connection
            .prepareStatement("SELECT * FROM users;");

      ResultSet result = statement.executeQuery();

      while (result.next())
      {
         String s = result.getString("userid") + ";";
         s += result.getString("name") + ";";
         s += result.getString("usertype") + ";";
         s += result.getString("password") + ";";

         rtrn.add(s);
      }
      return rtrn;
   }

   // EVERYTHING FROM BOOKINGS
   public ArrayList<String> getAllBookings() throws SQLException
   {

      ArrayList<String> rtrn = new ArrayList<>();

      PreparedStatement statement = connection
            .prepareStatement("SELECT * FROM bookings;");

      ResultSet result = statement.executeQuery();

      while (result.next())
      {
         String s = result.getString("bookingsid") + ";";
         s += result.getString("createdby") + ";";
         s += result.getString("eventid") + ";";
         s += result.getString("roomnumber") + ";";
         s += result.getString("reservationdate") + ";";
         s += result.getString("hoursfrom") + ";";
         s += result.getString("hoursto") + ";";

         rtrn.add(s);
      }
      return rtrn;
   }

   // EVERYTHING FROM SUBSCRIBE
   public ArrayList<String> getAllSubscribes() throws SQLException
   {

      ArrayList<String> rtrn = new ArrayList<>();

      PreparedStatement statement = connection
            .prepareStatement("SELECT * FROM subscribe;");

      ResultSet result = statement.executeQuery();

      while (result.next())
      {
         String s = result.getString("eventid") + ";";
         s += result.getString("userid") + ";";

         rtrn.add(s);
      }
      return rtrn;
   }

   // EVERYTHING FROM FIRSTVIEW
   public ArrayList<String> getAllFromFirstView() throws SQLException
   {

      ArrayList<String> rtrn = new ArrayList<>();

      PreparedStatement statement = connection
            .prepareStatement("SELECT * FROM firstview;");

      ResultSet result = statement.executeQuery();

      while (result.next())
      {
         String s = result.getString("eventname") + ";";
         s += result.getString("capacity") + ";";
         s += result.getString("eventdescription") + ";";
         s += result.getString("bookingsid") + ";";
         s += result.getString("createdby") + ";";
         s += result.getString("eventid") + ";";
         s += result.getString("reservationdate") + ";";
         s += result.getString("hoursfrom") + ";";
         s += result.getString("hoursto") + ";";

         rtrn.add(s);
      }
      return rtrn;
   }

   // EVERYTHING FROM SECONDVIEW
   public ArrayList<String> getAllFromSecondView() throws SQLException
   {

      ArrayList<String> rtrn = new ArrayList<>();

      PreparedStatement statement = connection
            .prepareStatement("SELECT * FROM Secondview;");

      ResultSet result = statement.executeQuery();

      while (result.next())
      {
         String s = result.getString("eventname") + ";";
         s += result.getString("capacity") + ";";
         s += result.getString("eventdescription") + ";";
         s += result.getString("bookingsid") + ";";
         s += result.getString("signupdeadline") + ";";
         s += result.getString("roomnumber") + ";";
         s += result.getString("createdby") + ";";
         s += result.getString("eventid") + ";";
         s += result.getString("reservationdate") + ";";
         s += result.getString("hoursfrom") + ";";
         s += result.getString("hoursto") + ";";

         rtrn.add(s);
      }
      return rtrn;
   }

   public static void main(String[] args)
   {
      SqlAdapter bla = new SqlAdapter();

      try
      {
         // bla.addUser("Mart", "240390", "123", 1);
         bla.addBooking(17, "Martina", "G.220a", "2016-11-10", "08:10:48" , "09:10:48");
      }
      catch (SQLException e)
      {
         e.printStackTrace();
      }

   }

   // ADDING USERS
   public void addUser(String name, String userid, String password, int usertype)
         throws SQLException
   {

      Connection dbConnection = null;
      PreparedStatement preparedStatement = null;

      String sql = "INSERT INTO users (name, userid, password, usertype) VALUES ('"
            + name + "','" + userid + "','" + password + "'," + usertype + ");";

      dbConnection = getDBConnection();

      try
      {
         preparedStatement = dbConnection.prepareStatement(sql);
         preparedStatement.executeUpdate();
      }
      catch (SQLException e1)
      {
         e1.printStackTrace();
      }
      System.out.println(sql);
   }

   private static Connection getDBConnection()
   {

      Connection dbConnection = null;

      try
      {

         Class.forName(testDriver);

      }
      catch (ClassNotFoundException e)
      {
         System.out.println(e.getMessage());
      }

      try
      {
         dbConnection = DriverManager.getConnection(testURL, "postgres",
               "0513az1az1");
         return dbConnection;

      }
      catch (SQLException e)
      {
         System.out.println(e.getMessage());
      }
      return dbConnection;
   }

   // GET A SPECIFIC USER
   public ArrayList<String> getASpecificUser(String input) throws SQLException
   {

      ArrayList<String> rtrn = new ArrayList<>();

      PreparedStatement statement = connection
            .prepareStatement("SELECT * FROM users WHERE userid = '" + input
                  + "';");

      ResultSet result = statement.executeQuery();

      while (result.next())
      {
         String s = result.getString("userid") + ";";
         s += result.getString("name") + ";";
         s += result.getString("usertype") + ";";
         s += result.getString("password") + ";";
         rtrn.add(s);
      }
      return rtrn;
   }

   // GET ALL THE BOOKING BY A SPECIFIC USER
   public ArrayList<String> getAllTheBookingByASpecificUser(String input)
         throws SQLException
   {

      ArrayList<String> rtrn = new ArrayList<>();

      PreparedStatement statement = connection
            .prepareStatement("SELECT * FROM secondview WHERE userid = '"
                  + input + "';");

      ResultSet result = statement.executeQuery();

      while (result.next())
      {
         String s = result.getString("eventname") + ";";
         s += result.getString("capacity") + ";";
         s += result.getString("eventdescription") + ";";
         s += result.getString("bookingsid") + ";";
         s += result.getString("signupdeadline") + ";";
         s += result.getString("roomnumber") + ";";
         s += result.getString("createdby") + ";";
         s += result.getString("eventid") + ";";
         s += result.getString("reservationdate") + ";";
         s += result.getString("hoursfrom") + ";";
         s += result.getString("hoursto") + ";";

         rtrn.add(s);
      }
      return rtrn;
   }

   // ADDING BOOKING
   public void addBooking(int bookingsid, String createdby,
         String roomnumber, String reservationdate, String hoursfrom, String hoursto)
         throws SQLException
   {

      Connection dbConnection = null;
      PreparedStatement preparedStatement = null;

      String sql = "INSERT INTO bookings (bookingsid,createdby,roomnumber,reservationdate,hoursfrom,hoursto) VALUES "
            + "("+ bookingsid + ",'" +createdby+"','"+roomnumber + "','" + reservationdate + "','" + hoursfrom+ "', '" + hoursto+ "');";

      dbConnection = getDBConnection();

      try
      {
         preparedStatement = dbConnection.prepareStatement(sql);
         preparedStatement.executeUpdate();
      }
      catch (SQLException e1)
      {
         e1.printStackTrace();
      }
      System.out.println(sql);
   }
}