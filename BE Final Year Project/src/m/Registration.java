/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Registration.java
 *
 * Created on Mar 20, 2016, 7:51:55 PM
 */
package m.privacy;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

/**
 *
 * @author Chaitanya
 */
public class Registration extends javax.swing.JFrame {

    /** Creates new form Registration */
    public Registration() {
        initComponents();
        
        jLabel10.setVisible(false);
         jLabel12.setVisible(false);
         jLabel13.setVisible(false);
         jLabel14.setVisible(false);
         jLabel15.setVisible(false);
         jLabel16.setVisible(false);
         jLabel17.setVisible(false);
         jLabel18.setVisible(false);
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel2.setText("Name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 30, 60, 14);

        jLabel3.setText("DOB");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 70, 70, 14);

        jLabel4.setText("Age");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 110, 70, 14);

        jLabel5.setText("Disease");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 150, 60, 14);

        jLabel6.setText("Hospital");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 190, 60, 14);

        jLabel7.setText("Area");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 230, 70, 14);

        jLabel8.setText("Email");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(20, 270, 60, 14);

        jButton1.setText("Register");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(30, 343, 100, 30);

        jButton2.setText("Import");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(155, 343, 100, 30);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(110, 30, 130, 20);

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2);
        jTextField2.setBounds(110, 70, 130, 20);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(110, 110, 130, 20);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Cancer", "Skin Disease", "Asthama", "TB" }));
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(110, 150, 84, 20);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Sigma", "Apex", "Dhoot", "MGM" }));
        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(110, 190, 80, 20);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Hudco", "Cidco", "Osmanpura", "Garkheda" }));
        getContentPane().add(jComboBox3);
        jComboBox3.setBounds(110, 230, 80, 20);

        jLabel9.setText("Pin code");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(20, 300, 70, 14);
        getContentPane().add(jTextField4);
        jTextField4.setBounds(110, 270, 140, 20);
        getContentPane().add(jTextField5);
        jTextField5.setBounds(110, 300, 140, 20);

        jLabel10.setText("Enter valid name");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(260, 30, 120, 14);

        jLabel11.setText("DD-MM-YYYY format");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(260, 60, 120, 14);

        jLabel12.setText("Enter valid dob");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(260, 80, 90, 14);

        jLabel13.setText("Age should be greater than zero");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(260, 110, 180, 14);

        jLabel14.setText("Select a valid disease");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(260, 150, 150, 14);

        jLabel15.setText("Select a valid hospital");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(260, 190, 130, 14);

        jLabel16.setText("Select a valid disease");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(260, 230, 102, 14);

        jLabel17.setText("Enter a valid email id");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(260, 270, 130, 14);

        jLabel18.setText("Should be numerical value");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(260, 300, 140, 14);

        jLabel19.setText("Go To Home Page");
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel19MouseEntered(evt);
            }
        });
        getContentPane().add(jLabel19);
        jLabel19.setBounds(330, 350, 180, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/m/privacy/bgproj.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 543, 440);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
System.out.println("Inside 1");
SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date dob=null;
        String name = jTextField1.getText();
        
        String d = jTextField2.getText();
        try{
          dob=sdf.parse(d);
        }          
        catch(Exception e)
        {
            System.out.println("Enter a valid age");
        }
        
         String d1 = null;
       System.out.println("Inside 11");
            java.sql.Date dob1=new java.sql.Date(dob.getTime());   
         d1=dob1.toString();
       
        int age=Integer.parseInt(jTextField3.getText());
        String disease=jComboBox1.getSelectedItem().toString();
        String hospital=jComboBox2.getSelectedItem().toString();
        String area=jComboBox3.getSelectedItem().toString();
        String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        
         String email=jTextField4.getText();
         int pincode=Integer.parseInt(jTextField5.getText());
        String datePattern = "\\d{1,2}-\\d{1,2}-\\d{4}";
       
        MPrivacy m = new MPrivacy();
      
        m.insRegi(name, dob1, age, disease, hospital, area, email, pincode);
        
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
             
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseEntered
        // TODO add your handling code here:

     
    }//GEN-LAST:event_jLabel19MouseEntered

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         try {
            File f = new File("C:\\Users\\Chaitanya\\Desktop\\data1.xls");
            
            Workbook wb = Workbook.getWorkbook(f);
            Sheet s = wb.getSheet(0);
         int row = s.getRows();
         int col = s.getColumns();
            
            Cell c1 = null,c2=null,c3=null,c4 = null,c5=null,c6=null,c7 = null,c8=null;
         
         for(int i=0;i<row;i++)
         {
             for(int j=0;j<col;j++)
             {
                  c1 = s.getCell(j,i);
                        j++;
                  c2 = s.getCell(j,i);
                        j++;
                  c3 = s.getCell(j,i); 
                        j++;
                  c4 = s.getCell(j,i);
                        j++;
                  c5 = s.getCell(j,i);
                        j++;
                  c6 = s.getCell(j,i); 
                        j++;
                  c7 = s.getCell(j,i);
                        j++;
                  c8 = s.getCell(j,i);
                        j++;
                 //MPrivacy m=new MPrivacy();
                 //m.insRegis(c.getContents().toString());
                 
                 System.out.print(c1.getContents()+"\t"+c2.getContents()+"\t"+c3.getContents()+"\t"+c4.getContents()+"\t");
                break;
             }
              String name = c1.getContents().toString();
             
             //Date
             SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
             java.util.Date dob=null;
             String d = c2.getContents().toString();
             dob=sdf.parse(d);
             java.sql.Date dob1=new java.sql.Date(dob.getTime());
             
             //Age
              int age=Integer.parseInt(c3.getContents().toString());
             
              String disease=c4.getContents().toString();
              String hospital=c5.getContents().toString();
              String area=c6.getContents().toString();
              String email=c7.getContents().toString();
              int pincode=Integer.parseInt(c8.getContents().toString());
              
              MPrivacy m=new MPrivacy();
              m.insRegi(name,dob1,age,disease,hospital,area,email,pincode);
             System.out.println();
 
            
        }
         }catch (Exception e) {
             
        }

           





    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        // TODO add your handling code here:
  Home h = new Home();
       h.setVisible(true);
       this.setVisible(false);



    }//GEN-LAST:event_jLabel19MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Registration().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
