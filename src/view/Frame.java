package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

   /**
    * Create the frame.
    */
   public Frame(){
      //Basics
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(0, 0, 800, 500);
      setTitle("Via Events");
      setResizable(false);
      
      //Main java panel
      BotLayer = new BotLayer();
      setContentPane(BotLayer);
   }

}
