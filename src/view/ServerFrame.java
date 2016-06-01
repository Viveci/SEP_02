package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import connection.MultiThreadServer;
import controller.ClientController;
import controller.Controller;
import controller.ServerController;

import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;

public class ServerFrame extends JFrame implements View {

   private JPanel contentPane;
   private JPanel TopBar;
   private JLabel Title;
   private JTextPane SystemMessages;
   
   public static ServerController cntrl;

   public ServerFrame() {
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(0, 0, 800, 500);
      setTitle("Via Events: Server");
      setResizable(false);
      getContentPane().setLayout(null);
      
      TopBar = new JPanel();
      TopBar.setBounds(0, 0, 800, 50);
      TopBar.setBackground(Color.decode("#282828"));
      getContentPane().add(TopBar);
      TopBar.setLayout(null);
      
      Title = new JLabel("ViaEvents");
      Title.setForeground(Color.WHITE);
      Title.setFont(new Font("Calibri", Font.PLAIN, 20));
      Title.setBounds(20, 15, 100, 20);
      TopBar.add(Title);
      
      SystemMessages = new JTextPane();
      SystemMessages.setBounds(0, 50, 800, 421);
      getContentPane().add(SystemMessages);
      
   }

   @Override
   public void update(Observable arg0, Object arg1) {
      String s = SystemMessages.getText();
      SystemMessages.setText(s + "\n" + (String) arg1);
   }

   @Override
   public void start(Controller controller) {
      try {
         ServerFrame frame = new ServerFrame();
         this.cntrl = (ServerController) controller;
         frame.setVisible(true);
      }
      catch (Exception e) {
         e.printStackTrace();
      }
   }
}
