package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
   
    JTextField tfusername;
    JPasswordField tfpassword;
    JButton reset,submit,close;
    
    Login()
    {
        setLayout(null);
        
        JLabel lblusername=new JLabel("Username:");
        add(lblusername);
        lblusername.setBounds(50,30,100,50);
        lblusername.setFont(new Font("System",Font.BOLD,15));
        
        tfusername=new JTextField();
        tfusername.setBounds(180, 42, 190, 25);
        add(tfusername);
        
        JLabel lblpassword=new JLabel("Password:");
        add(lblpassword);
        lblpassword.setBounds(50,80,100,50);
        lblpassword.setFont(new Font("System",Font.BOLD,15));
        
        tfpassword=new JPasswordField();
        tfpassword.setBounds(180, 92, 190, 25);
        add(tfpassword);
        
        submit =new JButton("Submit");
        add(submit);
        submit.addActionListener(this);
        submit.setBounds(80,150,130,25);
        
        reset =new JButton("Reset");
        add(reset);
        reset.addActionListener(this);
        reset.setBounds(240,150,130,25);
        
        close =new JButton("Close");
        add(close);
        close.addActionListener(this);
        close.setBounds(160,190,130,25);
              
        setVisible(true);
        getContentPane().setBackground(Color.white);
        setBounds(450,220,500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==reset)
        {
            tfusername.setText("");
            tfpassword.setText("");
        }else if(e.getSource() == close)
        {
            System.exit(0);
        }else if(e.getSource()== submit)
        {
            String username=tfusername.getText();
            String password=tfpassword.getText();
             
            try{
                Conn c=new Conn();
                String query="Select * from login where username='"+username+"' and password='"+password+"' ";
                ResultSet r=c.s.executeQuery(query);
                if(r.next())
                {
                    new Home().setVisible(true);
                    setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Username or Password are Invalid");
                }
            }
            catch(Exception e1)
            {
                System.out.println(e1);
            }
        }
    }
    
    public static void main(String []args)
    {
        new Login();
    }
}
