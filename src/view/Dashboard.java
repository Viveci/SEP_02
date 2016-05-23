package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Booking;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JList;

public class Dashboard extends JPanel implements ActionListener {

   public static void main(String[] args) {
      Dashboard gui = new Dashboard();
      gui.setVisible(true);
   }

   public Dashboard() {
      setBounds(0, 50, 800, 420);
      setBackground(Color.decode("#FFFFFF"));
      setLayout(null);
      
      JPanel profilePanel = new JPanel();
      profilePanel.setBounds(10, 10, 350, 120);
      add(profilePanel);
      profilePanel.setLayout(null);
      
      
      ImageIcon profileimage = new ImageIcon("/SEP_02/user.jpg");
      JLabel profileIcon = new JLabel(profileimage);
      profileIcon.setBounds(20, 20, 80, 80);
      profilePanel.add(profileIcon);
      
      JLabel profileName = new JLabel("User name");
      profileName.setFont(new Font("Aileron", Font.PLAIN, 18));
      profileName.setBounds(110, 30, 220, 20);
      profilePanel.add(profileName);
      
      JLabel profileId = new JLabel("User id");
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
      
      Booking[] data = {new Booking(1, "240190@via.dk", "E 201", null, null),
            new Booking(1, "240190@via.dk", "E 201", null, null),
            new Booking(1, "240190@via.dk", "E 201", null, null),
            new Booking(1, "240190@via.dk", "E 201", null, null),
            new Booking(1, "240190@via.dk", "E 201", null, null),
            new Booking(1, "240190@via.dk", "E 201", null, null),
            new Booking(1, "240190@via.dk", "E 201", null, null),
            new Booking(1, "240190@via.dk", "E 201", null, null),
            new Booking(1, "240190@via.dk", "E 201", null, null),
            new Booking(1, "240190@via.dk", "E 201", null, null),
            new Booking(1, "240190@via.dk", "E 201", null, null),
            new Booking(1, "240190@via.dk", "E 201", null, null),
            new Booking(1, "240190@via.dk", "E 201", null, null),
            new Booking(1, "240190@via.dk", "E 201", null, null),
            new Booking(1, "240190@via.dk", "E 201", null, null),
            new Booking(1, "240190@via.dk", "E 201", null, null),
            new Booking(1, "240190@via.dk", "E 201", null, null),
            new Booking(1, "240190@via.dk", "E 201", null, null),
            new Booking(1, "240190@via.dk", "E 201", null, null),
            new Booking(1, "240190@via.dk", "E 201", null, null),
            new Booking(1, "240190@via.dk", "E 201", null, null),
            new Booking(1, "240190@via.dk", "E 201", null, null),
            new Booking(1, "240190@via.dk", "E 201", null, null),
            new Booking(1, "240190@via.dk", "E 201", null, null),
            new Booking(1, "240190@via.dk", "E 201", null, null),
            new Booking(1, "240190@via.dk", "E 201", null, null)};
      JScrollPane listScroll = new JScrollPane();
      listScroll.setBounds(10, 40, 390, 250);
      JList upcomingList = new JList(data);
      upcomingList.setCellRenderer(new BookingCellRenderer());
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
         getParent().add(new MyBookingsPanel(), 0);
      }
      else if(e.getActionCommand().equals("New Booking")){
         System.out.println("Dashboard panel: New Booking");
         getParent().getComponent(0).setVisible(false);
         getParent().add(new BookingPanel(), 0);
      }
   }
}
