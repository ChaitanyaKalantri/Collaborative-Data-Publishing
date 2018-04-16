/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Collabration.java
 *
 * Created on Feb 26, 2016, 1:06:12 PM
 */
package m.privacy;

import java.awt.Color;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;


// piechart 1 for display total result

class piechartdemo1 extends ApplicationFrame 
{
   public piechartdemo1( String title ) 
   {
      super( title ); 
      setContentPane(createDemoPanel( ));
   }
   private static PieDataset createDataset( ) 
   {
      MPrivacy m=new MPrivacy();
    ResultSet rs=m.selectDiseaseOnly();
    int cancer=0,skin=0,asthma=0,tb=0;
        
        try {
            while(rs.next())
            {
                if(rs.getString(1).equalsIgnoreCase("Cancer"))
                {
                    //System.out.println(rs.getString(1));
                    cancer ++;
                }
                if(rs.getString(1).equalsIgnoreCase("skin disease"))
                {
                    //System.out.println(rs.getString(1));
                    skin ++;
                }
                if(rs.getString(1).equalsIgnoreCase("asthama"))
                {
                    //System.out.println(rs.getString(1));
                asthma ++;
                }
                if(rs.getString(1).equalsIgnoreCase("TB"))
                {
                    tb ++;
                }
            }
        } catch (SQLException ex) {
            //Logger.getLogger(Collabration.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("createchart1 error "+ ex);
        }
        System.out.println(asthma +" " + skin);
    DefaultPieDataset dataset=new DefaultPieDataset();
    dataset.setValue("Cancer", cancer);
    dataset.setValue("TB", tb);
    dataset.setValue("Asthama", asthma);
    dataset.setValue("Skin Disease", skin);
    
      return dataset;         
   }
   private static JFreeChart createChart( PieDataset dataset )
   {
      JFreeChart chart = ChartFactory.createPieChart(      
         "Total result",  // chart title 
         dataset,        // data    
         true,           // include legend   
         true, 
         false);

      return chart;
   }
   public static JPanel createDemoPanel( )
   {
      JFreeChart chart = createChart(createDataset( ) );  
      return new ChartPanel( chart ); 
   }
}

// for barchart area wise disease
class BarChart_AWT extends ApplicationFrame
{
   public BarChart_AWT( String applicationTitle , String chartTitle )
   {
      super( applicationTitle );        
      JFreeChart barChart = ChartFactory.createBarChart(
         chartTitle,           
         "Category",            
         "Score",            
         createDataset(),          
         PlotOrientation.VERTICAL,           
         true, true, false);
         
      ChartPanel chartPanel = new ChartPanel( barChart );        
      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
      setContentPane( chartPanel ); 
   }
   private CategoryDataset createDataset( )
   {
     
      
      MPrivacy m=new MPrivacy();
      
      ResultSet rs1=m.SelectDfromCidco("Cidco");
      ResultSet rs2=m.SelectDfromCidco("Hudco");
      ResultSet rs3=m.SelectDfromCidco("Osmanpura");
      ResultSet rs4=m.SelectDfromCidco("Garkheda");
      
      int c1=0,c2=0,c3=0,c4=0;
       int h1=0,h2=0,h3=0,h4=0;
       int o1=0,o2=0,o3=0,o4=0;
        int g1=0,g2=0,g3=0,g4=0;
        
        try {
            // cidco
            while(rs1.next())
            {
               if(rs1.getString(1).equalsIgnoreCase("Cancer")) 
                   c1++;
               if(rs1.getString(1).equalsIgnoreCase("Asthama")) 
                   c2++;
               if(rs1.getString(1).equalsIgnoreCase("Skin Disease")) 
                   c3++;
               if(rs1.getString(1).equalsIgnoreCase("TB")) 
                   c4++;
            }
            //Hudco
            while(rs2.next())
            {
               if(rs2.getString(1).equalsIgnoreCase("Cancer")) 
                   h1++;
               if(rs2.getString(1).equalsIgnoreCase("Asthama")) 
                   h2++;
               if(rs2.getString(1).equalsIgnoreCase("Skin Disease")) 
                   h3++;
               if(rs2.getString(1).equalsIgnoreCase("TB")) 
                   h4++;
            }
            
            //osmanpura
            while(rs3.next())
            {
               if(rs3.getString(1).equalsIgnoreCase("Cancer")) 
                   o1++;
               if(rs3.getString(1).equalsIgnoreCase("Asthama")) 
                   o2++;
               if(rs3.getString(1).equalsIgnoreCase("Skin Disease")) 
                   o3++;
               if(rs3.getString(1).equalsIgnoreCase("TB")) 
                   o4++;
            }
            
            //garkheda
            while(rs4.next())
            {
               if(rs4.getString(1).equalsIgnoreCase("Cancer")) 
                   g1++;
               if(rs4.getString(1).equalsIgnoreCase("Asthama")) 
                   g2++;
               if(rs4.getString(1).equalsIgnoreCase("Skin Disease")) 
                   g3++;
               if(rs4.getString(1).equalsIgnoreCase("TB")) 
                   g4++;
            }
        } catch (SQLException ex) {
           System.out.println(ex);
        }
        
      final DefaultCategoryDataset dataset =new DefaultCategoryDataset( );  

      dataset.addValue( c1 , "Cidco" , "Cancer" );        
      dataset.addValue( c2 , "Cidco" , "Asthma" );        
      dataset.addValue( c3 , "Cidco" , "Skin Disease" ); 
      dataset.addValue( c4 , "Cidco" , "TB" );           

      dataset.addValue( h1 , "Hudco" , "Cancer" );        
      dataset.addValue( h2 , "Hudco" , "Asthma" );        
      dataset.addValue( h3 , "Hudco" , "Skin Disease" ); 
      dataset.addValue( h4 , "Hudco" , "TB" ); 
      
      dataset.addValue( o1 , "Osmanpura" , "Cancer" );        
      dataset.addValue( o2 , "Osmanpura" , "Asthma" );        
      dataset.addValue( o3 , "Osmanpura" , "Skin Disease" ); 
      dataset.addValue( o4 , "Osmanpura" , "TB" );  
      
      dataset.addValue( g1 , "Garkheda" , "Cancer" );        
      dataset.addValue( g2 , "Garkheda" , "Asthma" );        
      dataset.addValue( g3 , "Garkheda" , "Skin Disease" ); 
      dataset.addValue( g4 , "Garkheda" , "TB" ); 
      
      return dataset; 
   }
}


class BarChart_AWTAge extends ApplicationFrame
{
   public BarChart_AWTAge( String applicationTitle , String chartTitle )
   {
      super( applicationTitle );        
      JFreeChart barChart = ChartFactory.createBarChart(
         chartTitle,           
         "Category",            
         "Score",            
         createDataset(),          
         PlotOrientation.VERTICAL,           
         true, true, false);
         
      ChartPanel chartPanel = new ChartPanel( barChart );        
      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
      setContentPane( chartPanel ); 
   }
   private CategoryDataset createDataset( )
   {
     
      
      MPrivacy m=new MPrivacy();
      
      ResultSet rs1=m.SelectAgefromCidco(10,20);
      ResultSet rs2=m.SelectAgefromCidco(20,30);
      ResultSet rs3=m.SelectAgefromCidco(30,40);
      ResultSet rs4=m.SelectAgefromCidco(40,50);
      ResultSet rs5=m.SelectAgefromCidco(50,60);
      ResultSet rs6=m.SelectAgefromCidco(60,70);
      ResultSet rs7=m.SelectAgefromCidco(70,80);
      
      int c1=0,c2=0,c3=0,c4=0;
       int h1=0,h2=0,h3=0,h4=0;
       int o1=0,o2=0,o3=0,o4=0;
        int g1=0,g2=0,g3=0,g4=0;
        int d1=0,d2=0,d3=0,d4=0;
       int e1=0,e2=0,e3=0,e4=0;
       int f1=0,f2=0,f3=0,f4=0;
        
        try {
            // cidco
            while(rs1.next())
            {
               if(rs1.getString(1).equalsIgnoreCase("Cancer")) 
                   c1++;
               if(rs1.getString(1).equalsIgnoreCase("Asthama")) 
                   c2++;
               if(rs1.getString(1).equalsIgnoreCase("Skin Disease")) 
                   c3++;
               if(rs1.getString(1).equalsIgnoreCase("TB")) 
                   c4++;
            }
            //Hudco
            while(rs2.next())
            {
               if(rs2.getString(1).equalsIgnoreCase("Cancer")) 
                   h1++;
               if(rs2.getString(1).equalsIgnoreCase("Asthama")) 
                   h2++;
               if(rs2.getString(1).equalsIgnoreCase("Skin Disease")) 
                   h3++;
               if(rs2.getString(1).equalsIgnoreCase("TB")) 
                   h4++;
            }
            
            //osmanpura
            while(rs3.next())
            {
               if(rs3.getString(1).equalsIgnoreCase("Cancer")) 
                   o1++;
               if(rs3.getString(1).equalsIgnoreCase("Asthama")) 
                   o2++;
               if(rs3.getString(1).equalsIgnoreCase("Skin Disease")) 
                   o3++;
               if(rs3.getString(1).equalsIgnoreCase("TB")) 
                   o4++;
            }
            
            //garkheda
            while(rs4.next())
            {
               if(rs4.getString(1).equalsIgnoreCase("Cancer")) 
                   g1++;
               if(rs4.getString(1).equalsIgnoreCase("Asthama")) 
                   g2++;
               if(rs4.getString(1).equalsIgnoreCase("Skin Disease")) 
                   g3++;
               if(rs4.getString(1).equalsIgnoreCase("TB")) 
                   g4++;
            }
            
            while(rs5.next())
            {
               if(rs5.getString(1).equalsIgnoreCase("Cancer")) 
                   d1++;
               if(rs5.getString(1).equalsIgnoreCase("Asthama")) 
                   d2++;
               if(rs5.getString(1).equalsIgnoreCase("Skin Disease")) 
                   d3++;
               if(rs5.getString(1).equalsIgnoreCase("TB")) 
                   d4++;
            }
            
            while(rs6.next())
            {
               if(rs6.getString(1).equalsIgnoreCase("Cancer")) 
                   e1++;
               if(rs6.getString(1).equalsIgnoreCase("Asthama")) 
                   e2++;
               if(rs6.getString(1).equalsIgnoreCase("Skin Disease")) 
                   e3++;
               if(rs6.getString(1).equalsIgnoreCase("TB")) 
                   e4++;
            }
            
            while(rs7.next())
            {
               if(rs7.getString(1).equalsIgnoreCase("Cancer")) 
                   f1++;
               if(rs7.getString(1).equalsIgnoreCase("Asthama")) 
                   f2++;
               if(rs7.getString(1).equalsIgnoreCase("Skin Disease")) 
                   f3++;
               if(rs7.getString(1).equalsIgnoreCase("TB")) 
                   f4++;
            }
            
            
        } catch (SQLException ex) {
           System.out.println(ex);
        }
        
      final DefaultCategoryDataset dataset =new DefaultCategoryDataset( );  

      dataset.addValue( c1 , "10-20" , "Cancer" );        
      dataset.addValue( c2 , "10-20" , "Asthma" );        
      dataset.addValue( c3 , "10-20" , "Skin Disease" ); 
      dataset.addValue( c4 , "10-20" , "TB" );           

      dataset.addValue( h1 , "20-30" , "Cancer" );        
      dataset.addValue( h2 , "20-30" , "Asthma" );        
      dataset.addValue( h3 , "20-30" , "Skin Disease" ); 
      dataset.addValue( h4 , "20-30" , "TB" ); 
      
      dataset.addValue( o1 , "30-40" , "Cancer" );        
      dataset.addValue( o2 , "30-40" , "Asthma" );        
      dataset.addValue( o3 , "30-40" , "Skin Disease" ); 
      dataset.addValue( o4 , "30-40" , "TB" );  
      
      dataset.addValue( g1 , "40-50" , "Cancer" );        
      dataset.addValue( g2 , "40-50" , "Asthma" );        
      dataset.addValue( g3 , "40-50" , "Skin Disease" ); 
      dataset.addValue( g4 , "40-50" , "TB" ); 
      
      dataset.addValue( d1 , "50-60" , "Cancer" );        
      dataset.addValue( d2 , "50-60" , "Asthma" );        
      dataset.addValue( d3 , "50-60" , "Skin Disease" ); 
      dataset.addValue( d4 , "50-60" , "TB" );
      
      dataset.addValue( e1 , "60-70" , "Cancer" );        
      dataset.addValue( e2 , "60-70" , "Asthma" );        
      dataset.addValue( e3 , "60-70" , "Skin Disease" ); 
      dataset.addValue( e4 , "60-70" , "TB" );
      
      dataset.addValue( f1 , "70-80" , "Cancer" );        
      dataset.addValue( f2 , "70-80" , "Asthma" );        
      dataset.addValue( f3 , "70-80" , "Skin Disease" ); 
      dataset.addValue( f4 , "70-80" , "TB" );
      
      
      
      return dataset; 
   }
}


class BarChart_AWTHospital extends ApplicationFrame
{
   public BarChart_AWTHospital( String applicationTitle , String chartTitle )
   {
      super( applicationTitle );        
      JFreeChart barChart = ChartFactory.createBarChart(
         chartTitle,           
         "Category",            
         "Score",            
         createDataset(),          
         PlotOrientation.VERTICAL,           
         true, true, false);
         
      ChartPanel chartPanel = new ChartPanel( barChart );        
      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
      setContentPane( chartPanel ); 
   }
   private CategoryDataset createDataset( )
   {
     
      
      MPrivacy m=new MPrivacy();

      
      ResultSet rs1=m.SelectHospitalfromCidco("Sigma");
      ResultSet rs2=m.SelectHospitalfromCidco("Apex");
      ResultSet rs3=m.SelectHospitalfromCidco("Dhoot");
      ResultSet rs4=m.SelectHospitalfromCidco("MGM");
      
      int c1=0,c2=0,c3=0,c4=0;
       int h1=0,h2=0,h3=0,h4=0;
       int o1=0,o2=0,o3=0,o4=0;
        int g1=0,g2=0,g3=0,g4=0;
        
        try {
            // cidco
            while(rs1.next())
            {
               if(rs1.getString(1).equalsIgnoreCase("Cancer")) 
                   c1++;
               if(rs1.getString(1).equalsIgnoreCase("Asthama")) 
                   c2++;
               if(rs1.getString(1).equalsIgnoreCase("Skin Disease")) 
                   c3++;
               if(rs1.getString(1).equalsIgnoreCase("TB")) 
                   c4++;
            }
            //Hudco
            while(rs2.next())
            {
               if(rs2.getString(1).equalsIgnoreCase("Cancer")) 
                   h1++;
               if(rs2.getString(1).equalsIgnoreCase("Asthama")) 
                   h2++;
               if(rs2.getString(1).equalsIgnoreCase("Skin Disease")) 
                   h3++;
               if(rs2.getString(1).equalsIgnoreCase("TB")) 
                   h4++;
            }
            
            //osmanpura
            while(rs3.next())
            {
               if(rs3.getString(1).equalsIgnoreCase("Cancer")) 
                   o1++;
               if(rs3.getString(1).equalsIgnoreCase("Asthama")) 
                   o2++;
               if(rs3.getString(1).equalsIgnoreCase("Skin Disease")) 
                   o3++;
               if(rs3.getString(1).equalsIgnoreCase("TB")) 
                   o4++;
            }
            
            //garkheda
            while(rs4.next())
            {
               if(rs4.getString(1).equalsIgnoreCase("Cancer")) 
                   g1++;
               if(rs4.getString(1).equalsIgnoreCase("Asthama")) 
                   g2++;
               if(rs4.getString(1).equalsIgnoreCase("Skin Disease")) 
                   g3++;
               if(rs4.getString(1).equalsIgnoreCase("TB")) 
                   g4++;
            }
        } catch (SQLException ex) {
           System.out.println(ex);
        }
        
      final DefaultCategoryDataset dataset =new DefaultCategoryDataset( );  

      dataset.addValue( c1 , "Sigma" , "Cancer" );        
      dataset.addValue( c2 , "Sigma" , "Asthma" );        
      dataset.addValue( c3 , "Sigma" , "Skin Disease" ); 
      dataset.addValue( c4 , "Sigma" , "TB" );           

      dataset.addValue( h1 , "Apex" , "Cancer" );        
      dataset.addValue( h2 , "Apex" , "Asthma" );        
      dataset.addValue( h3 , "Apex" , "Skin Disease" ); 
      dataset.addValue( h4 , "Apex" , "TB" ); 
      
      dataset.addValue( o1 , "Dhoot" , "Cancer" );        
      dataset.addValue( o2 , "Dhoot" , "Asthma" );        
      dataset.addValue( o3 , "Dhoot" , "Skin Disease" ); 
      dataset.addValue( o4 , "Dhoot" , "TB" );  
      
      dataset.addValue( g1 , "MGM" , "Cancer" );        
      dataset.addValue( g2 , "MGM" , "Asthma" );        
      dataset.addValue( g3 , "MGM" , "Skin Disease" ); 
      dataset.addValue( g4 , "MGM" , "TB" ); 
      
      return dataset; 
   }
}








/**
 *
 * @author Chaitanya
 */



public class Collabration extends javax.swing.JFrame {

    /** Creates new form Collabration */
    public Collabration() {
        initComponents();
       // createpiechart1();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        t = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(null);

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel1.setLayout(null);

        t.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Age", "Disease"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(t);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 60, 452, 320);

        jLabel3.setFont(new java.awt.Font("Dialog", 2, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(-65536,true));
        jLabel3.setText("Click Heare to view Generalized data");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3);
        jLabel3.setBounds(90, 20, 380, 20);

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18));
        jLabel5.setForeground(new java.awt.Color(-14336,true));
        jLabel5.setText("Go To Home Page");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
        });
        jPanel1.add(jLabel5);
        jLabel5.setBounds(310, 394, 170, 20);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/m/privacy/bgproj.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 4, 500, 420);

        jTabbedPane1.addTab("Generalization and suppression", jPanel1);

        jPanel2.setLayout(null);

        jButton1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(-8355712,true));
        jButton1.setText("Total Result");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(100, 20, 310, 40);

        jButton2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(-8355712,true));
        jButton2.setText("Area wise Disease Distribution");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2MouseExited(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(100, 70, 310, 40);

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18));
        jLabel4.setForeground(new java.awt.Color(-14336,true));
        jLabel4.setText("Go To Home Page");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });
        jPanel2.add(jLabel4);
        jLabel4.setBounds(310, 380, 160, 30);

        jButton3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(-8355712,true));
        jButton3.setText("Age wise Disease Distribution");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(100, 120, 310, 40);

        jButton4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(-8355712,true));
        jButton4.setText("Hospital wise Disease Distribution");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);
        jButton4.setBounds(100, 170, 310, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/m/privacy/bgproj.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(0, 0, 775, 539);

        jTabbedPane1.addTab("Graphcal view", jPanel2);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(0, 0, 500, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        piechartdemo1 demo = new piechartdemo1( "Total result" );  
      demo.setSize( 560 , 367 );    
      RefineryUtilities.centerFrameOnScreen( demo );    
      demo.setVisible( true ); 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
         DefaultTableModel dfm=(javax.swing.table.DefaultTableModel)t.getModel();
        t.setModel(dfm);
        
        MPrivacy m=new MPrivacy();
        ResultSet rs=m.generalization_supp();
        try {
            while(rs.next())
            {
               Vector v=new Vector();
               String name=rs.getString(1);
               // generalization
               
               int l=name.length();
               name=name.substring(0, 2);
               for(int j=2;j<l;j++)
               {
                   name=name+" *";
               }
               
               // suppression
               
               int age=rs.getInt(2);
               int unitplace=age%10;
               int start=age-unitplace;
               int end=10-unitplace+age;
               
               
               String disease=rs.getString(3);
                  
               v.addElement(name);
               v.addElement(start +"-" + end);
               v.addElement(disease);
               dfm.addRow(v);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        BarChart_AWT chart = new BarChart_AWT("Diseases according to area", "Distribution of each disease per area");
      chart.pack( );        
      RefineryUtilities.centerFrameOnScreen( chart );        
      chart.setVisible( true );
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        Home h=new Home();
        h.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        // TODO add your handling code here:
        jLabel4.setForeground(Color.red);
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        // TODO add your handling code here:
        jLabel4.setForeground(Color.orange);
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        Home h=new Home();
        h.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
        // TODO add your handling code here:
        jLabel5.setForeground(Color.red);
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
        // TODO add your handling code here:
        jLabel5.setForeground(Color.orange);
    }//GEN-LAST:event_jLabel5MouseExited

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        // TODO add your handling code here:
        jButton1.setForeground(Color.blue);
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        // TODO add your handling code here:
        jButton1.setForeground(Color.gray);
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        // TODO add your handling code here:
        jButton2.setForeground(Color.blue);
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
        // TODO add your handling code here:
        jButton2.setForeground(Color.gray);
    }//GEN-LAST:event_jButton2MouseExited

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

     BarChart_AWTAge chart = new BarChart_AWTAge("Diseases according to age", "Distribution of each disease per age group");
      chart.pack( );        
      RefineryUtilities.centerFrameOnScreen( chart );        
      chart.setVisible( true );



    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
      BarChart_AWTHospital chart = new BarChart_AWTHospital("Diseases according to hospital", "Distribution of each disease per hospital");
      chart.pack( );        
      RefineryUtilities.centerFrameOnScreen( chart );        
      chart.setVisible( true );

    }//GEN-LAST:event_jButton4ActionPerformed
   /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Collabration().setVisible(true);
                
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable t;
    // End of variables declaration//GEN-END:variables
}
