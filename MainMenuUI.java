
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class MainMenuUI extends javax.swing.JFrame {

    /**
     * Creates new form UI
     */
    
    
    public MainMenuUI() {
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(Exception e){
            e.printStackTrace();
        }
        initComponents();
        fetchAllBookings();
        fetchAllMaintenance();
        TableRender trb= new TableRender(bookingTable.getDefaultRenderer(Object.class), Color.black);
        bookingTable.setDefaultRenderer(Object.class, trb);
        TableRender trm= new TableRender(maintenanceTable.getDefaultRenderer(Object.class), Color.black);
        maintenanceTable.setDefaultRenderer(Object.class, trm);
        this.setLocationRelativeTo(null);
    }
    
    public void displaySearchResults(ArrayList<Booking> result){
        DefaultTableModel model = new DefaultTableModel(new String[]{"Booking Number", "Customer Number", "Room Number", "First Name", "Last Name", "Date Booked", "Check In Date", "Check Out Date"}, 0){
            public boolean isCellEditable(int row, int col){ //disables editing
                return false;
            }
        };
        
        for(int i= 0; i<result.size(); i++){
            int bn= result.get(i).getBookingNumber();
            int cn= result.get(i).getCustomerNumber();
            int an= result.get(i).getApartmentNumber();
            String fn= result.get(i).getFirstName();
            String ln= result.get(i).getLastName();
            String db= result.get(i).getDateBooked();
            String chkIn= result.get(i).getCheckInDate();
            String chkOut= result.get(i).getCheckOutDate();
            model.addRow(new Object[]{bn, cn, an, fn, ln, db, chkIn, chkOut});
        }
        bookingTable.setModel(model);
        
    }
    
    public void displayMaintenanceSearchResults(ArrayList<RoomManager> result){
        DefaultTableModel model = new DefaultTableModel(new String[]{"Room Number", "Apartment Number", "Room Name", "Room Avability", "Date"}, 0){
            public boolean isCellEditable(int row, int col){ //disables editing
                return false;
            }
        };
        
        for(int i=0; i<result.size(); i++){
             int mn= result.get(i).getMaintenanceNumber();
             int an= result.get(i).getApartmentNumber();
             String mf= result.get(i).getMaintenanceFault();     
             String ma= result.get(i).getMaintenanceAction();
             String md= result.get(i).getMaintenanceDate();
             model.addRow(new Object[]{mn, an, mf, ma, md});
         }
         maintenanceTable.setModel(model);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        newBookBtn = new javax.swing.JButton();
        searchBookingBtn = new javax.swing.JButton();
        DeleteBookingBtn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        bookingTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        newMaintenanceBtn = new javax.swing.JButton();
        searchMaintenanceBtn = new javax.swing.JButton();
        deleteMaintenanceRecord = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        maintenanceTable = new javax.swing.JTable();
        checkTasksBtn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hotel App");

        newBookBtn.setLabel("New Booking");
        newBookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newBookBtnActionPerformed(evt);
            }
        });

        searchBookingBtn.setLabel("Search for Booking");
        searchBookingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBookingBtnActionPerformed(evt);
            }
        });

        DeleteBookingBtn.setLabel("Delete Booking");
        DeleteBookingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBookingBtnActionPerformed(evt);
            }
        });

        bookingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        bookingTable.setFocusable(false);
        jScrollPane3.setViewportView(bookingTable);

        jButton1.setText("View All Bookings");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1439, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(newBookBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchBookingBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DeleteBookingBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newBookBtn)
                    .addComponent(searchBookingBtn)
                    .addComponent(DeleteBookingBtn)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Booking", jPanel1);

        newMaintenanceBtn.setText("New Room Record");
        newMaintenanceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newMaintenanceBtnActionPerformed(evt);
            }
        });

        searchMaintenanceBtn.setText("Search Room Record");
        searchMaintenanceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchMaintenanceBtnActionPerformed(evt);
            }
        });

        deleteMaintenanceRecord.setText("Delete Room Record");
        deleteMaintenanceRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMaintenanceRecordActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(maintenanceTable);

        checkTasksBtn.setText("Check Tasks for Today");
        checkTasksBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkTasksBtnActionPerformed(evt);
            }
        });

        jButton2.setText("View All Rooms");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1439, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(newMaintenanceBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchMaintenanceBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteMaintenanceRecord)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkTasksBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newMaintenanceBtn)
                    .addComponent(searchMaintenanceBtn)
                    .addComponent(deleteMaintenanceRecord)
                    .addComponent(checkTasksBtn)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Room Manager", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newBookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBookBtnActionPerformed
       NewBookingFrame bookingFrame= new NewBookingFrame(this);
       bookingFrame.setVisible(true);
    }//GEN-LAST:event_newBookBtnActionPerformed

    private void searchBookingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBookingBtnActionPerformed
       SearchBookingFrame frame= new SearchBookingFrame(this);
       frame.setVisible(true);
    }//GEN-LAST:event_searchBookingBtnActionPerformed

    private void newMaintenanceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newMaintenanceBtnActionPerformed
        NewRoomFrame frame= new NewRoomFrame(this);
        frame.setVisible(true);
    }//GEN-LAST:event_newMaintenanceBtnActionPerformed

    private void DeleteBookingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBookingBtnActionPerformed
        int bookingNumber= Integer.parseInt(bookingTable.getValueAt(bookingTable.getSelectedRow(), 0).toString());
        DAO conn= new DAO();
        conn.deleteBooking(bookingNumber);
        JOptionPane.showMessageDialog(this, "Booking has been deleted");
        fetchAllBookings();
    }//GEN-LAST:event_DeleteBookingBtnActionPerformed

    private void deleteMaintenanceRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMaintenanceRecordActionPerformed
        int maintenanceNumber= Integer.parseInt(maintenanceTable.getValueAt(maintenanceTable.getSelectedRow(), 0).toString());
        DAO conn= new DAO();
        conn.deleteRoomManager(maintenanceNumber);
        fetchAllMaintenance();
    }//GEN-LAST:event_deleteMaintenanceRecordActionPerformed

    private void searchMaintenanceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchMaintenanceBtnActionPerformed
        SearchRoomFrame frame= new SearchRoomFrame(this);
        frame.setVisible(true);
    }//GEN-LAST:event_searchMaintenanceBtnActionPerformed

    private void checkTasksBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkTasksBtnActionPerformed
        DAO conn= new DAO();
        ArrayList<RoomManager> result= null;
        result= conn.checkRoomManagerToday();
        DefaultTableModel model = new DefaultTableModel(new String[]{"Room Number", "Apartment Number", "Room Name", "Room Avability", "Date"}, 0){
            public boolean isCellEditable(int row, int col){ //disables editing
                return false;
            }
        };
        for(int i=0; i<result.size(); i++){
             int mn= result.get(i).getMaintenanceNumber();
             int an= result.get(i).getApartmentNumber();
             String mf= result.get(i).getMaintenanceFault();     
             String ma= result.get(i).getMaintenanceAction();
             String md= result.get(i).getMaintenanceDate();
             model.addRow(new Object[]{mn, an, mf, ma, md});
         }
         maintenanceTable.setModel(model);
        
    }//GEN-LAST:event_checkTasksBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        fetchAllBookings();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        fetchAllMaintenance();
    }//GEN-LAST:event_jButton2ActionPerformed

    public void fetchAllMaintenance(){
        DAO conn= new DAO();
        ArrayList<RoomManager> result= null;
        try{
            result= conn.getAllRoomManager();
        }catch(SQLException e){
            e.getMessage();
        }
        
         DefaultTableModel model = new DefaultTableModel(new String[]{"Room Number", "Apartment Number", "Room Name", "Room Avability", "Date"}, 0){
            public boolean isCellEditable(int row, int col){ //disables editing
                return false;
            }
        };
         
         for(int i=0; i<result.size(); i++){
             int mn= result.get(i).getMaintenanceNumber();
             int an= result.get(i).getApartmentNumber();
             String mf= result.get(i).getMaintenanceFault();     
             String ma= result.get(i).getMaintenanceAction();
             String md= result.get(i).getMaintenanceDate();
             model.addRow(new Object[]{mn, an, mf, ma, md});
         }
         maintenanceTable.setModel(model);
    }
    
    public void fetchAllBookings(){
        
        
        DAO connection;
        connection = new DAO();
        ArrayList<Booking> result = null;
        try{
            result= connection.getAll();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        

        DefaultTableModel model = new DefaultTableModel(new String[]{"Booking Number", "Customer Number", "Room Number", "First Name", "Last Name", "Date Booked", "Check In Date", "Check Out Date"}, 0){
            public boolean isCellEditable(int row, int col){ //disables editing
                return false;
            }
        };
        for(int i= 0; i<result.size(); i++){
            int bn= result.get(i).getBookingNumber();
            int cn= result.get(i).getCustomerNumber();
            int an= result.get(i).getApartmentNumber();
            String fn= result.get(i).getFirstName();
            String ln= result.get(i).getLastName();
            String db= result.get(i).getDateBooked();
            String chkIn= result.get(i).getCheckInDate();
            String chkOut= result.get(i).getCheckOutDate();
            model.addRow(new Object[]{bn, cn, an, fn, ln, db, chkIn, chkOut});
        }
        bookingTable.setModel(model);
        
    }
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenuUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenuUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenuUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenuUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenuUI().setVisible(true);
            }
        });
      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteBookingBtn;
    private javax.swing.JTable bookingTable;
    private javax.swing.JButton checkTasksBtn;
    private javax.swing.JButton deleteMaintenanceRecord;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable maintenanceTable;
    private javax.swing.JButton newBookBtn;
    private javax.swing.JButton newMaintenanceBtn;
    private javax.swing.JButton searchBookingBtn;
    private javax.swing.JButton searchMaintenanceBtn;
    // End of variables declaration//GEN-END:variables
}
