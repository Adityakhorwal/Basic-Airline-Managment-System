package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;


public class Bookflight extends JFrame implements ActionListener {
    
    JTextField tfadhar;
    JDateChooser cdate;
    JLabel lbname,lbaddress,lbgender,lbnational,lbfname,lbfcode;
    JButton fetch,fetchflight,book;
    Choice cfrom,cto;
    
    public Bookflight()
    {
        setLayout(null);
        
        
        JLabel heading=new JLabel("Book Ticket"); 
        add(heading);
        heading.setFont(new Font("System",Font.PLAIN,36));
        heading.setForeground(Color.BLUE);
        heading.setBounds(400,20,400,50);
        
        JLabel adhar=new JLabel("Aadhaar no:");
        add(adhar);
        adhar.setFont(new Font("Ralway",Font.BOLD,18));
        adhar.setBounds(50,70,200,50);
        
        tfadhar = new JTextField();
        add(tfadhar);
        tfadhar.setBounds(230,80,170,30);
        
        fetch = new JButton("Fecth User");
        add(fetch);
        fetch.addActionListener(this);
        fetch.setBackground(Color.BLACK);
        fetch.setForeground(Color.white);
        fetch.setBounds(410,80,130,30);
        
        JLabel name=new JLabel("Name:");
        add(name);
        name.setFont(new Font("Ralway",Font.BOLD,18));
        name.setBounds(50,110,200,50);
        
        lbname =new JLabel();
        add(lbname);
        lbname.setFont(new Font("Ralway",Font.BOLD,18));
        lbname.setBounds(230,110,400,50);
        
        JLabel national=new JLabel("Nationality:");
        add(national);
        national.setFont(new Font("Ralway",Font.BOLD,18));
        national.setBounds(50,150,200,50);
        
        lbnational =new JLabel();
        add(lbnational);
        lbnational.setFont(new Font("Ralway",Font.BOLD,18));
        lbnational.setBounds(230,150,400,50);
        
        JLabel address=new JLabel("Address:");
        add(address);
        address.setFont(new Font("Ralway",Font.BOLD,18));
        address.setBounds(50,190,200,50);
        
        lbaddress =new JLabel();
        add(lbaddress);
        lbaddress.setFont(new Font("Ralway",Font.BOLD,18));
        lbaddress.setBounds(230,190,400,50);
        
        JLabel gender=new JLabel("Gender:");
        add(gender);
        gender.setFont(new Font("Ralway",Font.BOLD,18));
        gender.setBounds(50,230,200,50);
        
        lbgender =new JLabel();
        add(lbgender);
        lbgender.setFont(new Font("Ralway",Font.BOLD,18));
        lbgender.setBounds(230,230,400,50);
        
        JLabel from=new JLabel("From:");
        add(from);
        from.setFont(new Font("Ralway",Font.BOLD,18));
        from.setBounds(50,270,100,50);
        
        cfrom = new Choice();
        add(cfrom);
        cfrom.setBounds(230,285,180,50);
        
        JLabel to=new JLabel("To:");
        add(to);
        to.setFont(new Font("Ralway",Font.BOLD,18));
        to.setBounds(50,300,100,50);
        
        cto = new Choice();
        add(cto);
        cto.setBounds(230,315,180,50);
        
        try{
            
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from flightinfo");
            while(rs.next())
            {
                cfrom.add(rs.getString("F_From"));
                cto.add(rs.getString("F_To"));
            }
            
        }catch(Exception e2)
        {
            System.out.println(e2);
        }
        
        fetchflight = new JButton("Fecth Flight");
        add(fetchflight);
        fetchflight.addActionListener(this);
        fetchflight.setBackground(Color.BLACK);
        fetchflight.setForeground(Color.white);
        fetchflight.setBounds(420,315,130,25);
        
        JLabel fname=new JLabel("Flight Name:");
        add(fname);
        fname.setFont(new Font("Ralway",Font.BOLD,18));
        fname.setBounds(50,350,200,50);
        
        lbfname =new JLabel();
        add(lbfname);
        lbfname.setFont(new Font("Ralway",Font.BOLD,18));
        lbfname.setBounds(230,350,400,50);
        
        JLabel fcode=new JLabel("Flight Code:");
        add(fcode);
        fcode.setFont(new Font("Ralway",Font.BOLD,18));
        fcode.setBounds(50,390,200,50);
        
        lbfcode =new JLabel();
        add(lbfcode);
        lbfcode.setFont(new Font("Ralway",Font.BOLD,18));
        lbfcode.setBounds(230,390,400,50);
        
        JLabel date=new JLabel("Date of Travel:");
        add(date);
        date.setFont(new Font("Ralway",Font.BOLD,18));
        date.setBounds(50,435,200,50);
        
        cdate=new JDateChooser();
        add(cdate);
        cdate.setBounds(230,450,200,20);
        
        book = new JButton("Book");
        add(book);
        book.addActionListener(this);
        book.setBackground(Color.BLACK);
        book.setForeground(Color.white);
        book.setBounds(230,500,180,30);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/details.jpg"));
        Image i2=i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        
        JLabel image=new JLabel(i3);
        add(image);
        image.setBounds(640,120,500,400);
        
        setVisible(true);
        setBounds(110,10,1200,700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.white);
                
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==fetch){
            String adhartext=tfadhar.getText();
            try{
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery("select *  from customer where adarno = '"+adhartext+"'");
                if(rs.next())
                {
                    lbname.setText(rs.getString("name"));
                    lbnational.setText(rs.getString("nationality"));
                    lbaddress.setText(rs.getString("address"));
                    lbgender.setText(rs.getString("gender"));
                }else{
                    JOptionPane.showMessageDialog(null, "Adar number is wrong");
                }
                
            }catch(Exception e1){
                System.out.println(e1);
            }
        }else if(e.getSource()== fetchflight)
        {
            String from=cfrom.getSelectedItem();
            String to=cto.getSelectedItem();
            try{
                Conn c=new Conn();
                String query="select * from flightinfo where F_From='"+from+"' and F_To = '"+to+"'";
                ResultSet rs=c.s.executeQuery(query);
                if(rs.next())
                {
                    lbfname.setText(rs.getString("F_name"));
                    lbfcode.setText(rs.getString("F_code"));
                }
                else{
                    JOptionPane.showMessageDialog(null, "NO Flight Found");
                }
            }catch(Exception e1)
            {
                System.out.println(e1);
            }
        }else if(e.getSource()==book)
        {
            Random r=new Random();
            String adhar=tfadhar.getText();
            String from = cfrom.getSelectedItem();
            String to=cto.getSelectedItem();
            String name=lbname.getText();
            String address=lbaddress.getText();
            String national=lbnational.getText();
            String fcode=lbfcode.getText();
            String fname=lbfname.getText();
            String gender=lbgender.getText();   
            String date=((JTextField)cdate.getDateEditor().getUiComponent()).getText();
            
            try{
                Conn c=new Conn();
                String query="insert into ticket values('pnr-"+r.nextInt(10000)+"','tic-"+r.nextInt()+"','"+fcode+"','"+fname+"','"+from+"','"+to+"','"+date+"','"+adhar+"','"+name+"','"+address+"','"+national+"','"+gender+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Ticket Bookd");
                setVisible(false);
            }
            catch(Exception e1)
            {
                System.out.println(e1);
            }
            
         }
    }
   
    public static void main(String []args)
    {
        new Bookflight();
    }
}
