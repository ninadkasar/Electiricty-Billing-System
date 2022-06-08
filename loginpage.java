
package connection;

import java.util.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;


public class loginpage extends JFrame implements ActionListener
{

        JLabel l1,l2,l3;
        JTextField t1;
        JButton b1,b2;
        JPanel p1,p2,p3,p4;
        JPasswordField t2;
        

    
    loginpage()
    
    {
        super("LoginPage");
        setSize(350,250);
        setResizable(false);
       // setBackground(Color.red);
        setLocation(300,300);
        
        l1= new JLabel("Username");
        l2= new JLabel("Password");
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("connection/images/key_lock_billingsystem.jpg"));
        //ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("images/lock.png"));
        
        
        Image img= i1.getImage().getScaledInstance(120, 140, Image.SCALE_DEFAULT);
        ImageIcon i2= new ImageIcon(img);
        
        l3= new JLabel(i2);
        
        t1= new JTextField(12);
        t2= new JPasswordField(12);
        
          
//        ImageIcon i3= new ImageIcon(ClassLoader.getSystemResource(""));
//        Image img2= i3.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        b1= new JButton("Login");
//        ,new ImageIcon(img2)
        
//        ImageIcon i4= new ImageIcon(ClassLoader.getSystemResource(""));
//        Image img3= i4.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        b2= new JButton("Cancel");
//        ,new ImageIcon(img3)
        
        Font f= new Font("Arial",Font.BOLD,16);
        
        l1.setFont(f);
        l2.setFont(f);
        t1.setFont(f);
        t2.setFont(f);
        b1.setFont(f);
        b2.setFont(f);
        
        
        //Panel creation....
        
        p1= new JPanel();
        p2= new JPanel();
        p3= new JPanel();
        p4= new JPanel();
        
        setLayout(new BorderLayout());
        
        p2.add(l1);
        p2.add(t1);
        p2.add(l2);
        p2.add(t2);
        
        add(p2, BorderLayout.CENTER);
        
        //p1.add(l3);
        //add(p1,BorderLayout.WEST);
        
        p3.add(b1);
        p3.add(b2);
        add(p3,BorderLayout.SOUTH);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
    }
        public void actionPerformed(ActionEvent ev)
        
        {
            
            try 
            {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection cn= DriverManager.getConnection("jdbc:mysql://localhost:3306/billing","root","ckmntz01");
            
            if (ev.getSource()==b1)
            
            {
                String name= t1.getText();
                String pass= t2.getText();
                
                String p = "select * from login where username='"+name+"' and password='"+pass+"'";
                Statement stm= cn.createStatement();
                
                ResultSet set= stm.executeQuery(p);
                
                if(set.next())
                
                {
                    new homepage().setVisible(true);
                    this.setVisible(false);
                }
                
                else 
                
                {
                    JOptionPane.showMessageDialog(null, "Invalid Login...!");
                    setVisible(false);
                    
                }
                
                
                
                
            }
            
            else 
            {
                JOptionPane.showMessageDialog(null, "You pressed the cancel button...!");
                setVisible(false);
            }
            
            }
            
            catch (Exception e)
                    
            {
                        e.printStackTrace();
                        System.out.println("error....!"+e);
            }
            
        }
        
        public static void main(String args[])
        
        {
            new loginpage().setVisible(true);
        }
        
        
    }
    

