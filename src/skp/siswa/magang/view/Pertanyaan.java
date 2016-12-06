/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skp.siswa.magang.view;

/**
 *
 * @author Asus
 */

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import skp.siswa.magang.preferences.preferecePertanyaan;
import skp.siswa.magang.preferences.preferenceJawaban;
import skp.siswa.magang.sql.query;

public class Pertanyaan extends javax.swing.JInternalFrame {

    /**
     * Creates new form Pertanyaan
     */
    
    private static String [] sumber;
    private static String [] kategori;
    private static int [] status;
    
    private String [] Sangat_Penting ;
    private String [] Penting ;
    private String [] Biasa;
    private String [] Tidak_Penting ;
    private String [] Sangat_Tidak_Penting ;
    
    
    private int x = 0;
    private int y = 0;
    private int z = 0;
    
    private preferecePertanyaan sumberPertanyaan = new preferecePertanyaan();
    private preferenceJawaban sumberJawaban = new preferenceJawaban();
    private query sql = new query();
    
    public Pertanyaan() {
        initComponents();
        
        loadPertanyaan();
        
        cekStatusPertanyaan(x);
        labelPertanyaan.setText(sumber[x].toString()+"?");
    }
    
    private void loadPertanyaan(){
        sql.panggilPertanyaan();
        sql.PanggilJawaban();
        
        sumber = sumberPertanyaan.getPertanyaan();
        kategori = sumberPertanyaan.getKategori();
        status = sumberPertanyaan.getStatus();
        
        Sangat_Penting = sumberJawaban.getSangat_Penting();
        Penting = sumberJawaban.getPenting();
        Biasa = sumberJawaban.getBiasa();
        Tidak_Penting = sumberJawaban.getTidak_Penting();
        Sangat_Tidak_Penting = sumberJawaban.getSangat_Tidak_Penting();
    }
    
    private void cekStatusPertanyaan(int s){
        if(status[s]==1){
            jawabanSederhana.setEnabled(true);
            jCheckBox1.setVisible(false);
            jCheckBox2.setVisible(false);
            inputJawaban.setEnabled(false);
            jButton3.setVisible(false);
            jButton4.setVisible(false);
            jButton5.setVisible(false);
            jButton6.setVisible(false);
            rasionalisasi.setEditable(false);
        }else if(status[s]==2){
            jawabanSederhana.setEnabled(true);
            jCheckBox1.setVisible(false);
            jCheckBox2.setVisible(false);
            inputJawaban.setEnabled(false);
            jButton3.setText(Sangat_Penting[s]);
            jButton3.setVisible(true);
            jButton4.setText(Penting[s]);
            jButton4.setVisible(true);
            jButton5.setText(Biasa[s]);
            jButton5.setVisible(true);
            jButton6.setText(Tidak_Penting[s]);
            jButton6.setVisible(true);
            rasionalisasi.setEnabled(false);
        }else if(status[s]==3){
            jawabanSederhana.setEnabled(false);
            jCheckBox1.setVisible(false);
            jCheckBox2.setVisible(false);
            inputJawaban.setEnabled(false);
            jButton3.setText(Sangat_Penting[s]);
            jButton3.setVisible(true);
            jButton4.setText(Tidak_Penting[s]);
            jButton4.setVisible(true);
            jButton5.setVisible(false);
            jButton6.setVisible(false);
            rasionalisasi.setEnabled(false);
        }else if(status[s]==4){
            jawabanSederhana.setEnabled(false);
            jCheckBox1.setVisible(true);
            jCheckBox2.setVisible(true);
            inputJawaban.setEnabled(false);
            jButton3.setVisible(true);
            jButton4.setVisible(true);
            jButton5.setVisible(false);
            jButton6.setVisible(false);
            rasionalisasi.setEnabled(true);
        }else if(status[s]==5){
            jawabanSederhana.setEnabled(false);
            jCheckBox1.setVisible(false);
            jCheckBox2.setVisible(false);
            inputJawaban.setEnabled(false);
            jButton3.setVisible(true);
            jButton4.setVisible(true);
            jButton5.setVisible(false);
            jButton6.setVisible(false);
            rasionalisasi.setEnabled(true);
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        labelPertanyaan = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rasionalisasi = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        inputJawaban = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jawabanSederhana = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jSeparator2 = new javax.swing.JSeparator();

        labelPertanyaan.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        labelPertanyaan.setText("Pertanyaan");

        rasionalisasi.setColumns(20);
        rasionalisasi.setRows(5);
        jScrollPane1.setViewportView(rasionalisasi);

        jButton1.setText("Skip");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Jelaskan :");

        inputJawaban.setText("Input");
        inputJawaban.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputJawabanActionPerformed(evt);
            }
        });

        jButton3.setText("jButton3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("jButton4");

        jButton5.setText("jButton5");

        jButton6.setText("jButton6");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Ya");

        jCheckBox2.setText("Tidak");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelPertanyaan)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jawabanSederhana, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jCheckBox1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox2)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(inputJawaban, javax.swing.GroupLayout.DEFAULT_SIZE, 886, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addComponent(jSeparator1)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(39, 39, 39))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(labelPertanyaan)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jawabanSederhana, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2))
                .addGap(0, 3, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputJawaban, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(114, 114, 114))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
            x = x + 1;
            cekStatusPertanyaan(x);
            labelPertanyaan.setText(sumber[x].toString() + "?");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void inputJawabanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputJawabanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputJawabanActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Pertanyaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pertanyaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pertanyaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pertanyaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pertanyaan().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton inputJawaban;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jawabanSederhana;
    private static javax.swing.JLabel labelPertanyaan;
    private javax.swing.JTextArea rasionalisasi;
    // End of variables declaration//GEN-END:variables
}
