package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;

import model.Booking;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JTextField;

import com.toedter.calendar.JCalendar;

import javax.swing.JComboBox;

public class MyBookingsPanel extends JPanel implements ActionListener {
   
   private JPanel BookingPanel;
   private JScrollPane scrollPane;
   private JPanel FilterPanel;
   private JPanel ButtonPanel;
   private JButton btnBack;
   private JList upcomingList;
   private JLabel FilterNameLabel;
   private JTextField FilterNameInput;
   private JLabel FilterTypeLabel;
   private JComboBox FilterTypeCombo;
   private JCalendar calendar;
   private JLabel lblDate;

   public MyBookingsPanel(){
      this.setBackground(Color.WHITE);
      this.setBounds(0, 50, 800, 420);
      setLayout(null);
      
      BookingPanel = new JPanel();
      BookingPanel.setBounds(10, 10, 385, 400);
      add(BookingPanel);
      BookingPanel.setLayout(null);
      
      scrollPane = new JScrollPane();
      scrollPane.setBounds(10, 10, 365, 380);
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
      upcomingList = new JList(data);
      upcomingList.setCellRenderer(new BookingCellRenderer());
      scrollPane.setViewportView(upcomingList);
      BookingPanel.add(scrollPane);
      
      FilterPanel = new JPanel();
      FilterPanel.setBounds(405, 10, 375, 300);
      add(FilterPanel);
      FilterPanel.setLayout(null);
      
      calendar = new JCalendar();
      calendar.setBounds(120, 80, 245, 150);
      calendar.setBorder(null);
      GridLayout gridLayout = (GridLayout) calendar.getDayChooser().getDayPanel().getLayout();
      calendar.setPreferredSize(new Dimension(150,150));
      FilterPanel.add(calendar);
      
      FilterNameLabel = new JLabel("Filter by name");
      FilterNameLabel.setFont(new Font("Aileron", Font.PLAIN, 14));
      FilterNameLabel.setBounds(10, 10, 100, 25);
      FilterPanel.add(FilterNameLabel);
      
      FilterNameInput = new JTextField();
      FilterNameInput.setBounds(120, 12, 245, 20);
      FilterPanel.add(FilterNameInput);
      FilterNameInput.setColumns(10);
      
      FilterTypeLabel = new JLabel("Filter by type");
      FilterTypeLabel.setFont(new Font("Aileron", Font.PLAIN, 14));
      FilterTypeLabel.setBounds(10, 45, 100, 25);
      FilterPanel.add(FilterTypeLabel);
      
      String[] types = {"Event","Meeting"};
      FilterTypeCombo = new JComboBox(types);
      FilterTypeCombo.setBounds(120, 47, 245, 20);
      FilterPanel.add(FilterTypeCombo);
      
      lblDate = new JLabel("Filter by date");
      lblDate.setFont(new Font("Aileron", Font.PLAIN, 14));
      lblDate.setBounds(10, 80, 100, 25);
      FilterPanel.add(lblDate);
      
      ButtonPanel = new JPanel();
      ButtonPanel.setBounds(405, 320, 375, 90);
      add(ButtonPanel);
      ButtonPanel.setLayout(null);
      
      btnBack = new JButton("Back");
      btnBack.setBounds(245, 10, 120, 70);
      ButtonPanel.add(btnBack);
      btnBack.addActionListener(this);
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
      if(e.getActionCommand().equals("Back")){
         System.out.println("Booking panel: back");
         getParent().getComponent(0).setVisible(false);
         getParent().add(new Dashboard(), 0);
      }
   }
}
