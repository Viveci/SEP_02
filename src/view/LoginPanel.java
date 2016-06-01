package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import connection.Client;
import controller.ClientController;
import controller.Controller;
import model.model.Account;

public class LoginPanel extends JPanel implements ActionListener {

   //TextField
   private JTextField InputEmail;
   private JPasswordField InputPassword;
   
   //JLabeles
   private JLabel TextWelcome;
   private JLabel TextLogin;
   
   //JButtons
   private JButton ButtonLogin;
   private JButton ButtonRegister;
      
   public LoginPanel() {
      
      this.setBackground(Color.WHITE);
      this.setBounds(0, 50, 800, 450);
      this.setLayout(null);
      
      TextWelcome = new JLabel("Welcome to Via Events");
      TextWelcome.setBounds(100, 50, 210, 18);
      TextWelcome.setFont(new Font("Aileron Light", Font.PLAIN, 18));
      this.add(TextWelcome);
      
      TextLogin = new JLabel("Log in");
      TextLogin.setBounds(170, 101, 48, 23);
      TextLogin.setFont(new Font("Aileron Light", Font.PLAIN, 16));
      this.add(TextLogin);
      
      InputEmail = new JTextField();
      InputEmail.setToolTipText("Please enter your email");
      InputEmail.setText("Email");
      InputEmail.setBounds(100, 150, 210, 20);
      InputEmail.setFont(new Font("Aileron Light", Font.PLAIN, 12));
      this.add(InputEmail);
      InputEmail.setColumns(10);
      
      InputPassword = new JPasswordField();
      InputPassword.setToolTipText("Please enter your password");
      InputPassword.setText("Password");
      InputPassword.setBounds(100, 200, 210, 20);
      InputPassword.setFont(new Font("Aileron Light", Font.PLAIN, 12));
      this.add(InputPassword);
      InputPassword.setColumns(10);
      
      ButtonLogin = new JButton("Login");
      ButtonLogin.setFont(new Font("Aileron Light", Font.PLAIN, 16));
      ButtonLogin.setBounds(210, 244, 100, 23);
      this.add(ButtonLogin);
      
      ButtonLogin.addActionListener(this);
      
      ButtonRegister = new JButton("Register");
      ButtonRegister.setFont(new Font("Aileron Light", Font.PLAIN, 16));
      ButtonRegister.setBounds(100, 244, 100, 23);
      add(ButtonRegister);
      
      ButtonRegister.addActionListener(this);
            
   }

   @Override
   public void actionPerformed(ActionEvent arg0) {
      //Login option
      if(arg0.getActionCommand().equals("Login")){
         String msg = "auth:" + getInputEmail().getText()+":"+getInputPassword().getText(); 
         if(ClientFrame.cntrl.auth(msg)){
            getParent().getComponent(0).setVisible(false);
            Account tempAccount = ClientFrame.cntrl.getAccount("dash:" + getInputEmail().getText());
            Dashboard db = new Dashboard(tempAccount);
            db.setAcc(tempAccount);
            getParent().add(db,0);
         }
         else{
            JOptionPane.showMessageDialog(null,"There was an error during authenticaton process","Authentication",JOptionPane.WARNING_MESSAGE);
         }
         
      //Register options   
      }
      else if(arg0.getActionCommand().equals("Register")){
         System.out.println("Login panel: Proceding to register panel");
         getParent().getComponent(0).setVisible(false);
         getParent().add(new RegisterPanel(),0);
      }
   }
   
   public JTextField getInputEmail() {
      return InputEmail;
   }
   public JPasswordField getInputPassword() {
      return InputPassword;
   }
   
}
