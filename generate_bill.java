
package connection;

import java.util.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;


public class generate_bill extends JFrame implements ActionListener 
{
    
    JLabel l1,l2;
    Choice c1,c2;
    Font f;
    JPanel p,p2;
    JTextArea t1;
    JButton b1,b2;
    //private int units;
    
    generate_bill()
    {
        super("generate bill");
        setSize(450,700);
        setLocation(600,80);
        setResizable(false);
        p= new JPanel();
        p2= new JPanel();
        l1= new JLabel("Meter no");
        l2= new JLabel("Month");
        f= new Font("airel",Font.BOLD,16);
        l1.setFont(f);
        l2.setFont(f);
        
        
        
        c1= new Choice();
        c1.add("1002");
        c1.add("1003");
        c1.add("1004");
        c1.add("1005");
        c1.add("1006");
        c1.add("1007");
        c1.add("1008");
        c1.add("1009");
        c1.add("1010");
        
        c1.setFont(f);
        
        c2= new Choice();
        c2.add("January");
        c2.add("February");
        c2.add("March");
        c2.add("April");
        c2.add("May");
        c2.add("June");
        c2.add("July");
        c2.add("August");
        c2.add("September");
        c2.add("October");
        c2.add("November");
        c2.add("December");
        
        c2.setFont(f);
        
        t1= new JTextArea(50,15);
        t1.setFont(f);
        
        b1= new JButton("Print");
        b2= new JButton("Generate");
        
        b1.setFont(f);
        b2.setFont(f);
        
        setLayout(new BorderLayout());
        p.add(l1);
        p.add(c1);
        p.add(l2);
        p.add(c2);
        
        add(p,"North");
        
        p2.add(b1);
        p2.add(b2);
        add(p2,"South");
        add(t1);
        JScrollPane sp= new JScrollPane(t1);
        add(sp);
        b1.addActionListener(this);
        b2.addActionListener(this);
        
    }
    
    public void actionPerformed(ActionEvent ae) //int units)
    {
        if(ae.getSource()==b2)
        {
            String meterno= c1.getSelectedItem();
            String month= c2.getSelectedItem();
            
            t1.setText("\tReliance Power Limited\n\nElectricity bill for: "+month+"\n2022\n");
            try
            {
                connectionjava con= new connectionjava();
                String q1= "select * from customer_info WHERE meterno='"+meterno+"'";
                ResultSet rst2= con.stm.executeQuery(q1);
                while(rst2.next())
                {
                    t1.append("\nName: "+rst2.getString("name"));
                    t1.append("\nMeterno: "+rst2.getString("meterno"));
                    t1.append("\nAddress: "+rst2.getString("address"));
                    t1.append("\nState: "+rst2.getString("state"));
                    t1.append("\nCity: "+rst2.getString("city"));
                    t1.append("\nEmail id: "+rst2.getString("email"));
                    t1.append("\nPhone number: "+rst2.getString("phone_no"));
                       
                }
                t1.append("\n-----------------------------------------------------------");
                String q2= "select * from tax";
                ResultSet rst3= con.stm.executeQuery(q2);
                while(rst3.next())
                {
                    t1.append("\nMeter Location: "+rst3.getString("meter_location"));
                    t1.append("\nMeter type: "+rst3.getString("meter_type"));
                    t1.append("\nPhase code: "+rst3.getString("phase_code"));
                    t1.append("\nBill type: "+rst3.getString("bill_type"));
                    t1.append("\nDay: "+rst3.getString("days"));
                    
                    t1.append("\n\n-----------------------------------------------------------");
                    
                    t1.append("\nMeter rent: "+rst3.getString("meter_rent"));
                    t1.append("\nService Rent: "+rst3.getString("service_rent"));
                    t1.append("\nGST: "+rst3.getString("gst"));
                    t1.append("\nMVB rent: "+rst3.getString("mcb_rent"));
                }
                
                t1.append("\n");
                String q3= "select * from bill where meter ='"+meterno+"'and month='"+month+"'";
                ResultSet rst4= con.stm.executeQuery(q3);
                
                while(rst4.next())
                {
                    t1.append("\nMeter number: "+rst4.getString("meter"));
                    t1.append("\nCurrent month: "+rst4.getString("month"));
                    t1.append("\nUnits consumed: "+rst4.getString("units"));
                    t1.append("\n\n-----------------------------------------------------------");
                    t1.append("\nTotal Paybill: "+rst4.getString("amount"));
                }
                
            }
            
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        
        if(ae.getSource()==b1)
        {
            try
            {
                t1.print();
            }
            
            catch(Exception ex)
                    {
                        ex.printStackTrace();
                    }
        }
    }
    
    public static void main(String []args)
    {
        new generate_bill().setVisible(true);
    }
    
}
