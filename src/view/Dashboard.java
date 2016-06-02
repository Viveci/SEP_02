package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.model.Account;
import model.model.Booking;
import model.model.EventView;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JList;
import com.toedter.calendar.JCalendar;
import java.awt.Dimension;

public class Dashboard extends JPanel implements ActionListener {
   
   private Account acc;
   
   private ArrayList<EventView> events;
   
   private JLabel profileName;
   private JLabel profileId;

   public Dashboard(Account acc) {
      setBounds(0, 50, 800, 420);
      setBackground(Color.decode("#FFFFFF"));
      setLayout(null);
      
      this.acc = acc;
      
      JPanel profilePanel = new JPanel();
      profilePanel.setBounds(10, 10, 350, 120);
      add(profilePanel);
      profilePanel.setLayout(null);
      
      Image image = new ImageIcon("C:\\Dev\\JGWS\\SEP_02\\user.jpg").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
      JLabel profileIcon = new JLabel(new ImageIcon(image));
      profileIcon.setBounds(20, 20, 80, 80);
      profilePanel.add(profileIcon);
      
      profileName = new JLabel("User name");
      profileName.setFont(new Font("Aileron", Font.PLAIN, 18));
      profileName.setBounds(110, 30, 220, 20);
      profilePanel.add(profileName);
      
      profileId = new JLabel("User id");
      profileId.setFont(new Font("Aileron", Font.PLAIN, 14));
      profileId.setBounds(110, 61, 220, 16);
      profilePanel.add(profileId);
      
      JPanel calendar = new JPanel();
      calendar.setBounds(10, 140, 350, 270);
      add(calendar);
      calendar.setLayout(null);
      
      JLabel calendarTitle = new JLabel("Calendar");
      calendarTitle.setFont(new Font("Aileron", Font.PLAIN, 18));
      calendarTitle.setBounds(125, 10, 100, 26);
      calendar.add(calendarTitle);
      
      JPanel upcoming = new JPanel();
      upcoming.setBounds(370, 10, 410, 300);
      add(upcoming);
      upcoming.setLayout(null);
      
      JLabel upcomingTitel = new JLabel("Upcoming events");
      upcomingTitel.setFont(new Font("Aileron", Font.PLAIN, 18));
      upcomingTitel.setBounds(130, 10, 150, 26);
      upcoming.add(upcomingTitel);
      
      //Booking[] data = {new Booking(1, "asd", "asd", null, null, null)};
      events = ClientFrame.cntrl.getAllEvents("events:"+acc.getUserID());
      EventView[] data = {events.get(0)};
      
      JScrollPane listScroll = new JScrollPane();
      listScroll.setBounds(10, 40, 390, 250);
      
      JList upcomingList = new JList(data);
      upcomingList.setBounds(10, 40, 390, 250);
      listScroll.setViewportView(upcomingList);
      upcoming.add(listScroll);
      
      JPanel buttons = new JPanel();
      buttons.setBounds(370, 320, 410, 90);
      add(buttons);
      buttons.setLayout(null);
      
      JButton buttonsBooking = new JButton("New Booking");
      buttonsBooking.setBounds(10, 10, 120, 70);
      buttons.add(buttonsBooking);
      buttonsBooking.addActionListener(this);
      
      JButton buttonsMyBookings = new JButton("My bookings");
      buttonsMyBookings.setBounds(145, 10, 120, 70);
      buttons.add(buttonsMyBookings);
      buttonsMyBookings.addActionListener(this);
      
      JButton buttonsLogout = new JButton("LogOut");
      buttonsLogout.setBounds(280, 10, 120, 70);
      buttons.add(buttonsLogout);
      buttonsLogout.addActionListener(this);
      
      if(this.acc != null){
         profileName.setText(acc.getUserName());
         profileId.setText(acc.getUserID());
      }
   }

   public Account getAcc() {
      return acc;
   }

   public void setAcc(Account acc) {
      this.acc = acc;
      this.refresh();
   }
   
   private void refresh(){
      profileName.setText(acc.getUserName());
      profileId.setText(acc.getUserID());
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
      if (e.getActionCommand().equals("LogOut")) {
         System.out.println("Dashboard panel: logout");
         getParent().getComponent(0).setVisible(false);
         getParent().add(new LoginPanel(), 0);
      }
      else if(e.getActionCommand().equals("My bookings")){
         System.out.println("Dashboard panel: My bookings");
         getParent().getComponent(0).setVisible(false);
         getParent().add(new MyBookingsPanel(acc), 0);
      }
      else if(e.getActionCommand().equals("New Booking")){
         System.out.println("Dashboard panel: New Booking");
         getParent().getComponent(0).setVisible(false);
         getParent().add(new BookingPanel(acc), 0);
      }
   }
}
