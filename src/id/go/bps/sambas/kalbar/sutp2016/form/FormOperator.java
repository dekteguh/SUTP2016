/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.bps.sambas.kalbar.sutp2016.form;

import id.go.bps.sambas.kalbar.sutp2016.MainFrame;
import id.go.bps.sambas.kalbar.sutp2016.entity.Operator;
import id.go.bps.sambas.kalbar.sutp2016.functions.UserService;
import id.go.bps.sambas.kalbar.sutp2016.resources.ResourceLoader;
import id.go.bps.sambas.kalbar.sutp2016.resources.Strings;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dekteguh
 */
public class FormOperator extends javax.swing.JPanel {

    private MainFrame mainFrame;
    private String username;
    private Operator o;
    /**
     * Creates new form PesertaForm
     */
    public FormOperator(MainFrame frame, String userName) {
        this.mainFrame = frame;
        this.username = userName;
        initComponents();
        this.customizeTable();
        this.loadAwal();
    }
    
    private String loadKode(String kode){
        String code;
        String[] pecah = kode.split(" - ");
        System.out.println(pecah[0]);
        code = pecah[0];
        return code;
    }
    
    private void loadAwal(){
        try{
            ArrayList<Properties> arr = UserService.getOperators();
            DefaultTableModel tableModel = (DefaultTableModel) this.tabelOperator.getModel();
            while (tableModel.getRowCount() > 0) {
                tableModel.removeRow(0);
            }
            int i = 0;
            for (Properties entity : arr) {
                tableModel.addRow(
                        new Object[]{
                            i+1,
                    entity.getProperty("nama_operator"),
                    entity.getProperty("jabatan"),
                    entity.getProperty("username"),
                    entity.getProperty("tahun")+"-"+entity.getProperty("subround")
                });
                i++;
            }
        }catch(Exception ex){
            
        }
    }
    
    private void loadTabel(String kode) {
        try {
            String[] pecah = kode.split("-");
            ArrayList<Properties> arr = UserService.getOperator(Integer.valueOf(pecah[0]), Integer.valueOf(pecah[1]));
            DefaultTableModel tableModel = (DefaultTableModel) this.tabelOperator.getModel();
            while (tableModel.getRowCount() > 0) {
                tableModel.removeRow(0);
            }
            int i = 0;
            for (Properties entity : arr) {
                tableModel.addRow(
                        new Object[]{
                            i+1,
                    entity.getProperty("nama_operator"),
                    entity.getProperty("jabatan"),
                    entity.getProperty("username"),
                    entity.getProperty("tahun")+"-"+entity.getProperty("subround")
                });
                i++;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Maaf, data tidak dapat ditampilkan\nKoneksi gagal", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private void customizeTable() {
        tabelOperator.getTableHeader().setBackground(Color.WHITE);
        Font f = new Font(Font.SANS_SERIF, Font.BOLD, 14);
        tabelOperator.getTableHeader().setFont(f);

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
        tabelOperator.getColumnModel().getColumn(0).setCellRenderer(centerCellRenderer);
        tabelOperator.getColumnModel().getColumn(1).setCellRenderer(leftCellRenderer);
        tabelOperator.getColumnModel().getColumn(2).setCellRenderer(leftCellRenderer);
        tabelOperator.getColumnModel().getColumn(3).setCellRenderer(leftCellRenderer);
        tabelOperator.getColumnModel().getColumn(4).setCellRenderer(centerCellRenderer);
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
        tabelOperator = new javax.swing.JTable();
        buttonTambahOperator = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cmbTahun = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        cmbSubround = new javax.swing.JComboBox();
        buttonLihatOperator = new javax.swing.JButton();
        buttonEditOperator = new javax.swing.JButton();
        buttonHapusOperator = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbiSubround = new javax.swing.JComboBox();
        cmbiTahun = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        cmbiProv = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        cmbiKab = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        txtNIP = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cmbiiJab = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        txtNoHP = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cmbiiKat = new javax.swing.JComboBox();
        txtPass = new javax.swing.JPasswordField();
        buttonUpdateOperator = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(980, 500));
        setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DAFTAR OPERATOR");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tabelOperator.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        tabelOperator.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Nama Operator", "Jabatan", "Username", "Tahun-SR"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelOperator);
        tabelOperator.getColumnModel().getColumn(0).setPreferredWidth(20);

        buttonTambahOperator.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        buttonTambahOperator.setText("Tambah Operator");
        buttonTambahOperator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTambahOperatorActionPerformed(evt);
            }
        });

        jLabel2.setText("Pilih Tahun:");

        cmbTahun.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Pilih Tahun-", "2016", "2017", "2018", "2019", "2020" }));

        jLabel3.setText("Pilih Subround:");

        cmbSubround.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Pilih Subround-", "1", "2", "3" }));

        buttonLihatOperator.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        buttonLihatOperator.setText("Lihat Operator");
        buttonLihatOperator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLihatOperatorActionPerformed(evt);
            }
        });

        buttonEditOperator.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        buttonEditOperator.setText("Edit Operator");
        buttonEditOperator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditOperatorActionPerformed(evt);
            }
        });

        buttonHapusOperator.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        buttonHapusOperator.setText("Hapus Operator");
        buttonHapusOperator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusOperatorActionPerformed(evt);
            }
        });

        jLabel4.setText("Pilih Tahun:");

        jLabel5.setText("Pilih Subround:");

        cmbiSubround.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Pilih Subround-", "1", "2", "3" }));
        cmbiSubround.setPreferredSize(new java.awt.Dimension(230, 27));

        cmbiTahun.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Pilih Tahun -", "2016", "2017", "2018", "2019", "2020" }));
        cmbiTahun.setPreferredSize(new java.awt.Dimension(230, 27));

        jLabel6.setText("Pilih Provinsi:");

        cmbiProv.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Pilih Provinsi-", "61 - Kalimantan Barat" }));
        cmbiProv.setPreferredSize(new java.awt.Dimension(230, 27));

        jLabel7.setText("Pilih Kab/Kota:");

        cmbiKab.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Pilih Kab/Kota-", "01 - Sambas" }));
        cmbiKab.setPreferredSize(new java.awt.Dimension(230, 27));

        jLabel8.setText("NIP");

        jLabel9.setText("Nama");

        txtNama.setPreferredSize(new java.awt.Dimension(230, 28));

        jLabel10.setText("Jabatan");

        cmbiiJab.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Pilih Jabatan-", "Kepala BPS", "Kasie", "Staf", "KSK", "Mitra", " " }));
        cmbiiJab.setPreferredSize(new java.awt.Dimension(230, 27));

        jLabel11.setText("Nomor HP");

        txtNoHP.setPreferredSize(new java.awt.Dimension(230, 28));

        jLabel12.setText("Username");

        txtUsername.setPreferredSize(new java.awt.Dimension(230, 28));

        jLabel13.setText("Password");

        jLabel14.setText("Kategori User");

        cmbiiKat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Pilih Kategori-", "Administrator", "Supervisor", "Operator", " " }));
        cmbiiKat.setPreferredSize(new java.awt.Dimension(230, 27));

        txtPass.setPreferredSize(new java.awt.Dimension(230, 28));

        buttonUpdateOperator.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        buttonUpdateOperator.setText("Update Operator");
        buttonUpdateOperator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateOperatorActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 124, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 124, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 124, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel13, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 124, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel12, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 124, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 124, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 124, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 124, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 124, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 124, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 124, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, txtUsername, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, txtNoHP, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, cmbiiJab, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, txtNama, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, txtNIP)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, cmbiKab, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, cmbiProv, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, cmbiSubround, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, cmbiTahun, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 118, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 118, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(cmbTahun, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 232, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(jPanel1Layout.createSequentialGroup()
                                        .add(cmbSubround, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 232, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(buttonLihatOperator)))
                                .add(63, 63, 63))
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                    .add(cmbiiKat, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(txtPass, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .add(0, 0, Short.MAX_VALUE))))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(6, 6, 6)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 956, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(0, 0, Short.MAX_VALUE))
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(buttonTambahOperator)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(buttonUpdateOperator)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(buttonEditOperator)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(buttonHapusOperator)))))
                .addContainerGap())
            .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(386, Short.MAX_VALUE)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 576, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 33, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(cmbTahun, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel4)
                    .add(cmbiTahun, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(cmbSubround, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(buttonLihatOperator)
                    .add(jLabel5)
                    .add(cmbiSubround, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel6)
                    .add(cmbiProv, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel7)
                    .add(cmbiKab, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel8)
                    .add(txtNIP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel9)
                    .add(txtNama, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel10)
                    .add(cmbiiJab, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel11)
                    .add(txtNoHP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel12)
                    .add(txtUsername, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel13)
                    .add(txtPass, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel14)
                    .add(cmbiiKat, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(buttonTambahOperator)
                        .add(buttonUpdateOperator))
                    .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(buttonEditOperator)
                        .add(buttonHapusOperator)))
                .add(24, 24, 24))
            .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(134, Short.MAX_VALUE)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 300, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(58, Short.MAX_VALUE)))
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonLihatOperatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLihatOperatorActionPerformed
        // TODO add your handling code here:
        int a = cmbTahun.getSelectedIndex();
        int b = cmbSubround.getSelectedIndex();
        if(a==0 || b==0){
            JOptionPane.showMessageDialog(this, "Tahun atau Subround belum dipilih.", "Error", JOptionPane.ERROR_MESSAGE);
                    
        }else{
            int tahun = Integer.valueOf(cmbTahun.getSelectedItem().toString());
            int subround = Integer.valueOf(cmbSubround.getSelectedItem().toString());
            this.loadTabel(tahun+"-"+subround);
        }
        resetForm();
    }//GEN-LAST:event_buttonLihatOperatorActionPerformed

    private void buttonTambahOperatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTambahOperatorActionPerformed
        // TODO add your handling code here:
        int tahun = Integer.valueOf(cmbiTahun.getSelectedItem().toString());
        int subround = Integer.valueOf(cmbiSubround.getSelectedItem().toString());
        String idprov = cmbiProv.getSelectedItem().toString().split(" - ")[0];
        String idkab = cmbiKab.getSelectedItem().toString().split(" - ")[0];
        String nip = txtNIP.getText();
        String user = txtUsername.getText();
        String nama = txtNama.getText();
        String nohp = txtNoHP.getText();
        String pass = txtPass.getText();
        String jabatan = cmbiiJab.getSelectedItem().toString();
        int kat = cmbiiKat.getSelectedIndex();
        
        Operator operator = new Operator();
        operator.setTahun(tahun);
        operator.setSubround(subround);
        operator.setIdProv(idprov);
        operator.setIdKab(idkab);
        operator.setNip(nip);
        operator.setUsername(user);
        operator.setNamaOperator(nama);
        operator.setKategoriOperator(kat);
        operator.setJabatan(jabatan);
        operator.setNoTelp(nohp);
        operator.setPassword(pass);
        try {
            long result = UserService.insertOperator(operator);
            if(result==1){
                JOptionPane.showMessageDialog(this, "Data berhasil disimpan.", "Info", JOptionPane.INFORMATION_MESSAGE);
                resetForm();
                loadTabel(tahun+"-"+subround);
            }else{
                JOptionPane.showMessageDialog(this, "Data gagal disimpan.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            Logger.getLogger(FormOperator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_buttonTambahOperatorActionPerformed

    private String getProv(String id){
        String name = "- Pilih Provinsi -";
        switch(id){
            case "61" : name = "61 - Kalimantan Barat";break;
        }
        return name;
    }
    
    private String getKab(String id){
        String name = "- Pilih Kab/Kota -";
        switch(id){
            case "01" : name = "01 - Sambas";break;
        }
        return name;
    }
    
    private void buttonEditOperatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditOperatorActionPerformed
        // TODO add your handling code here:
        int row = tabelOperator.getSelectedRow();
        String user = tabelOperator.getValueAt(row, 3).toString();
        String[] pecah = tabelOperator.getValueAt(row, 4).toString().split("-");
        try {
            Operator operator = UserService.getOperator(Integer.valueOf(pecah[0]), Integer.valueOf(pecah[1]), user);
            o = operator;
            cmbiTahun.setSelectedItem(pecah[0]);
            cmbiTahun.setEnabled(false);
            cmbiSubround.setSelectedItem(pecah[1]);
            cmbiSubround.setEnabled(false);
            cmbiProv.setSelectedItem(getProv(operator.getIdProv()));
            cmbiProv.setEnabled(false);
            cmbiKab.setSelectedItem(getKab(operator.getIdKab()));
            cmbiKab.setEnabled(false);
            cmbiiJab.setSelectedItem(operator.getJabatan());
            cmbiiKat.setSelectedIndex(operator.getKategoriOperator());
            txtNIP.setText(operator.getNip());
            txtNama.setText(operator.getNamaOperator());
            txtNoHP.setText(operator.getNoTelp());
            txtPass.setText(operator.getPassword());
            txtUsername.setText(operator.getUsername());
            
        } catch (Exception ex) {
            Logger.getLogger(FormOperator.class.getName()).log(Level.SEVERE, null, ex);
        }
        loadTabel(pecah[0]+"-"+pecah[1]);
    }//GEN-LAST:event_buttonEditOperatorActionPerformed

    private void buttonHapusOperatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusOperatorActionPerformed
        // TODO add your handling code here:
        int row = tabelOperator.getSelectedRow();
        String user = tabelOperator.getValueAt(row, 3).toString();
        String[] pecah = tabelOperator.getValueAt(row, 4).toString().split("-");
        try {
            long result = UserService.deleteOperator(Integer.valueOf(pecah[0]), Integer.valueOf(pecah[1]), user);
            if(result==1){
                JOptionPane.showMessageDialog(this, "Data berhasil dihapus.", "Info", JOptionPane.INFORMATION_MESSAGE);
                resetForm();
                loadTabel(pecah[0]+"-"+pecah[1]);
            }else{
                JOptionPane.showMessageDialog(this, "Data gagal dihapus.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            Logger.getLogger(FormOperator.class.getName()).log(Level.SEVERE, null, ex);
        }
        loadTabel(pecah[0]+"-"+pecah[1]);
    }//GEN-LAST:event_buttonHapusOperatorActionPerformed

    private void buttonUpdateOperatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateOperatorActionPerformed
        // TODO add your handling code here:
        int tahun = Integer.valueOf(cmbiTahun.getSelectedItem().toString());
        int subround = Integer.valueOf(cmbiSubround.getSelectedItem().toString());
        String idprov = cmbiProv.getSelectedItem().toString().split(" - ")[0];
        String idkab = cmbiKab.getSelectedItem().toString().split(" - ")[0];
        String nip = txtNIP.getText();
        String user = txtUsername.getText();
        String nama = txtNama.getText();
        String nohp = txtNoHP.getText();
        String pass = txtPass.getText();
        String jabatan = cmbiiJab.getSelectedItem().toString();
        int kat = cmbiiKat.getSelectedIndex();
        try {
            long result = UserService.updateOperator(tahun,subround,idprov,idkab,nip,user,nama,kat,jabatan,nohp,pass);
            if(result==1){
                JOptionPane.showMessageDialog(this, "Data berhasil diupdate.", "Info", JOptionPane.INFORMATION_MESSAGE);
                resetForm();
                loadTabel(tahun+"-"+subround);
            }else{
                JOptionPane.showMessageDialog(this, "Data gagal diupdate.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            Logger.getLogger(FormOperator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        cmbiTahun.setEnabled(true);
        cmbiSubround.setEnabled(true);
        cmbiProv.setEnabled(true);
        cmbiKab.setEnabled(true);
    }//GEN-LAST:event_buttonUpdateOperatorActionPerformed

    private void resetForm(){
        cmbiTahun.setSelectedIndex(0);
        cmbiSubround.setSelectedIndex(0);
        cmbiProv.setSelectedIndex(0);
        cmbiKab.setSelectedIndex(0);
        cmbiiKat.setSelectedIndex(0);
        cmbiiJab.setSelectedIndex(0);
        txtNIP.setText("");
        txtNama.setText("");
        txtNoHP.setText("");
        txtPass.setText("");
        txtUsername.setText("");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonEditOperator;
    private javax.swing.JButton buttonHapusOperator;
    private javax.swing.JButton buttonLihatOperator;
    private javax.swing.JButton buttonTambahOperator;
    private javax.swing.JButton buttonUpdateOperator;
    private javax.swing.JComboBox cmbSubround;
    private javax.swing.JComboBox cmbTahun;
    private javax.swing.JComboBox cmbiKab;
    private javax.swing.JComboBox cmbiProv;
    private javax.swing.JComboBox cmbiSubround;
    private javax.swing.JComboBox cmbiTahun;
    private javax.swing.JComboBox cmbiiJab;
    private javax.swing.JComboBox cmbiiKat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelOperator;
    private javax.swing.JTextField txtNIP;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNoHP;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
