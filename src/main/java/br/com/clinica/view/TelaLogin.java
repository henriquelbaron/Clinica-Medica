/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.view;

import br.com.clinica.control.LoginControl;
import br.com.clinica.dao.banco.ConnectionFactory;
import br.com.clinica.util.Utils;
import java.awt.Color;

/**
 *
 * @author Luiza Mistro
 */
public class TelaLogin extends javax.swing.JFrame {

    LoginControl control;
    boolean jaAtivo;

    /**
     *
     * Creates new form TelaLogin
     */
    public TelaLogin() {
        initComponents();
        ConnectionFactory.getFabricaDeSessoes();
        control = new LoginControl(this);
        jaAtivo = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                DeixarLabelNormal(evt);
            }
        });

        jLabel4.setText("E-mail");

        jLabel5.setText("Senha");

        tfEmail.setEditable(false);
        tfEmail.setForeground(new java.awt.Color(102, 102, 102));
        tfEmail.setText("Digite seu e-mail");
        tfEmail.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        tfEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfEmailMouseClicked(evt);
            }
        });

        btLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/enter.png"))); // NOI18N
        btLogin.setText("Login");
        btLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLoginActionPerformed(evt);
            }
        });

        lblEsqueciSenha.setText("Esqueci minha senha");
        lblEsqueciSenha.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                DeixarLabelAzul(evt);
            }
        });
        lblEsqueciSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEsqueciSenhaMouseClicked(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Aspek.png"))); // NOI18N

        tfSenha.setEditable(false);
        tfSenha.setForeground(new java.awt.Color(102, 102, 102));
        tfSenha.setText("Digiteasenha");
        tfSenha.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        tfSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfSenhaMouseClicked(evt);
            }
        });

        labelAlerta.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        labelAlerta.setForeground(new java.awt.Color(255, 51, 51));
        labelAlerta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAlerta.setText("Email ou Senha inválidos!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btLogin)
                .addGap(18, 18, 18)
                .addComponent(lblEsqueciSenha)
                .addGap(43, 43, 43))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelAlerta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfSenha, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelAlerta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btLogin)
                    .addComponent(lblEsqueciSenha))
                .addGap(18, 18, 18))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLoginActionPerformed
        control.loginAction();
    }//GEN-LAST:event_btLoginActionPerformed

    private void DeixarLabelAzul(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeixarLabelAzul
        TelaLogin.lblEsqueciSenha.setForeground(Color.BLUE);
    }//GEN-LAST:event_DeixarLabelAzul

    private void DeixarLabelNormal(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeixarLabelNormal
        TelaLogin.lblEsqueciSenha.setForeground(Color.black);
    }//GEN-LAST:event_DeixarLabelNormal

    private void lblEsqueciSenhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEsqueciSenhaMouseClicked
        control.abreEmail();
    }//GEN-LAST:event_lblEsqueciSenhaMouseClicked

    private void tfEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfEmailMouseClicked
        Utils.campoPesquisa(tfEmail, jaAtivo);
        jaAtivo = true;
    }//GEN-LAST:event_tfEmailMouseClicked

    private void tfSenhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfSenhaMouseClicked
        jaAtivo = false;
        Utils.campoPesquisa(tfSenha, jaAtivo);
        jaAtivo = true;
    }//GEN-LAST:event_tfSenhaMouseClicked
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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static final javax.swing.JButton btLogin = new javax.swing.JButton();
    public static final javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
    public static final javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
    public static final javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
    public static final javax.swing.JLabel labelAlerta = new javax.swing.JLabel();
    public static final javax.swing.JLabel lblEsqueciSenha = new javax.swing.JLabel();
    public static final javax.swing.JTextField tfEmail = new javax.swing.JTextField();
    public static final javax.swing.JPasswordField tfSenha = new javax.swing.JPasswordField();
    // End of variables declaration//GEN-END:variables
}
