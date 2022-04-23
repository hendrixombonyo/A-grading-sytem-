/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author win
 */
public class SignUpPage extends javax.swing.JFrame {

    /**
     * Creates new form SignUpPage
     */
    public SignUpPage() {
        initComponents();
        
    }

    /**
     *
     */
    public void insertSignUpDetails(){
        String name = jtxtUsername.getText();
        String password = jPasswordField1.getText();
        String email = jtxtEmail.getText();
        String contact = jtxtContact.getText();
        
        try{
           Connection con =DBConnection.getConnection();
           String sql = "insert into users(name,password,email,contact)Values(?,?,?,?)";
           PreparedStatement pst = con.prepareStatement(sql);
           pst.setString(1, name);
           pst.setString(2, password);
           pst.setString(3, email);
           pst.setString(4, contact);
           
           
          int updatedRowCount= pst.executeUpdate();
          if (updatedRowCount>0){
              JOptionPane.showMessageDialog(this, "Record inserted Successfully");
              LoginPage page = new LoginPage();
              page.setVisible(true);
              dispose();
          
          }else{
              JOptionPane.showMessageDialog(this, "Record insertion Failure");
          }
        
        }catch (Exception e){
            e.printStackTrace();
        }
        
    
    }
    public boolean validateSignup(){
        String name = jtxtUsername.getText();
        String password = jPasswordField1.getText();
        String email = jtxtEmail.getText();
        String contact = jtxtContact.getText();
        
        if (name.equals("")){
            JOptionPane.showMessageDialog(this, "Please enter username");
            return false;
            
        }
          
        if (password.equals("")){
            JOptionPane.showMessageDialog(this, "Please enter password");
            return false;
            
        }
          
        if (email.equals("")||!email.matches("^.+@.+\\..+$")){
            JOptionPane.showMessageDialog(this, "Please enter valid email");
            return false;
            
        }
          
        if (contact.equals("")){
            JOptionPane.showMessageDialog(this, "Please enter contact number");
            return false;
            
        }
       return true; 
    }
    public boolean checkDuplicateUser(){
        String name = jtxtUsername.getText();
        boolean isExist = false;
        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from users where name = ?");
            pst.setString(1, name);
            ResultSet rs = pst.executeQuery();
            if (rs.next()){
               isExist = true; 
            
            }else{
                isExist = false;
            
            }
        
        }catch (Exception e){
            e.printStackTrace();
            
        }
        return isExist;
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jtxtUsername = new javax.swing.JTextField();
        jtxtEmail = new javax.swing.JTextField();
        jtxtContact = new javax.swing.JTextField();
        jbtnSignUp = new javax.swing.JButton();
        jbtnLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("SignUP Page");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Username");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Email");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Password");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Contact");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, -1, -1));

        jPasswordField1.setText("jPasswordField1");
        jPanel1.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 210, -1));

        jtxtUsername.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jtxtUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtUsernameFocusLost(evt);
            }
        });
        jPanel1.add(jtxtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 210, 40));

        jtxtEmail.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jPanel1.add(jtxtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 158, 210, 40));

        jtxtContact.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jPanel1.add(jtxtContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 210, 40));

        jbtnSignUp.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jbtnSignUp.setText("SignUp");
        jbtnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSignUpActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnSignUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, -1, -1));

        jbtnLogin.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jbtnLogin.setText("Login");
        jPanel1.add(jbtnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 390, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(710, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(162, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void jbtnSignUpActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        if (validateSignup()== true){
            if(checkDuplicateUser()== false){
        insertSignUpDetails();
            }else{
                JOptionPane.showMessageDialog(this, "Username already exist");
            
            }
        }
    }                                          

    private void jtxtUsernameFocusLost(java.awt.event.FocusEvent evt) {                                       
        // TODO add your handling code here:
        if (checkDuplicateUser()==true){
            JOptionPane.showMessageDialog(this, "Username already exist");
        
        }
    }                                      

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
            java.util.logging.Logger.getLogger(SignUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUpPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JButton jbtnLogin;
    private javax.swing.JButton jbtnSignUp;
    private javax.swing.JTextField jtxtContact;
    private javax.swing.JTextField jtxtEmail;
    private javax.swing.JTextField jtxtUsername;
    // End of variables declaration                   
}
