package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connection.Client;
import controller.ClientController;
import controller.Controller;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.util.Observable;

import javax.swing.ImageIcon;

public class ClientFrame extends JFrame implements View {

   private JPanel BotLayer;
   private LoginPanel login;
   private JPanel TopBar;
   private JLabel Title;
   
   public static ClientController cntrl;

   public ClientFrame() {

      // Basics
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(0, 0, 800, 500);
      setTitle("Via Events");
      setResizable(false);

      login = new LoginPanel();
      Color bcg = Color.decode("#efefef");
      setBounds(0, 0, 800, 500);
      this.setBackground(bcg);
      getContentPane().setLayout(null);
      getContentPane().add(login, 0);

      TopBar = new JPanel();
      TopBar.setBackground(Color.decode("#282828"));
      TopBar.setBounds(0, 0, 800, 50);
      getContentPane().add(TopBar);
      TopBar.setLayout(null);

      Title = new JLabel("");
      Image logo = new ImageIcon("C:\\Dev\\JGWS\\SEP_02\\logo.png").getImage()
            .getScaledInstance(150, 35, Image.SCALE_SMOOTH);
      Title.setIcon(new ImageIcon(logo));
      Title.setForeground(Color.WHITE);
      Title.setFont(new Font("Calibri", Font.PLAIN, 20));
      Title.setBounds(20, 5, 200, 40);
      TopBar.add(Title);

   }

   @Override
   public void update(Observable o, Object arg) {
      
   }

   @Override
   public void start(Controller controller) {
      try {
         ClientFrame frame = new ClientFrame();
         this.cntrl = (ClientController) controller;
         frame.setVisible(true);
      }
      catch (Exception e) {
         e.printStackTrace();
      }
   }

}
