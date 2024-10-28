package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Home extends JFrame implements ActionListener{
 
    public Home()
    {
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2=i1.getImage().getScaledInstance(1600, 800, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        
        JLabel image =new  JLabel(i3);
        add(image);
        image.setBounds(0,0,1600,800);
        
        JLabel heading=new JLabel("Air India Welcomes you");
        image.add(heading);
        heading.setBounds(500,30,700,100);
        heading.setFont(new Font("ralway",Font.BOLD,36));
        heading.setForeground(Color.blue);
        
        JMenuBar menubar=new JMenuBar();
        setJMenuBar(menubar);
        
        JMenu details=new JMenu("Details");
        menubar.add(details);
        
        JMenuItem flightdetails=new JMenuItem("Flight Details");
        flightdetails.addActionListener(this);
        details.add(flightdetails);
        
        JMenuItem custmordetails=new JMenuItem("Add Custmor Details");
        custmordetails.addActionListener(this);
        details.add(custmordetails);
        
        JMenuItem bookflight=new JMenuItem("Book Flight");
        bookflight.addActionListener(this);
        details.add(bookflight);
        
        JMenuItem jurnydetails=new JMenuItem("Journey Details");
        jurnydetails.addActionListener(this);
        details.add(jurnydetails);
        
        JMenuItem ticetcanceliation=new JMenuItem("Cancel Ticket");
        ticetcanceliation.addActionListener(this);
        details.add(ticetcanceliation);
        
        JMenu Ticket=new JMenu("Ticket");
        menubar.add(Ticket);
        
        JMenuItem baordinpass=new JMenuItem("Boarding Pass");
        baordinpass.addActionListener(this);
        Ticket.add(baordinpass);
        
        
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent e1)
    {
        String text=e1.getActionCommand();
        
        if(text.equals("Flight Details"))
        {
            new Flightinfo();
        }else if(text.equals("Add Custmor Details"))
        {
            new Addcustomer();
        }else if(text.equals("Book Flight"))
        {
            new Bookflight();
        }else if(text.equals("Journey Details"))
        {
            new Journeydetails();
        }else if(text.equals("Cancel Ticket"))
        {
            new Cacellation();
        }else if(text.equals("Boarding Pass"))
        {
            new Boardingpass();
        }
    }
    
    public static void main(String []args)
    {
        new Home();
    }
}
