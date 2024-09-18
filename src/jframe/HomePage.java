/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Ajinkya
 */
public class HomePage extends javax.swing.JFrame {
    DefaultTableModel model;

    /**
     * Creates new form HomePage
     */
    
    
    Color mouseEnterColor = new Color(0,0,0);
    Color mouseExitColor = new Color(102,102,255);
    public HomePage() {
        initComponents();
        showPieChart();
        setStudentDetilsToTable();
        setBookDetilsToTable();
        setDataToCards();
    }
    
    
    public void setStudentDetilsToTable(){
        
        try{
            
             Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms", "root", "");
        Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from student_details");
            
            while(rs.next()){
                String studentId = rs.getString("student_id");
                String studentName = rs.getString("name");
                String course = rs.getString("course");
                String branch = rs.getString("branch");
                
                Object [] obj = {studentId,studentName ,course ,branch};
                model = (DefaultTableModel) tbl_studentDetails.getModel();
                model.addRow(obj);
            }
        
            
        }catch(Exception e){
            e.printStackTrace();
            
        }
        
    }
    
    
    
      //to set the book details in the table
    public void setBookDetilsToTable(){
        
        try{
            
             Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms", "root", "");
        Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from book_details");
            
            while(rs.next()){
                String bookId = rs.getString("book_id");
                String bookName = rs.getString("book_name");
                String author = rs.getString("author");
                int quantity = rs.getInt("quantity");
                
                Object [] obj = {bookId,bookName ,author ,quantity};
                model = (DefaultTableModel) tbl_bookDetails.getModel();
                model.addRow(obj);
            }
        
            
        }catch(Exception e){
            e.printStackTrace();
            
        }
        
    }
    
    
    public  void setDataToCards(){
        Statement st = null;
        ResultSet rs = null;
        
       long l = System.currentTimeMillis();
       Date todaysDate  =  new Date(l);
       
       
       try{
           Connection con = DBConnection.getConnection();
           st = con.createStatement();
          rs = st.executeQuery("Select * from  book_details");
        
          rs.last();
         lbl_noOfBooks.setText(Integer.toString(rs.getRow()));
         
         //same statement object to execute query
          rs = st.executeQuery("Select * from student_details");
          rs.last();
          lbl_noOfStudents.setText(Integer.toString(rs.getRow()));
          
          
          
           rs = st.executeQuery("Select * from issue_book_details where status   = '"+"pending" + "'");
          rs.last();
          lbl_issuedBooks.setText(Integer.toString(rs.getRow()));
          
          
          
           rs = st.executeQuery("Select * from issue_book_details where due_date < '"+todaysDate+"' and  status = '" + "pending"+"'");
           
          rs.last();
          lbl_defaulterList.setText(Integer.toString(rs.getRow()));
         
         
       
       }catch(Exception e){
           e.printStackTrace();
       }
        
        
        
    }
    
    public void showPieChart(){
        
        //create dataset
      DefaultPieDataset barDataset = new DefaultPieDataset( );
      
      
      try{
          Connection con =  DBConnection.getConnection();
          String sql = "Select book_name, count(*) as issue_count from issue_book_details group by book_id";
          Statement st = con.createStatement();
          ResultSet rs = st.executeQuery(sql);
          
          while(rs.next()){
              barDataset.setValue(rs.getString("book_name"), new Double(rs.getDouble("issue_count")));
              
              
              
          }
          
                  
          
      }catch(Exception e){
          e.printStackTrace();
      }
     
      //create chart
       JFreeChart piechart = ChartFactory.createPieChart("Issue Book Details",barDataset, true,true,false);//explain
      
        PiePlot piePlot =(PiePlot) piechart.getPlot();
      
       //changing pie chart blocks colors
       piePlot.setSectionPaint("IPhone 5s", new Color(255,255,102));
        piePlot.setSectionPaint("SamSung Grand", new Color(102,255,102));
        piePlot.setSectionPaint("MotoG", new Color(255,102,153));
        piePlot.setSectionPaint("Nokia Lumia", new Color(0,204,204));
      
       
        piePlot.setBackgroundPaint(Color.white);
        
        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        panelPieChart.removeAll();
        panelPieChart.add(barChartPanel, BorderLayout.CENTER);
        panelPieChart.validate();
    }
    
    
     
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        lbl_defaulterList = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        lbl_noOfBooks = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        lbl_noOfStudents = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        lbl_issuedBooks = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_bookDetails = new rojerusan.RSTableMetro();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_studentDetails = new rojerusan.RSTableMetro();
        panelPieChart = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/adminIcons/adminIcons/icons8_menu_48px_1.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 10, 50));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("X");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1870, 0, 30, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("library Management System");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 320, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/adminIcons/adminIcons/male_user_50px.png"))); // NOI18N
        jLabel4.setText("Welcome, Admin");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1540, 10, 320, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1900, 70));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(102, 102, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setBackground(new java.awt.Color(255, 51, 51));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/adminIcons/adminIcons/icons8_Exit_26px_2.png"))); // NOI18N
        jLabel8.setText("Logout");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 250, 50));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 770, 340, 60));

        jPanel5.setBackground(new java.awt.Color(255, 51, 51));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(255, 51, 51));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/adminIcons/adminIcons/home_24px.png"))); // NOI18N
        jLabel6.setText("Home Page");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 250, 50));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 340, 60));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Features");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, -1));

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setBackground(new java.awt.Color(255, 51, 51));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/adminIcons/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel5.setText("Dashboard");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 250, 50));

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 340, 60));

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setBackground(new java.awt.Color(255, 51, 51));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/adminIcons/adminIcons/icons8_Book_26px.png"))); // NOI18N
        jLabel9.setText("Manage Books");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel9MouseExited(evt);
            }
        });
        jPanel7.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 250, 50));

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 340, 60));

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setBackground(new java.awt.Color(255, 51, 51));
        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/adminIcons/adminIcons/icons8_Read_Online_26px.png"))); // NOI18N
        jLabel10.setText("Manage Students");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel10MouseExited(evt);
            }
        });
        jPanel8.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 250, 50));

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 340, 60));

        jPanel9.setBackground(new java.awt.Color(51, 51, 51));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setBackground(new java.awt.Color(255, 51, 51));
        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/adminIcons/adminIcons/icons8_Sell_26px.png"))); // NOI18N
        jLabel11.setText("Issue New Book");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel11MouseEntered(evt);
            }
        });
        jPanel9.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 250, 50));

        jPanel3.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 340, 60));

        jPanel10.setBackground(new java.awt.Color(51, 51, 51));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setBackground(new java.awt.Color(255, 51, 51));
        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/adminIcons/adminIcons/icons8_Return_Purchase_26px.png"))); // NOI18N
        jLabel12.setText("Return a book");
        jPanel10.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 250, 50));

        jPanel3.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 340, 60));

        jPanel11.setBackground(new java.awt.Color(51, 51, 51));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setBackground(new java.awt.Color(255, 51, 51));
        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/adminIcons/adminIcons/icons8_View_Details_26px.png"))); // NOI18N
        jLabel13.setText("View Records");
        jPanel11.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 250, 50));

        jPanel3.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 340, 60));

        jPanel12.setBackground(new java.awt.Color(51, 51, 51));
        jPanel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel12MouseExited(evt);
            }
        });
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setBackground(new java.awt.Color(255, 51, 51));
        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/adminIcons/adminIcons/icons8_Books_26px.png"))); // NOI18N
        jLabel14.setText("View Issued Books");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        jPanel12.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 250, 50));

        jPanel3.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 610, 340, 60));

        jPanel13.setBackground(new java.awt.Color(51, 51, 51));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setBackground(new java.awt.Color(255, 51, 51));
        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/adminIcons/adminIcons/icons8_Conference_26px.png"))); // NOI18N
        jLabel16.setText("Defaulter List");
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel16MouseExited(evt);
            }
        });
        jPanel13.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 250, 50));

        jPanel3.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 680, 340, 60));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 960));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel16.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 5, -1, -1));

        jPanel18.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 51, 51)));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_defaulterList.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl_defaulterList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/adminIcons/adminIcons/icons8_Conference_26px.png"))); // NOI18N
        lbl_defaulterList.setText("6");
        jPanel18.add(lbl_defaulterList, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 220, 70));

        jPanel16.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 130, 260, 140));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel15.setText("Defaulter List");
        jPanel16.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 80, -1, -1));

        jPanel19.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(251, 251, 51)));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_noOfBooks.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl_noOfBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/adminIcons/adminIcons/icons8_Book_Shelf_50px.png"))); // NOI18N
        lbl_noOfBooks.setText("34");
        jPanel19.add(lbl_noOfBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 140, 70));

        jPanel16.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 260, 140));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel19.setText("Student Details");
        jPanel16.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 290, -1, -1));

        jPanel20.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 51, 51)));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_noOfStudents.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl_noOfStudents.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/adminIcons/adminIcons/icons8_People_50px.png"))); // NOI18N
        lbl_noOfStudents.setText("24");
        jPanel20.add(lbl_noOfStudents, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 140, 70));

        jPanel16.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, 260, 140));

        jPanel21.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(251, 251, 51)));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_issuedBooks.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl_issuedBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/adminIcons/adminIcons/icons8_Sell_26px.png"))); // NOI18N
        lbl_issuedBooks.setText("18");
        jPanel21.add(lbl_issuedBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 160, 80));

        jPanel16.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 130, 260, 140));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel22.setText("No of Students");
        jPanel16.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, -1, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel23.setText("Issued Books");
        jPanel16.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 90, -1, -1));

        tbl_bookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book Id", "Name", "Author", "Quantity"
            }
        ));
        tbl_bookDetails.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tbl_bookDetails.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        tbl_bookDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_bookDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_bookDetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        tbl_bookDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        tbl_bookDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        tbl_bookDetails.setFuenteHead(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tbl_bookDetails.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbl_bookDetails.setRowHeight(40);
        jScrollPane1.setViewportView(tbl_bookDetails);

        jPanel16.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 760, 920, 250));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel24.setText("No of Books");
        jPanel16.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, -1, -1));

        tbl_studentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Id", "Name", "Course", "Branch"
            }
        ));
        tbl_studentDetails.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tbl_studentDetails.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        tbl_studentDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_studentDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_studentDetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        tbl_studentDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        tbl_studentDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        tbl_studentDetails.setFuenteHead(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tbl_studentDetails.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbl_studentDetails.setRowHeight(40);
        jScrollPane2.setViewportView(tbl_studentDetails);

        jPanel16.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 920, 250));

        panelPieChart.setPreferredSize(new java.awt.Dimension(540, 450));
        panelPieChart.setLayout(new java.awt.BorderLayout());
        jPanel16.add(panelPieChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 340, 490, 630));

        getContentPane().add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 1620, 1120));

        setSize(new java.awt.Dimension(1905, 1160));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        System.exit(0); // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
ManageBooks books = new ManageBooks();
books.setVisible(true);
dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered
     jPanel7.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel9MouseEntered

    private void jLabel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseExited
       jPanel7.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel9MouseExited

    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseEntered
        jPanel8.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel10MouseEntered

    private void jLabel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseExited
         jPanel8.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel10MouseExited

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        IssueBook book = new IssueBook();
        book.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseEntered
       jPanel9.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel11MouseEntered

    private void jPanel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseEntered
        jPanel12.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jPanel12MouseEntered

    private void jPanel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseExited
        jPanel12.setBackground(mouseExitColor);
    }//GEN-LAST:event_jPanel12MouseExited

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        IssueBookDetails issueBookDetails = new IssueBookDetails();
        issueBookDetails.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseEntered
   jPanel13.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel16MouseEntered

    private void jLabel16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseExited
        jPanel13.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel16MouseExited

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
       DefaulterList defaulterList = new DefaulterList();
       defaulterList.setVisible(true);
       dispose();
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        ManageStudents manageStudents = new ManageStudents();
        manageStudents.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel10MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_defaulterList;
    private javax.swing.JLabel lbl_issuedBooks;
    private javax.swing.JLabel lbl_noOfBooks;
    private javax.swing.JLabel lbl_noOfStudents;
    private javax.swing.JPanel panelPieChart;
    private rojerusan.RSTableMetro tbl_bookDetails;
    private rojerusan.RSTableMetro tbl_studentDetails;
    // End of variables declaration//GEN-END:variables
}
