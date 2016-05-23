package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class Frame extends JFrame{

   private JPanel BotLayer;

   public static void main(String[] args){
      EventQueue.invokeLater(new Runnable(){
         public void run(){
            try{
               Frame frame = new Frame();
               frame.setVisible(true);
            }
            catch (Exception e){
               e.printStackTrace();
            }
         }
      });
   }

   public Frame(){
      //Basics
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(0, 0, 800, 500);
      setTitle("Via Events");
      setResizable(false);
      
      LoginPanel login = new LoginPanel();
      Color bcg =  Color.decode("#efefef");
      setBounds(0, 0, 800, 500);
      this.setBackground(bcg);
      getContentPane().setLayout(null);
      
      JPanel TopBar = new JPanel();
      TopBar.setBackground(Color.decode("#282828"));
      TopBar.setBounds(0, 0, 800, 50);
      getContentPane().add(TopBar);
      TopBar.setLayout(null);
      
      JLabel Title = new JLabel("ViaEvents");
      Title.setForeground(Color.WHITE);
      Title.setFont(new Font("Calibri", Font.PLAIN, 20));
      Title.setBounds(20, 15, 100, 20);
      TopBar.add(Title);
      
      LoginPanel lp = new LoginPanel();
      add(lp,0);
   }
}
