package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;

public class Cacellation extends JFrame implements ActionListener{
    
    JTextField pnr;
    JButton fetchdetail,cancel;
    JLabel lbname,lbcancel,lbfcode,lbdate; 
    
    public Cacellation()
    {
        setLayout(null);
        
        JLabel heading=new JLabel("Cacellation No:");
        add(heading);
        heading.setForeground(Color.blue);
        heading.setFont(new Font("ralway",Font.PLAIN,40));
        heading.setBounds(350,20,500,50);
        
        JLabel lbpnr=new JLabel("PNR Number:");
        add(lbpnr);
        lbpnr.setFont(new Font("System",Font.BOLD,18));
        lbpnr.setBounds(50,100,200,30);
        
        pnr =new JTextField();
        add(pnr);
        pnr.setBounds(220,100,150,30);
        
        fetchdetail =new JButton("Fetch Details");
        add(fetchdetail);
        fetchdetail.addActionListener(this);
        fetchdetail.setBackground(Color.black);
        fetchdetail.setForeground(Color.white);
        fetchdetail.setBounds(380,100,140,30);
        
        JLabel name=new JLabel("Name:");
        add(name);
        name.setFont(new Font("System",Font.BOLD,18));
        name.setBounds(50,170,200,30);
        
        lbname=new JLabel();
        add(lbname);
        lbname.setFont(new Font("System",Font.BOLD,18));
        lbname.setBounds(220,170,200,30);
        
        JLabel cancell=new JLabel("Cancellation:");
        add(cancell);
        cancell.setFont(new Font("System",Font.BOLD,18));
        cancell.setBounds(50,240,200,30);
        
        Random r=new Random();
        
        lbcancel=new JLabel(String.valueOf(r.nextInt(10000)));
        add(lbcancel);
        lbcancel.setFont(new Font("System",Font.BOLD,18));
        lbcancel.setBounds(220,240,200,30);
        
        JLabel fcode=new JLabel("Flight Code:");
        add(fcode);
        fcode.setFont(new Font("System",Font.BOLD,18));
        fcode.setBounds(50,310,200,30);
        
        lbfcode=new JLabel();
        add(lbfcode);
        lbfcode.setFont(new Font("System",Font.BOLD,18));
        lbfcode.setBounds(220,310,200,30);
        
        JLabel date=new JLabel("Date:");
        add(date);
        date.setFont(new Font("System",Font.BOLD,18));
        date.setBounds(50,380,200,30);
        
        lbdate=new JLabel();
        add(lbdate);
        lbdate.setFont(new Font("System",Font.BOLD,18));
        lbdate.setBounds(220,380,200,30);
        
        cancel =new JButton("Cancel");
        add(cancel);
        cancel.addActionListener(this);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setBounds(250,430,140,40);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/cancel.jpg"));
        Image i2=i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        
        JLabel image=new JLabel(i3);
        add(image);
        image.setBounds(490,150,300,300);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(270,50,900,600);
        getContentPane().setBackground(Color.white);
    }
    
    public void actionPerformed(ActionEvent e1)
    {
        if(e1.getSource() == fetchdetail)
        {
            try{
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery("select * from ticket where pnrno = '"+pnr.getText()+"'");
                if(rs.next())
                {
                    lbname.setText(rs.getString("p_name"));
                    lbdate.setText(rs.getString("date"));
                    lbfcode.setText(rs.getString("F_code"));
                }else{
                    JOptionPane.showMessageDialog(null, "No Passenger Found");
                    return;
                }
                
            }
            catch(Exception e){}
        }
        else if(e1.getSource()== cancel)
        {
            String name=lbname.getText();
            String cancelno=lbcancel.getText();
            String date=lbdate.getText();
            String fcode=lbfcode.getText();
            String pnrno=pnr.getText();
            
            try{
                Conn c=new Conn();
                String query ="insert into cancellation values('"+cancelno+"','"+pnrno+"','"+fcode+"','"+name+"','"+date+"')";
                c.s.executeUpdate(query);
                c.s.executeUpdate("delete from ticket where pnrno = '"+pnrno+"'");
                JOptionPane.showMessageDialog(null,"Ticket Cancell");
                setVisible(false);
                
            }
            catch(Exception e){}
            
            
        }
    }
    
    public static void main(String []rags)
    {
        new Cacellation();
    }
}
