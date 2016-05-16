package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Frame extends JFrame{

   private JPanel contentPane;

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
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 800, 500);
      contentPane = new JPanel();
      setContentPane(contentPane);
   }

}
