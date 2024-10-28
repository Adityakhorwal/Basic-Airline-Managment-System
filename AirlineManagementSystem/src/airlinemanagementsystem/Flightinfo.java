package airlinemanagementsystem;

import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class Flightinfo extends JFrame {
    
    public Flightinfo()
    {
        JTable table=new JTable();
        
        try{
            Conn c=new Conn();
            ResultSet r=c.s.executeQuery("Select * from flightinfo");
            table.setModel(DbUtils.resultSetToTableModel(r));
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        table.setBounds(0,0,800,500);
        add(table);
        
        JScrollPane scroll=new JScrollPane(table);
        scroll.setBounds(0,0,800,500);
        add(scroll);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(350,120,800,500);
    }
    
    public static void main(String []args){
        new Flightinfo();
    }
}
