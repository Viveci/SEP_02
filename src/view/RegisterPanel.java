package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;

public class RegisterPanel extends JPanel implements ActionListener{

   //TextField
   private JTextField InputEmail;
   private JPasswordField InputPassword;
   
   //JLabeles
   private JLabel TextWelcome;
   private JTextField UserName;
   
   public RegisterPanel() {
      
      this.setBackground(Color.WHITE);
      this.setBounds(0, 50, 800, 450);
      this.setLayout(null);
      
      TextWelcome = new JLabel("Register");
      TextWelcome.setBounds(100, 50, 200, 20);
      TextWelcome.setFont(new Font("Aileron Light", Font.PLAIN, 18));
      this.add(TextWelcome);
      
      InputEmail = new JTextField();
      InputEmail.setToolTipText("Please enter your email");
      InputEmail.setText("Email");
      InputEmail.setBounds(100, 135, 210, 20);
      InputEmail.setFont(new Font("Aileron Light", Font.PLAIN, 12));
      this.add(InputEmail);
      InputEmail.setColumns(10);
      
      InputPassword = new JPasswordField();
      InputPassword.setToolTipText("Please enter your password");
      InputPassword.setText("Password");
      InputPassword.setBounds(100, 170, 210, 20);
      InputPassword.setFont(new Font("Aileron Light", Font.PLAIN, 12));
      this.add(InputPassword);
      InputPassword.setColumns(10);
      
      JButton ButtonRegister = new JButton("Register");
      ButtonRegister.setFont(new Font("Aileron Light", Font.PLAIN, 16));
      ButtonRegister.setBounds(210, 244, 100, 23);
      this.add(ButtonRegister);
      ButtonRegister.addActionListener(this);
      
      
      JButton ButtonBack = new JButton("Back");
      ButtonBack.setFont(new Font("Aileron Light", Font.PLAIN, 16));
      ButtonBack.setBounds(100, 244, 100, 23);
      add(ButtonBack);
      ButtonBack.addActionListener(this);
      
      UserName = new JTextField();
      UserName.setToolTipText("Please enter your full name");
      UserName.setText("Full name");
      UserName.setFont(new Font("Aileron Light", Font.PLAIN, 12));
      UserName.setColumns(10);
      UserName.setBounds(100, 100, 210, 20);
      add(UserName);
      
      String[] userTypes = {"Student","Teacher","Event organiser"};
      JComboBox<String> UserType = new JComboBox(userTypes);
      UserType.setBounds(100, 205, 210, 20);
      add(UserType);
      
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      if(e.getActionCommand().equals("Back")){
         System.out.println("Register panel: Back");
         getParent().getComponent(0).setVisible(false);
         getParent().add(new LoginPanel(),0);
      }
      else if(e.getActionCommand().equals("Register")){
         System.out.println("Register panel: Register");
         getParent().getComponent(0).setVisible(false);
         getParent().add(new Dashboard(),0);
      }
   }
}
