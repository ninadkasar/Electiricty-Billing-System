
package connection;
import java.sql.*;

public class connectionjava {
    
    Connection cn;
    Statement stm;
    
    public connectionjava()
    {
        
            try 
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                cn= DriverManager.getConnection("jdbc:mysql://localhost:3306/billing","root","ckmntz01");
                stm= cn.createStatement();
                
                if (cn.isClosed())
                
                {
                    System.out.println("Closed");
                }
                
                else 
                
                {
                    System.out.println("Open");
                }
            }
            
            catch (Exception e)
            
            {
                e.printStackTrace();
                
            }
    }
    
    public static void main (String args[]){
        new connectionjava();
    }
}
    

