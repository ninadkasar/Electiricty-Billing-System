package connection;
import java.util.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;


public class customer_details extends JFrame implements ActionListener

{   JTable t1;
    JButton b1;
    int i=0;
    int j=0;
    String x[]={"name","meter number","address","state","city","email","phone number"};
    String y[][]=new String[20][8];
    
    customer_details()
    {
        super("Customer details");
        setSize(1200,650);
        setLocation(100,100);
        setResizable(false);
        try
        {
            connectionjava con= new connectionjava();
            String q= "select * from customer_info";
            ResultSet res= con.stm.executeQuery(q);
            
            while(res.next())
            {
                y[i][j++]= res.getString("name");
                y[i][j++]= res.getString("meterno");
                y[i][j++]= res.getString("address");
                y[i][j++]= res.getString("state");
                y[i][j++]= res.getString("city");
                y[i][j++]= res.getString("email");
                y[i][j++]= res.getString("phone_no");
                i++;
                j=0;
                
            }
        }
        
       catch (Exception ae)
        {
                   ae.printStackTrace();
        }
        
        t1= new JTable(y,x);
        b1= new JButton("print");
        add(b1,"South");
        JScrollPane sp= new JScrollPane(t1);
        add(sp);
        b1.addActionListener(this);
        
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            try
            {
                t1.print();
            }
            
            catch(Exception e)
                    {
                        e.printStackTrace();
                    }
        }
    }
    
    public static void main(String []args)
    {
        new customer_details().setVisible(true);
    }
    
}
