package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;
import java.sql.*;

public class Boardingpass extends JFrame implements ActionListener {
    
    JTextField pnr;
    JButton enter,print;
    JLabel name,national,from,to,fname,fcode,date;
    
    public Boardingpass(){
        
        setLayout(null);
        
        JLabel heading = new JLabel("AIR INDIA");
        add(heading);
        heading.setFont(new Font("Ralway",Font.PLAIN,30));
        heading.setBounds(400,0,400,50);
        
        JLabel heading1 = new JLabel("Boarding Pass");
        add(heading1);
        heading1.setForeground(Color.blue);
        heading1.setFont(new Font("Ralway",Font.PLAIN,23));
        heading1.setBounds(390,30,400,50);
        
        JLabel pnrno=new JLabel("PNR NO");
        add(pnrno);
        pnrno.setFont(new Font("System",Font.BOLD,18));
        pnrno.setBounds(30,90,200,30);
        
        pnr = new JTextField();
        add(pnr);
        pnr.setBounds(170,90,150,30);
        
        enter = new JButton("Enter");
        add(enter);
        enter.addActionListener(this);
        enter.setBackground(Color.BLACK);
        enter.setForeground(Color.white);
        enter.setBounds(330,90,150,30);
        
        JLabel lbname=new JLabel("Name");
        add(lbname);
        lbname.setFont(new Font("System",Font.BOLD,18));
        lbname.setBounds(30,130,200,30);
        
        name = new JLabel();
        add(name);
        name.setFont(new Font("System",Font.BOLD,18));
        name.setBounds(170,130,200,30);
        
        JLabel lbnational=new JLabel("Nationality");
        add(lbnational);
        lbnational.setFont(new Font("System",Font.BOLD,18));
        lbnational.setBounds(30,170,200,30);
        
        national = new JLabel();
        add(national);
        national.setFont(new Font("System",Font.BOLD,18));
        national.setBounds(170,170,200,30);
        
        JLabel lbfrom=new JLabel("From:");
        add(lbfrom);
        lbfrom.setFont(new Font("System",Font.BOLD,18));
        lbfrom.setBounds(30,210,200,30);
        
        from = new JLabel();
        add(from);
        from.setFont(new Font("System",Font.BOLD,18));
        from.setBounds(170,210,200,30);
        
        JLabel lbto=new JLabel("To:");
        add(lbto);
        lbto.setFont(new Font("System",Font.BOLD,18));
        lbto.setBounds(300,210,200,30);
        
        to = new JLabel();
        add(to);
        to.setFont(new Font("System",Font.BOLD,18));
        to.setBounds(430,210,200,30);
        
        JLabel lbfname=new JLabel("Flight Name:");
        add(lbfname);
        lbfname.setFont(new Font("System",Font.BOLD,18));
        lbfname.setBounds(30,250,200,30);
        
        fname = new JLabel();
        add(fname);
        fname.setFont(new Font("System",Font.BOLD,18));
        fname.setBounds(170,250,200,30);
        
        JLabel lbfcode=new JLabel("Flight Code:");
        add(lbfcode);
        lbfcode.setFont(new Font("System",Font.BOLD,18));
        lbfcode.setBounds(300,250,200,30);
        
        fcode = new JLabel();
        add(fcode);
        fcode.setFont(new Font("System",Font.BOLD,18));
        fcode.setBounds(430,250,200,30);
        
        JLabel lbdate=new JLabel("Date:");
        add(lbdate);
        lbdate.setFont(new Font("System",Font.BOLD,18));
        lbdate.setBounds(30,310,200,30);
        
        date = new JLabel();
        add(date);
        date.setFont(new Font("System",Font.BOLD,18));
        date.setBounds(170,310,200,30);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/airindia.png"));
        Image i2=i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        
        JLabel image=new JLabel(i3);
        add(image);
        image.setBounds(550,0,400,300);
        
        print = new JButton("Print");
        add(print);
        print.addActionListener(this);
        print.setBackground(Color.BLACK);
        print.setForeground(Color.white);
        print.setBounds(700,300,150,30);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(250,100,1000,450);
        getContentPane().setBackground(Color.white);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == enter)
        {
            try{
            
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery("select * from ticket where pnrno = '"+pnr.getText()+"'");
                if(rs.next())
                {
                    name.setText(rs.getString("p_name"));
                    date.setText(rs.getString("date"));
                    from.setText(rs.getString("f_from"));
                    to.setText(rs.getString("f_to"));
                    fname.setText(rs.getString("f_name"));
                    fcode.setText(rs.getString("F_code"));
                    national.setText(rs.getString("p_Nationality"));
                }else{
                    JOptionPane.showMessageDialog(null, "Passenger Not Found");
                }
            }catch(Exception e1){ System.out.println(e1);}
        }else if(e.getSource() == print)
        {
            printFrame();
            setVisible(false);
        }
    }
    
    private void printFrame() {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(new Printable() {
            public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
                if (page > 0) {
                    return NO_SUCH_PAGE;
                }
                Graphics2D g2d = (Graphics2D) g;
                g2d.translate(pf.getImageableX(), pf.getImageableY());
                getContentPane().printAll(g2d);
                return PAGE_EXISTS;
            }
        });

        boolean doPrint = job.printDialog();
        if (doPrint) {
            try {
                job.print();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public static void main(String []args)
    {
        new Boardingpass();
    }
}
