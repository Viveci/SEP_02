package view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BotLayer extends JPanel {
   
   Color bcg;
   int x, y;
   
   //TextField
   private JTextField InputEmail;
   private JTextField InputPassword;
   
   //JLabeles
   private JLabel TextWelcome;
   private JLabel TextLogin;
   
   public BotLayer() {
      bcg =  Color.decode("#efefef");
      
      setBounds(0, 0, 800, 500);
      
      this.setBackground(bcg);
      setLayout(null);
      
      //---------------------------------------Form panel----------------------------------------------------------
      JPanel form = new JPanel();
      form.setBackground(Color.WHITE);
      form.setBounds(200, 75, 400, 300);
      add(form);
      form.setLayout(null);
      
      TextWelcome = new JLabel("Welcome to Via Events");
      TextWelcome.setBounds(100, 50, 200, 18);
      TextWelcome.setFont(new Font("Aileron Light", Font.PLAIN, 18));
      form.add(TextWelcome);
      
      TextLogin = new JLabel("Log in");
      TextLogin.setBounds(170, 101, 48, 23);
      TextLogin.setFont(new Font("Aileron Light", Font.PLAIN, 16));
      form.add(TextLogin);
      
      InputEmail = new JTextField();
      InputEmail.setToolTipText("Please enter your email");
      InputEmail.setText("Email");
      InputEmail.setBounds(100, 150, 200, 20);
      InputEmail.setFont(new Font("Aileron Light", Font.PLAIN, 12));
      form.add(InputEmail);
      InputEmail.setColumns(10);
      
      InputPassword = new JTextField();
      InputPassword.setToolTipText("Please enter your password");
      InputPassword.setText("Password");
      InputPassword.setBounds(100, 200, 200, 20);
      InputPassword.setFont(new Font("Aileron Light", Font.PLAIN, 12));
      form.add(InputPassword);
      InputPassword.setColumns(10);
      
      JButton ButtonLogin = new JButton("Login");
      ButtonLogin.setFont(new Font("Aileron Light", Font.PLAIN, 16));
      ButtonLogin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
         }
      });
      ButtonLogin.setBounds(100, 241, 200, 23);
      form.add(ButtonLogin);
      
   }
}
