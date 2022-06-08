
package connection;
import java.util.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;


public class new_customer extends JFrame implements ActionListener

{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    JButton b1,b2;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JPanel p1,p2;
    Font f,f1;
    
    new_customer()
            {
                super("New Customer Details");
                setResizable(false);
                setLocation(250,100);
                setSize(1000,400);
                f= new Font("senserif",Font.BOLD,15);
                f1= new Font("senserif",Font.BOLD,20);
                
                p1= new JPanel();
                p1.setLayout(new GridLayout(9,2,10,10));
                
                l1= new JLabel("Name");
                t1= new JTextField(15);
                l1.setFont(f);
                t1.setFont(f1);
                p1.add(l1);
                p1.add(t1);
                
                
                l2= new JLabel("Meter number");
                t2= new JTextField(15);
                l2.setFont(f);
                t2.setFont(f1);
                p1.add(l2);
                p1.add(t2);
                
                
                l3= new JLabel("Address");
                t3= new JTextField(15);
                l3.setFont(f);
                t3.setFont(f1);
                p1.add(l3);
                p1.add(t3);
                
                
                l4= new JLabel("State");
                t4= new JTextField(15);
                l4.setFont(f);
                t4.setFont(f1);
                p1.add(l4);
                p1.add(t4);
                
                
                l5= new JLabel("City");
                t5= new JTextField(15);
                l5.setFont(f);
                t5.setFont(f1);
                p1.add(l5);
                p1.add(t5);
                
                l6= new JLabel("Email");
                t6= new JTextField(15);
                l6.setFont(f);
                t6.setFont(f1);
                p1.add(l6);
                p1.add(t6);
                
                
                l7= new JLabel("Phone number");
                t7= new JTextField(15);
                l7.setFont(f);
                t7.setFont(f1);
                p1.add(l7);
                p1.add(t7);
                
                l9= new JLabel("New Customer Details");
                l9.setFont(f1);
                l9.setHorizontalAlignment(JLabel.CENTER);
                
                b1= new JButton("Submit");
                b2= new JButton("Cancel");
                
                b1.setFont(f);
                b2.setFont(f);
                
                p1.add(b1);
                p1.add(b2);
                
                b1.setBackground(Color.black);
                b1.setForeground(Color.white);
                
                b2.setBackground(Color.black);
                b2.setForeground(Color.white);
                
                
                
                p2= new JPanel();
                p2.setLayout(new GridLayout(1,1));
                
                ImageIcon img= new ImageIcon(ClassLoader.getSystemResource(""));
                Image image= img.getImage().getScaledInstance(1600,690, Image.SCALE_DEFAULT);
                ImageIcon img2= new ImageIcon(image);
                l8= new JLabel(img2);
                p2.add(l8);
                
                setLayout(new BorderLayout(30,30));
                
                add(l9,"North");
                add(p1,"Center");
                add(p2,"West");
                
                b1.addActionListener(this);
                b2.addActionListener(this);
                
                
            }
    
    public void actionPerformed (ActionEvent ev)
    
    {
        if(ev.getSource()==b1)
        {
            String name= t1.getText();
            String meterno= t2.getText();
            String address=t3.getText();
            String state=t4.getText();
            String city=t5.getText();
            String email= t6.getText();
            String phone_no= t7.getText();
            
        
        
             try
                 {
                      connectionjava ob= new connectionjava();
            
                      String q= "insert into customer_info values('"+name+"','"+meterno+"','"+address+"','"+state+"','"+city+"','"+email+"','"+phone_no+"')";
                      ob.stm.executeUpdate(q);
                 }
        
             catch(Exception ae)
                 {
                    ae.printStackTrace();
                 }  
             
             JOptionPane.showMessageDialog(null,"Employee data inserted...");
             setVisible(false);
             
             
             
            
        }
        
        if(ev.getSource()==b2)
             {
                 System.exit(0);
             }
                
    }
    
    public static void main(String []args)
    {
        new new_customer().setVisible(true);
    }
    
}
