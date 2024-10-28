package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Addcustomer extends JFrame implements ActionListener{
    
    JTextField tfname,tfadar,tfnational,tfphone,tfaddress;
    JRadioButton male,female;
    JButton save;
    
    public Addcustomer()
    {
        setLayout(null);
        
        JLabel heading=new JLabel("ADD CUSTOMER DETAILS");
        add(heading);
        heading.setBounds(220,30,4000,30);
        heading.setForeground(Color.blue);
        heading.setFont(new Font("System",Font.PLAIN,36));
        
        JLabel lblname=new JLabel("Name:");
        add(lblname);
        lblname.setBounds(50,120,100,30);
        lblname.setFont(new Font("System",Font.BOLD,20));
        
        tfname=new JTextField();
        add(tfname);
        tfname.setBounds(240,120,200,30);
        
        JLabel lblnational=new JLabel("Nationality:");
        add(lblnational);
        lblnational.setBounds(50,160,200,30);
        lblnational.setFont(new Font("System",Font.BOLD,20));
        
        tfnational=new JTextField();
        add(tfnational);
        tfnational.setBounds(240,160,200,30);
        
        JLabel lbladar=new JLabel("Adar Number:");
        add(lbladar);
        lbladar.setBounds(50,200,200,30);
        lbladar.setFont(new Font("System",Font.BOLD,20));
        
        tfadar=new JTextField();
        add(tfadar);
        tfadar.setBounds(240,200,200,30);
        
        JLabel lbladdress=new JLabel("Address:");
        add(lbladdress);
        lbladdress.setBounds(50,240,200,30);
        lbladdress.setFont(new Font("System",Font.BOLD,20));
        
        tfaddress=new JTextField();
        add(tfaddress);
        tfaddress.setBounds(240,240,200,30);
        
        JLabel gender=new JLabel("Gender:");
        add(gender);
        gender.setBounds(50,300,200,30);
        gender.setFont(new Font("System",Font.BOLD,20));
        
        male=new JRadioButton("Male");
        add(male);
        male.setBackground(Color.white);
        male.setBounds(240,300,100,30);
        
        female=new JRadioButton("Female");
        add(female);
        female.setBackground(Color.white);
        female.setBounds(340,300,100,30);
        
        ButtonGroup gendergroup=new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        JLabel lblphone=new JLabel("Phone:");
        add(lblphone);
        lblphone.setBounds(50,350,200,30);
        lblphone.setFont(new Font("System",Font.BOLD,20));
        
        tfphone=new JTextField();
        add(tfphone);
        tfphone.setBounds(240,350,200,30);
        
        save=new JButton("Save");
        add(save);
        save.addActionListener(this);
        save.setBounds(240,400,200,40);
        save.setBackground(Color.BLACK);
        save.setForeground(Color.white);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/emp.png"));
        Image i2=i1.getImage().getScaledInstance(300, 350, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        
        JLabel image=new JLabel(i3);
        add(image);
        image.setBounds(500, 100, 300, 350);
        
        setVisible(true);
        setBounds(300,50,900,600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.white);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==save)
        {
            String name=tfname.getText();
            String national=tfnational.getText();
            String adarno=tfadar.getText();
            String address=tfaddress.getText();
            String phoneno=tfphone.getText();
            String gender="";
            
            if(male.isSelected())
            {
                gender="Male";
            }else if(female.isSelected())
            {
                gender="Female";
            }
            
            try{
                Conn c=new Conn();
                String query="insert into customer values('"+name+"','"+national+"','"+adarno+"','"+address+"','"+gender+"','"+phoneno+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
                setVisible(false);
            }
            catch(Exception e1)
            {
                System.out.println(e1);
            }
            
        }
    }
    
    public static void main(String []rags)
    {
        new Addcustomer();
    }
    
}
