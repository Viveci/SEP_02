package view;

import java.awt.Color;
import java.awt.DefaultFocusTraversalPolicy;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JEditorPane;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.text.DateFormatter;

import com.toedter.calendar.JCalendar;

import controller.clientController;

import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;

public class BookingPanel extends JPanel implements ActionListener {
   
   private JPanel EventDetails;
   private JTextField DetailsName;
   private JEditorPane DetailsDetails;
   private JLabel DetailsTypeLabel;
   private JComboBox DetailsEventType;
   private JPanel EventEvent;
   private JPanel EventMeeting;
   private JPanel EventCalendar;
   private JPanel EventButtons;
   private JButton btnBack;
   private JButton btnSave;
   private JLabel DetailsFaciltyLabel;
   private JComboBox DetailsFaciltyCombo;
   private JLabel EventSignupDeadLineLabel;
   private JLabel EventCapacity;
   private JSpinner EventCapacitySpinner;
   private JFormattedTextField EventDeadlineDate;
   private JCalendar calendar;
   private JLabel CalendarDateLabel;
   private JLabel CalendarHoursLabel;
   private JSpinner EventFrom;
   private JSpinner EventTo;
   
   private clientController controller;

   public BookingPanel(){
      this.setBackground(Color.WHITE);
      this.setBounds(0, 50, 800, 420);
      setLayout(null);
           
      EventDetails = new JPanel();
      EventDetails.setBounds(10, 10, 385, 400);
      add(EventDetails);
      EventDetails.setLayout(null);
      
      DetailsName = new JTextField("Event name");
      DetailsName.setFont(new Font("Aileron", Font.PLAIN, 18));
      DetailsName.setBounds(10, 10, 365, 25);
      EventDetails.add(DetailsName);
      
      DetailsDetails = new JEditorPane();
      DetailsDetails.setText("content contetnt");
      DetailsDetails.setBounds(10, 45, 365, 150);
      EventDetails.add(DetailsDetails);
      
      DetailsTypeLabel = new JLabel("Booking type");
      DetailsTypeLabel.setFont(new Font("Aileron", Font.PLAIN, 14));
      DetailsTypeLabel.setBounds(10, 205, 100, 25);
      EventDetails.add(DetailsTypeLabel);
      
      String[] types = {"Event","Meeting"};
      DetailsEventType = new JComboBox(types);
      DetailsEventType.setBounds(165, 210, 210, 20);
      EventDetails.add(DetailsEventType);
      DetailsEventType.addActionListener(this);
      
      //Combo box option panels
      EventEvent = new JPanel();
      EventEvent.setBounds(10, 270, 365, 120);
      EventDetails.add(EventEvent);
      EventEvent.setLayout(null);
      
      EventSignupDeadLineLabel = new JLabel("Signup deadline");
      EventSignupDeadLineLabel.setFont(new Font("Aileron", Font.PLAIN, 14));
      EventSignupDeadLineLabel.setBounds(0, 35, 100, 25);
      EventEvent.add(EventSignupDeadLineLabel);
      
      EventCapacity = new JLabel("Event capacity");
      EventCapacity.setFont(new Font("Aileron", Font.PLAIN, 14));
      EventCapacity.setBounds(0, 0, 100, 25);
      EventEvent.add(EventCapacity);
      
      EventCapacitySpinner = new JSpinner();
      EventCapacitySpinner.setBounds(155, 2, 210, 20);
      EventEvent.add(EventCapacitySpinner);
      
      DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
      EventDeadlineDate = new JFormattedTextField(format);
      EventDeadlineDate.setHorizontalAlignment(SwingConstants.RIGHT);
      EventDeadlineDate.setText("DD/MM/YYYY");
      EventDeadlineDate.setBounds(155, 39, 210, 20);
      EventEvent.add(EventDeadlineDate);
      EventDeadlineDate.setColumns(10);
      
      EventMeeting = new JPanel();
      EventMeeting.setBounds(10, 270, 365, 120);
      EventDetails.add(EventMeeting);
      
      DetailsFaciltyLabel = new JLabel("Facility");
      DetailsFaciltyLabel.setFont(new Font("Aileron", Font.PLAIN, 14));
      DetailsFaciltyLabel.setBounds(10, 234, 100, 25);
      EventDetails.add(DetailsFaciltyLabel);
      
      String[] faciliteis = {"E201","E202","G201"};
      DetailsFaciltyCombo = new JComboBox(faciliteis);
      DetailsFaciltyCombo.setBounds(165, 239, 210, 20);
      EventDetails.add(DetailsFaciltyCombo);
      
      
      EventCalendar = new JPanel();
      EventCalendar.setBounds(405, 10, 375, 300);
      add(EventCalendar);
      EventCalendar.setLayout(null);
      
      calendar = new JCalendar();
      calendar.setBackground(Color.WHITE);
      calendar.setBounds(160, 10, 205, 150);
      calendar.setBorder(null);
      GridLayout gridLayout = (GridLayout) calendar.getDayChooser().getDayPanel().getLayout();
      calendar.setPreferredSize(new Dimension(150,150));
      EventCalendar.add(calendar);
      
      CalendarDateLabel = new JLabel("Date");
      CalendarDateLabel.setFont(new Font("Aileron", Font.PLAIN, 14));
      CalendarDateLabel.setBounds(10, 10, 100, 25);
      EventCalendar.add(CalendarDateLabel);
      
      CalendarHoursLabel = new JLabel("Time frame");
      CalendarHoursLabel.setFont(new Font("Aileron", Font.PLAIN, 14));
      CalendarHoursLabel.setBounds(10, 170, 100, 25);
      EventCalendar.add(CalendarHoursLabel);
      
      EventFrom = new JSpinner();
      EventFrom.setBounds(160, 172, 100, 20);
      EventCalendar.add(EventFrom);
      
      EventTo = new JSpinner();
      EventTo.setBounds(265, 172, 100, 20);
      EventCalendar.add(EventTo);
      
      //Spinner things
      SpinnerDateModel model1 = new SpinnerDateModel();
      model1.setCalendarField(Calendar.MINUTE);
      
      SpinnerDateModel model2 = new SpinnerDateModel();
      model2.setCalendarField(Calendar.MINUTE);
      
      EventFrom.setModel(model1);
      EventFrom.setEditor(new JSpinner.DateEditor(EventFrom, "HH:mm"));
      EventTo.setModel(model2);
      EventTo.setEditor(new JSpinner.DateEditor(EventTo, "HH:mm"));
      
      EventButtons = new JPanel();
      EventButtons.setBounds(405, 320, 375, 90);
      add(EventButtons);
      EventButtons.setLayout(null);
      
      btnBack = new JButton("Back");
      btnBack.setBounds(192, 10, 172, 70);
      EventButtons.add(btnBack);
      btnBack.addActionListener(this);
      
      btnSave = new JButton("Save");
      btnSave.setBounds(10, 10, 172, 70);
      EventButtons.add(btnSave);
      btnSave.addActionListener(this);
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
      
      if(e.getSource().equals(DetailsEventType)){
         
         DetailsEventType = (JComboBox)e.getSource();
         String eventtype = (String)DetailsEventType.getSelectedItem();
         
         if(eventtype.equals("Meeting")){
            EventEvent.setVisible(false);
            EventMeeting.setVisible(true);
         }
         else{
            EventMeeting.setVisible(false);
            EventEvent.setVisible(true);
         }
      }
      
      else if(e.getActionCommand().equals("Back")){
         System.out.println("Booking panel: back");
         getParent().getComponent(0).setVisible(false);
         getParent().add(new Dashboard(), 0);
      }
      else if(e.getActionCommand().equals("Save")){
         System.out.println("Booking panel: save");
         getParent().getComponent(0).setVisible(false);
         getParent().add(new Dashboard(), 0);
      }
   }
}
