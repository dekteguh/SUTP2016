/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.bps.sambas.kalbar.sutp2016.form;

import id.go.bps.sambas.kalbar.sutp2016.MainFrame;
import id.go.bps.sambas.kalbar.sutp2016.entity.DSRT;
import id.go.bps.sambas.kalbar.sutp2016.functions.DSRTService;
import id.go.bps.sambas.kalbar.sutp2016.functions.UtilitasService;
import id.go.bps.sambas.kalbar.sutp2016.resources.ResourceLoader;
import id.go.bps.sambas.kalbar.sutp2016.resources.Strings;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dekteguh
 */
public class FormDSRT extends javax.swing.JPanel {

    private MainFrame mainFrame;
    private String username;
    private JFileChooser jfc;

    /**
     * Creates new form PesertaForm
     */
    public FormDSRT(MainFrame frame, String userName) {
        this.mainFrame = frame;
        this.username = userName;
        initComponents();
        this.customizeTable();
        this.loadAwal();
        this.cmdProvinsi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idx = loadKode(cmdProvinsi.getSelectedItem().toString());
                loadKabupaten(idx);
            }
        });
        this.cmbKako.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    loadDSRT();
                } catch (Exception ex) {
                    Logger.getLogger(FormDSRT.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public void showDialog(String util) {
        jfc = new JFileChooser();
        jfc.setApproveButtonText(util);
        jfc.setFileFilter(new FileNameExtensionFilter("Import DSRT", "xls"));
        jfc.setDialogTitle(util);
        jfc.setApproveButtonToolTipText(util + " data");
    }

    private String loadKode(String kode) {
        String code;
        String[] pecah = kode.split(" - ");
        code = pecah[0];
        return code;
    }

    private void loadKabupaten(String kode) {
        cmbKako.setSelectedIndex(1);
    }
    
    private void loadDSRT() throws Exception{
        cmbNKS.removeAllItems();
        cmbNKS.addItem("-Pilih DSRT-");
        ArrayList<String> arr = UtilitasService.getNKS();
        for(String nks : arr){
            cmbNKS.addItem(nks);
        }
    }
    
    private void loadDSRTAwal(){
        cmbNKS.removeAllItems();
        cmbNKS.addItem("-Pilih DSRT-");
    }

    private void loadTabel(String kode) {
        try {
            String[] pecah = kode.split("-");
            ArrayList<DSRT> arr = DSRTService.getDSRT(Integer.valueOf(pecah[0]), Integer.valueOf(pecah[1]), pecah[2], pecah[3], pecah[4]);
            DefaultTableModel tableModel = (DefaultTableModel) this.tabelDSRT.getModel();
            while (tableModel.getRowCount() > 0) {
                tableModel.removeRow(0);
            }
            int i = 0;
            for (DSRT entity : arr) {
                tableModel.addRow(
                        new Object[]{
                    entity.getTahun()+"-"+entity.getSubround()+"-"+entity.getIdProv()+"-"+entity.getIdKab()+"-"+entity.getNks(),
                    entity.getNks(),
                    entity.getNurtSampel(),
                    entity.getNamaKrt(),
                    entity.getPcl(),
                    entity.getPml()
                });
                i++;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Maaf, data tidak dapat ditampilkan\nKoneksi gagal", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private void loadAwal() {
        try {
            ArrayList<DSRT> arr = DSRTService.getDSRT();
            DefaultTableModel tableModel = (DefaultTableModel) this.tabelDSRT.getModel();
            while (tableModel.getRowCount() > 0) {
                tableModel.removeRow(0);
            }
            int i = 0;
            for (DSRT entity : arr) {
                tableModel.addRow(
                        new Object[]{
                    entity.getTahun()+"-"+entity.getSubround()+"-"+entity.getIdProv()+"-"+entity.getIdKab()+"-"+entity.getNks(),
                    entity.getNks(),
                    entity.getNurtSampel(),
                    entity.getNamaKrt(),
                    entity.getPcl(),
                    entity.getPml()
                });
                i++;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Maaf, data tidak dapat ditampilkan\nKoneksi gagal", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private void customizeTable() {
        tabelDSRT.getTableHeader().setBackground(Color.WHITE);
        Font f = new Font(Font.SANS_SERIF, Font.BOLD, 14);
        tabelDSRT.getTableHeader().setFont(f);

        DefaultTableCellRenderer centerCellRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                super.setHorizontalAlignment(SwingConstants.CENTER);
                return cell;
            }
        };

        DefaultTableCellRenderer leftCellRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                super.setHorizontalAlignment(SwingConstants.LEFT);
                return cell;
            }
        };
        tabelDSRT.getColumnModel().getColumn(0).setCellRenderer(centerCellRenderer);
        tabelDSRT.getColumnModel().getColumn(1).setCellRenderer(leftCellRenderer);
        tabelDSRT.getColumnModel().getColumn(2).setCellRenderer(leftCellRenderer);
        tabelDSRT.getColumnModel().getColumn(3).setCellRenderer(leftCellRenderer);
        tabelDSRT.getColumnModel().getColumn(4).setCellRenderer(leftCellRenderer);
        tabelDSRT.getColumnModel().getColumn(5).setCellRenderer(leftCellRenderer);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel(){
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(new ImageIcon(ResourceLoader.getResource(Strings.BACKGROUND_)).getImage(),0,0,null);
            }
        };
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelDSRT = new javax.swing.JTable();
        buttonImportDSRT = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cmbTahun = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        cmbSubround = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        cmdProvinsi = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        cmbKako = new javax.swing.JComboBox();
        buttonLihatDSRT = new javax.swing.JButton();
        buttonHapusDSRT = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cmbNKS = new javax.swing.JComboBox();

        setPreferredSize(new java.awt.Dimension(980, 500));
        setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DAFTAR DSRT");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tabelDSRT.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        tabelDSRT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NKS", "NURT", "Nama KRT", "PCL", "PML"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelDSRT);
        tabelDSRT.getColumnModel().getColumn(0).setPreferredWidth(170);
        tabelDSRT.getColumnModel().getColumn(1).setPreferredWidth(30);
        tabelDSRT.getColumnModel().getColumn(2).setPreferredWidth(20);

        buttonImportDSRT.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        buttonImportDSRT.setText("Import DSRT");
        buttonImportDSRT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonImportDSRTActionPerformed(evt);
            }
        });

        jLabel2.setText("Pilih Tahun:");

        cmbTahun.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Pilih Tahun-", "2016", "2017", "2018", "2019", "2020" }));

        jLabel3.setText("Pilih Subround:");

        cmbSubround.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Pilih Subround-", "1", "2", "3" }));

        jLabel4.setText("Pilih Provinsi:");

        cmdProvinsi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Pilih Provinsi-", "61 - Kalimantan Barat" }));

        jLabel5.setText("Pilih Kabupaten:");

        cmbKako.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Pilih Kabupaten/Kota-", "01 - Sambas" }));

        buttonLihatDSRT.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        buttonLihatDSRT.setText("Lihat DSRT");
        buttonLihatDSRT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLihatDSRTActionPerformed(evt);
            }
        });

        buttonHapusDSRT.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        buttonHapusDSRT.setText("Hapus DSRT");
        buttonHapusDSRT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusDSRTActionPerformed(evt);
            }
        });

        jLabel6.setText("Pilih NKS:");

        cmbNKS.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Pilih NKS-", "100065" }));

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 956, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(buttonImportDSRT)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(buttonHapusDSRT))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(12, 12, 12)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 937, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                        .add(jPanel1Layout.createSequentialGroup()
                                            .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 124, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                            .add(cmbSubround, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 232, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .add(jPanel1Layout.createSequentialGroup()
                                            .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 124, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                            .add(cmbTahun, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 232, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .add(jPanel1Layout.createSequentialGroup()
                                            .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 124, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                            .add(cmdProvinsi, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 232, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .add(jPanel1Layout.createSequentialGroup()
                                            .add(jLabel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 124, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                            .add(cmbKako, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 232, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                    .add(jPanel1Layout.createSequentialGroup()
                                        .add(jLabel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 124, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(cmbNKS, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 232, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(buttonLihatDSRT)))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 33, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(cmbTahun, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(cmbSubround, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(cmdProvinsi, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel5)
                    .add(cmbKako, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel6)
                    .add(cmbNKS, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(buttonLihatDSRT))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 211, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(buttonImportDSRT)
                    .add(buttonHapusDSRT))
                .add(37, 37, 37))
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonLihatDSRTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLihatDSRTActionPerformed
        // TODO add your handling code here:
        if (cmbTahun.getSelectedIndex() == 0 || cmbSubround.getSelectedIndex() == 0 || cmdProvinsi.getSelectedIndex() == 0 || cmbKako.getSelectedIndex() == 0 || cmbNKS.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Tahun, Subround, Provinsi, Kabupaten, atau NKS masih ada yang belum dipilih.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            int tahun = Integer.valueOf(cmbTahun.getSelectedItem().toString());
            int subround = Integer.valueOf(cmbSubround.getSelectedItem().toString());
            String prov = cmdProvinsi.getSelectedItem().toString().split(" - ")[0];
            String kako = cmbKako.getSelectedItem().toString().split(" - ")[0];
            String nks = cmbNKS.getSelectedItem().toString();
            this.loadTabel(tahun + "-" + subround + "-" + prov + "-" + kako + "-" + nks);
        }
        resetForm();
        loadDSRTAwal();
    }//GEN-LAST:event_buttonLihatDSRTActionPerformed

    private void buttonImportDSRTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonImportDSRTActionPerformed
        // TODO add your handling code here:
        String nama = null;
        showDialog("Import");
        if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            try {
                nama = jfc.getSelectedFile().getAbsolutePath();
                if (!nama.contains(".xls")) {
                    nama = nama + ".xls";
                }
                long result = DSRTService.importDSRT(nama);
                if (result == 1) {
                    JOptionPane.showMessageDialog(this, "Data berhasil diimport.", "Info", JOptionPane.INFORMATION_MESSAGE);
                    loadAwal();
                } else {
                    JOptionPane.showMessageDialog(this, "Data gagal diimport.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                Logger.getLogger(FormDSRT.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            return;
        }

        //JOptionPane.showMessageDialog(null, "Import data berhasil", "INFORMASI", JOptionPane.INFORMATION_MESSAGE);
        Desktop desktop = null;
        if (Desktop.isDesktopSupported()) {
            desktop = Desktop.getDesktop();
        } else {
            JOptionPane.showMessageDialog(null, "Desktop tidak mendukung!", "WARNING", JOptionPane.WARNING_MESSAGE);

        }
    }//GEN-LAST:event_buttonImportDSRTActionPerformed

    private void buttonHapusDSRTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusDSRTActionPerformed
        // TODO add your handling code here:
        int row = tabelDSRT.getSelectedRow();
        String kode = tabelDSRT.getValueAt(row, 0).toString();
        int nurt = Integer.valueOf(tabelDSRT.getValueAt(row, 2).toString());
        String[] pecah = kode.split("-");
        try {
            long result = DSRTService.deleteDSRT(Integer.valueOf(pecah[0]), Integer.valueOf(pecah[1]), pecah[2], pecah[3], pecah[4], nurt);
            if (result == 1) {
                    JOptionPane.showMessageDialog(this, "Data berhasil dihapus.", "Info", JOptionPane.INFORMATION_MESSAGE);
                    loadAwal();
                } else {
                    JOptionPane.showMessageDialog(this, "Data gagal dihapus.", "Error", JOptionPane.ERROR_MESSAGE);
                }
        } catch (Exception ex) {
            Logger.getLogger(FormDSRT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonHapusDSRTActionPerformed

    private void resetForm() {
        cmbTahun.setSelectedIndex(0);
        cmbSubround.setSelectedIndex(0);
        cmdProvinsi.setSelectedIndex(0);
        cmbKako.setSelectedIndex(0);
        cmbNKS.setSelectedIndex(0);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonHapusDSRT;
    private javax.swing.JButton buttonImportDSRT;
    private javax.swing.JButton buttonLihatDSRT;
    private javax.swing.JComboBox cmbKako;
    private javax.swing.JComboBox cmbNKS;
    private javax.swing.JComboBox cmbSubround;
    private javax.swing.JComboBox cmbTahun;
    private javax.swing.JComboBox cmdProvinsi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelDSRT;
    // End of variables declaration//GEN-END:variables
}
