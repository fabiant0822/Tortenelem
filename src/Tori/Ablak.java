package Tori;

import java.awt.event.KeyEvent;

/**
 *
 * @author Fabian Tamas 1.0
 */
public class Ablak extends javax.swing.JFrame {

    DB ab;
    
    public Ablak() {
        initComponents();
        ab = new DB();
        ab.beolvas(tblEvek, lekerdez());
    }

    private String lekerdez() {
        String q = "";
        if (!txtTemaSzur.getText().trim().isEmpty())
            q = q + " tema LIKE '%" + txtTemaSzur.getText().trim() + "%' AND ";
        if (!txtEsemenySzur.getText().trim().isEmpty())
            q = q + " esemeny LIKE '%" + txtEsemenySzur.getText().trim() + "%' AND";
        q = q + " ev >= " + sldMettol.getValue() + " AND ev <= " + sldMeddig.getValue();
        return "SELECT * FROM evszamok WHERE " + q + " ORDER BY ev;";
    }
    
    private void tablabol() {
        int i = tblEvek.getSelectedRow();
        if (i == -1) return;
        txtTema.setText(tblEvek.getValueAt(i, 1).toString());
        txtEv.setText(tblEvek.getValueAt(i, 2).toString());
        txtEsemeny.setText(tblEvek.getValueAt(i, 3).toString());
    }
    
    private void uj_kijelol() {
        int sordb = tblEvek.getRowCount();
        int max = 0;
        int sor = 0;
        for (int i = 0; i < sordb; i++) {
            int n = Integer.parseInt(tblEvek.getValueAt(i, 0).toString());
            if (n > max) {
                max = n;
                sor = i;
            }
        }
        tblEvek.setRowSelectionInterval(sor, sor);
        tablabol();
    }
    
    private void kijelol(int evid) {
        int sordb = tblEvek.getRowCount();
        for (int i = 0; i < sordb; i++) {
            int id = Integer.parseInt(tblEvek.getValueAt(i, 0).toString());
            if (id == evid) {
                    tblEvek.setRowSelectionInterval(i, i);
                    tablabol();
                    break;
            }
        }
    }
      
 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sldMeddig = new javax.swing.JSlider();
        sldMettol = new javax.swing.JSlider();
        txtTemaSzur = new javax.swing.JTextField();
        txtEsemenySzur = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEvek = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtEsemeny = new javax.swing.JTextField();
        txtEv = new javax.swing.JTextField();
        txtTema = new javax.swing.JTextField();
        btnModosit = new javax.swing.JButton();
        btnTorol = new javax.swing.JButton();
        btnHozza = new javax.swing.JButton();
        btnUj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Évszámok");
        setResizable(false);

        sldMeddig.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        sldMeddig.setMajorTickSpacing(100);
        sldMeddig.setMaximum(2050);
        sldMeddig.setOrientation(javax.swing.JSlider.VERTICAL);
        sldMeddig.setPaintLabels(true);
        sldMeddig.setPaintTicks(true);
        sldMeddig.setValue(2050);
        sldMeddig.setInverted(true);
        sldMeddig.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                sldMeddigMouseReleased(evt);
            }
        });
        sldMeddig.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                sldMeddigKeyReleased(evt);
            }
        });

        sldMettol.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        sldMettol.setMajorTickSpacing(100);
        sldMettol.setMaximum(2050);
        sldMettol.setOrientation(javax.swing.JSlider.VERTICAL);
        sldMettol.setPaintLabels(true);
        sldMettol.setPaintTicks(true);
        sldMettol.setValue(0);
        sldMettol.setInverted(true);
        sldMettol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                sldMettolMouseReleased(evt);
            }
        });
        sldMettol.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                sldMettolKeyReleased(evt);
            }
        });

        txtTemaSzur.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTemaSzur.setToolTipText("");
        txtTemaSzur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTemaSzurActionPerformed(evt);
            }
        });

        txtEsemenySzur.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtEsemenySzur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEsemenySzurActionPerformed(evt);
            }
        });

        tblEvek.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblEvek.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Téma", "Év", "Esemény"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEvek.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblEvek.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblEvekMouseReleased(evt);
            }
        });
        tblEvek.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblEvekKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblEvek);
        if (tblEvek.getColumnModel().getColumnCount() > 0) {
            tblEvek.getColumnModel().getColumn(0).setMinWidth(0);
            tblEvek.getColumnModel().getColumn(0).setMaxWidth(0);
            tblEvek.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblEvek.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblEvek.getColumnModel().getColumn(3).setPreferredWidth(500);
        }

        jLabel1.setDisplayedMnemonic('e');
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setLabelFor(txtEsemeny);
        jLabel1.setText("Esemény:");

        jLabel2.setDisplayedMnemonic('v');
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setLabelFor(txtEv);
        jLabel2.setText("Év:");

        jLabel3.setDisplayedMnemonic('a');
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setLabelFor(txtTema);
        jLabel3.setText("Téma:");

        txtEsemeny.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtEv.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtTema.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnModosit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnModosit.setMnemonic('m');
        btnModosit.setText("Módosít");
        btnModosit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModositActionPerformed(evt);
            }
        });

        btnTorol.setMnemonic('t');
        btnTorol.setText("Töröl");
        btnTorol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTorolActionPerformed(evt);
            }
        });

        btnHozza.setMnemonic('h');
        btnHozza.setText("Hozzáad");
        btnHozza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHozzaActionPerformed(evt);
            }
        });

        btnUj.setMnemonic('j');
        btnUj.setText("Új");
        btnUj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUjActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sldMettol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTemaSzur, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101)
                        .addComponent(txtEsemenySzur))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEsemeny)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtEv, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                    .addComponent(txtTema))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnHozza, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                    .addComponent(btnUj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnModosit, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                    .addComponent(btnTorol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldMeddig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTemaSzur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEsemenySzur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnModosit)
                            .addComponent(btnHozza))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(txtEv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnTorol)
                                .addComponent(btnUj)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtEsemeny, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(sldMettol, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sldMeddig, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE))
                .addGap(8, 8, 8))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtTemaSzurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTemaSzurActionPerformed
        ab.beolvas(tblEvek, lekerdez());
    }//GEN-LAST:event_txtTemaSzurActionPerformed

    private void txtEsemenySzurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEsemenySzurActionPerformed
        ab.beolvas(tblEvek, lekerdez());
    }//GEN-LAST:event_txtEsemenySzurActionPerformed

    private void sldMettolMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sldMettolMouseReleased
        ab.beolvas(tblEvek, lekerdez());
    }//GEN-LAST:event_sldMettolMouseReleased

    private void sldMeddigMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sldMeddigMouseReleased
        ab.beolvas(tblEvek, lekerdez());
    }//GEN-LAST:event_sldMeddigMouseReleased

    private void sldMettolKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sldMettolKeyReleased
        ab.beolvas(tblEvek, lekerdez());
    }//GEN-LAST:event_sldMettolKeyReleased

    private void sldMeddigKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sldMeddigKeyReleased
        ab.beolvas(tblEvek, lekerdez());
    }//GEN-LAST:event_sldMeddigKeyReleased

    private void tblEvekKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblEvekKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_UP
            || evt.getKeyCode() == KeyEvent.VK_DOWN
            || evt.getKeyCode() == KeyEvent.VK_PAGE_UP
            || evt.getKeyCode() == KeyEvent.VK_PAGE_DOWN)
        tablabol();
    }//GEN-LAST:event_tblEvekKeyReleased

    private void btnUjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUjActionPerformed
        txtEv.setText("");
        txtEsemeny.setText("");
        txtTema.requestFocus();
        txtTema.selectAll();
    }//GEN-LAST:event_btnUjActionPerformed

    private void btnHozzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHozzaActionPerformed
        int n = ab.hozzaad(txtTema.getText(),
                            txtEv.getText(),
                            txtEsemeny.getText());
        if (n > 0) {
            ab.beolvas(tblEvek, lekerdez());
            int ev = Integer.parseInt(txtEv.getText());
            if (ev >= sldMettol.getValue() && ev <= sldMeddig.getValue())
                uj_kijelol();
            txtEv.requestFocus();
            txtEv.selectAll();
        }
    }//GEN-LAST:event_btnHozzaActionPerformed

    private void btnModositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModositActionPerformed
        int i = tblEvek.getSelectedRow();
        if (i == -1) return;
        int evid = Integer.parseInt(tblEvek.getValueAt(i, 0).toString());
        int n = ab.modosit(evid, txtTema.getText(),
                            txtEv.getText(), txtEsemeny.getText());
        if (n > 0) {
            ab.beolvas(tblEvek, lekerdez());
            kijelol(evid);
        }
    }//GEN-LAST:event_btnModositActionPerformed

    private void tblEvekMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEvekMouseReleased
        tablabol();
    }//GEN-LAST:event_tblEvekMouseReleased

    private void btnTorolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTorolActionPerformed
        int i = tblEvek.getSelectedRow();
        if (i == -1) return;
        ab.torol(Integer.parseInt(tblEvek.getValueAt(i, 0).toString()));
        ab.beolvas(tblEvek, lekerdez());
    }//GEN-LAST:event_btnTorolActionPerformed

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
            java.util.logging.Logger.getLogger(Ablak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ablak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ablak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ablak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ablak().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHozza;
    private javax.swing.JButton btnModosit;
    private javax.swing.JButton btnTorol;
    private javax.swing.JButton btnUj;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider sldMeddig;
    private javax.swing.JSlider sldMettol;
    private javax.swing.JTable tblEvek;
    private javax.swing.JTextField txtEsemeny;
    private javax.swing.JTextField txtEsemenySzur;
    private javax.swing.JTextField txtEv;
    private javax.swing.JTextField txtTema;
    private javax.swing.JTextField txtTemaSzur;
    // End of variables declaration//GEN-END:variables
}
