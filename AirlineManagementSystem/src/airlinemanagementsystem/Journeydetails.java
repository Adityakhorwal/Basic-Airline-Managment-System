package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;

public class Journeydetails extends JFrame implements ActionListener{
    
    JTextField pnr;
    JButton show;
    JTable table;
    
    public Journeydetails()
    {
        setLayout(null);
        
        JLabel lbpnr=new JLabel("PNRNo:-");
        add(lbpnr);
        lbpnr.setFont(new Font("System",Font.BOLD,18));
        lbpnr.setBounds(30,30,100,30);
        
        pnr = new JTextField();
        add(pnr);
        pnr.setBounds(160,30,150,30);
        
        show = new JButton("Show");
        add(show);
        show.addActionListener(this);
        show.setBackground(Color.BLACK);
        show.setForeground(Color.WHITE);
        show.setBounds(320,30,100,30);
        
        table=new JTable();
        table.setBounds(0,100,1000,200);
        add(table);
        
        JScrollPane scroll=new JScrollPane(table);
        scroll.setBounds(0,100,1000,200);
        add(scroll);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(260,50,1000,600);
        getContentPane().setBackground(Color.white);
    }
    
    public void actionPerformed(ActionEvent e1)
    {
       if(e1.getSource() == show)
       {
        try{
            Conn c=new Conn();
            String query="select * from ticket where pnrno='"+pnr.getText()+"'";
            ResultSet rs=c.s.executeQuery(query);
            if(!rs.isBeforeFirst()){
                JOptionPane.showMessageDialog(null, "No Flight Found");
                return;
            }
             table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            System.out.println(e);
        }
       }
    }
    
    public static void main(String []args)
    {
        new Journeydetails();
    }
}
