/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package m.privacy;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jxl.Cell;
/**
 *
 * @author Chaitanya
 */
public class MPrivacy {
    Connection con;
    PreparedStatement pst,pst1;
    ResultSet rs;
    
    MPrivacy()
    {
        try{
       Class.forName("oracle.jdbc.driver.OracleDriver");
       con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
       /*if(con!=null)
       {
           System.out.println("Connection success");
       }
       else
       {
           System.out.println("connection fail");
        }*/
       createLogin();
       insertLogin();
       createRegistration();
       
       
        }
        catch(Exception e)
        {
            System.out.println("exception1.. " + e);
            
         }
    }
    /* create login table */
    public void createLogin()
    {
        try {
             pst=con.prepareStatement("create table login(username varchar2(20),password varchar2(20),primary key(username))");
       pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Exception2..." + e);
        }
    }
    // insert into login
    public void insertLogin()
    {
         try {
           pst1=con.prepareStatement("insert into login values(?,?)");
       pst1.setString(1,"user");
       pst1.setString(2,"register");
       pst1.addBatch();
       
       pst1.setString(1,"admin");
       pst1.setString(2,"admin");
       pst1.addBatch();
       
       pst1.executeBatch();
           
       
      
        } catch (Exception e) {
        }
        
    }
    //create registration table
    public void createRegistration()
    {
         try {
             pst=con.prepareStatement("create table registration(name varchar2(20),dob date,age number(3),disease varchar2(20),hospital varchar2(20),area varchar2(20),email varchar2(30),zipcode number(6),primary key(name,dob,disease))");
       pst.executeQuery();
        } catch (Exception e) {
            System.out.println("Exception3..." + e);
        }
    }
    
    // retrive data from database
    public ResultSet getLoginData()
    {
        
        try{
        pst=con.prepareStatement("select * from login");
        rs=pst.executeQuery();
        }
        catch(Exception e)
        {
            System.out.println("exception 5.. " + e);
        }
        return rs;
    }
    
    
    
    public void insRegi(String name,java.sql.Date dob1,int age,String disease,String hospital,String area,String email,int pincode)
    {
        try {
            pst=con.prepareStatement("insert into registration values(?,?,?,?,?,?,?,?)");
            pst.setString(1, name);
            pst.setDate(2, dob1);
            pst.setInt(3,age);
            pst.setString(4, disease);
            pst.setString(5,hospital);
            pst.setString(6,area);
            pst.setString(7,email);
            pst.setInt(8, pincode);
            int i=pst.executeUpdate();
           // System.out.println(i);
            if(i>0)
            {
                JOptionPane.showMessageDialog(null, "Inserted successfully..!!");
            }
            con.commit();
            
            
            
        } catch (SQLException ex) {
            //Logger.getLogger(MPrivacy.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("exception in registration insertion " + ex);
        }
    }
    
    
    public ResultSet generalization_supp()
    {
        try {
            pst=con.prepareStatement("select name,age,disease from registration order by disease");
            rs=pst.executeQuery();
            
        } catch (SQLException ex) {
           System.out.println("generalization exception.." + ex);
        }
        return rs;
    }
    
    public ResultSet selectDiseaseOnly()
    {
        try {
            pst=con.prepareStatement("select disease from registration");
            rs=pst.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Exception from select disease " + ex);
        }
       return rs;
    }
    
    public ResultSet SelectDfromCidco(String area)
    {
        try {
            pst=con.prepareStatement("select disease from registration where area=?");
            pst.setString(1,area);
            rs=pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(MPrivacy.class.getName()).log(Level.SEVERE, null, ex);
        }
       return rs; 
    }
    
    
    public ResultSet SelectAgefromCidco(int ageStart,int ageEnd)
    {
        try {
            pst=con.prepareStatement("select disease from registration where age>? AND age<?");
            pst.setInt(1,ageStart);
            pst.setInt(2,ageEnd);
            rs=pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(MPrivacy.class.getName()).log(Level.SEVERE, null, ex);
        }
       return rs; 
    }
    
    public ResultSet SelectHospitalfromCidco(String area)
    {
        try {
            pst=con.prepareStatement("select disease from registration where hospital=?");
            pst.setString(1,area);
            rs=pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(MPrivacy.class.getName()).log(Level.SEVERE, null, ex);
        }
       return rs; 
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MPrivacy m=new MPrivacy();
        m.insertLogin();
       
    }
}
