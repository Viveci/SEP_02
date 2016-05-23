package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import model.Booking;

public class BookingCellRenderer extends JLabel implements ListCellRenderer {
   private static final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);

   public BookingCellRenderer() {
      setOpaque(true);
   }

   public Component getListCellRendererComponent(JList list, Object value,
       int index, boolean isSelected, boolean cellHasFocus) {
      setBounds(0, 0, 390, 40);
     Booking entry = (Booking) value;
     setText(entry.getBookingID()+".");
     if (isSelected) {
       setBackground(HIGHLIGHT_COLOR);
       setForeground(Color.white);
     } else {
       setBackground(Color.white);
       setForeground(Color.black);
     }
     return this;
   }
 }