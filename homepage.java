package connection;

import java.util.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class homepage extends JFrame implements ActionListener

{
    JLabel l1;
    
    homepage()
    
    {
        super("Electricity billing system");
        
        setSize(1600,690);
        
        
        ImageIcon i2= new ImageIcon(ClassLoader.getSystemResource("connection/images/home_8.jpg"));
        Image i3= i2.getImage().getScaledInstance(1550,1000, Image.SCALE_DEFAULT);
        ImageIcon icc= new ImageIcon(i3);
        l1= new JLabel(icc);
        
        add(l1);
        
        JMenuBar mb= new JMenuBar();
        
        JMenu master= new JMenu ("Master");
        JMenuItem mi1= new JMenuItem("New Customer");
        JMenuItem mi2= new JMenuItem("Customer Details");
        
        master.setForeground(Color.blue);
        
        Font f= new Font("monospaced",Font.PLAIN,16);
        mi1.setFont(f);
        mi1.setMnemonic('D');
        mi1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
        mi1.setBackground(Color.white);
        
        
        mi2.setFont(f);
        mi2.setMnemonic('M');
        mi2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
        mi2.setBackground(Color.white);
        mi1.addActionListener(this);
        mi2.addActionListener(this);
        
        
        
        //Second Column.
        
        JMenu user= new JMenu ("User");
        JMenuItem ui1= new JMenuItem("Pay Bill");
        ui1.setFont(f);
        ui1.setMnemonic('F');
        ui1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,ActionEvent.CTRL_MASK));
        ui1.setBackground(Color.white);
        ui1.addActionListener(this);
         
        //Third column.
        
        JMenu report= new JMenu ("Report");
        JMenuItem r1= new JMenuItem("Generate Bill");
        r1.setFont(f);
        r1.setMnemonic('R');
        r1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
        r1.setBackground(Color.white);
        r1.addActionListener(this);
        
        
        //Last column.
        
        JMenu exit= new JMenu ("Exit");
        JMenuItem e1= new JMenuItem("Exit");
        e1.setFont(f);
        e1.setMnemonic('Z');
        e1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,ActionEvent.CTRL_MASK));
        e1.setBackground(Color.white);
        e1.addActionListener(this);
        
        
        //Adding Menu Items in their respective menus.
        
        master.add(mi1);
        master.add(mi2);
        user.add(ui1);
        report.add(r1);
        exit.add(e1);
        
        //Adding all the menus to menubar.
        
        mb.add(master);
        mb.add(user);
        mb.add(report);
        mb.add(exit);
        
        setJMenuBar(mb);
        
        setFont(new Font("Senserif",Font.BOLD,16));
        setLayout(new FlowLayout());
        //setVisible(false);
        
    }
    
    public void actionPerformed(ActionEvent ev)
    
    {
        String msg= ev.getActionCommand();
        
        if (msg.equals("New Customer"))
        
        {
            new homepage().setVisible(false);
            new new_customer().setVisible(true);
        }
        
        else if (msg.equals("Customer Details"))
        {
            new customer_details().setVisible(true);
        }
        
        else if (msg.equals("Pay Bill"))
        {
            new pay_bill().setVisible(true);
        }
        
        else if (msg.equals("Generate Bill"))
        {
            new generate_bill().setVisible(true);
        }
        
        else if (msg.equals("Exit"))
        {
            System.exit(0);
        }
        
        else 
            
        {
            System.out.println("Wrong");
        }
        
        
    }
        
        
    public static void main (String args[])
    {
        new homepage().setVisible(true);
    }
        
        
        
        
        
        
        
    
    
    
    
}