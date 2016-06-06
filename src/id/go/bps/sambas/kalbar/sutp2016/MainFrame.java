/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.bps.sambas.kalbar.sutp2016;

import id.go.bps.sambas.kalbar.sutp2016.form.FormBackupRestore;
import id.go.bps.sambas.kalbar.sutp2016.form.FormDSBS;
import id.go.bps.sambas.kalbar.sutp2016.form.FormDSRT;
import id.go.bps.sambas.kalbar.sutp2016.form.FormDaftarDSRT;
import id.go.bps.sambas.kalbar.sutp2016.form.FormEksporData;
import id.go.bps.sambas.kalbar.sutp2016.form.FormOperator;
import id.go.bps.sambas.kalbar.sutp2016.form.FormPetugas;
import id.go.bps.sambas.kalbar.sutp2016.form.FormProgressReport;
import id.go.bps.sambas.kalbar.sutp2016.resources.ResourceLoader;
import id.go.bps.sambas.kalbar.sutp2016.resources.Strings;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 *
 * @author dekteguh
 */
public class MainFrame extends javax.swing.JFrame {

    private String username = "";
    private String operator = "";
    int waktumulai = 0;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        //set ukuran desktop
        this.setSize(1024, 720);
        //this.setSize(1033, 768);
        //set letak desktop di tengah
        this.setLocationRelativeTo(null);
        //set desktop tidak bisa dimaximize
        this.setResizable(false);
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //set icon aplikasi
        this.setIconImage(new ImageIcon(getClass().getResource(Strings.LOGO)).getImage());
        //masukkan segala panel ke dalam mainframe
        this.mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.mainPanel.add(this.headerPanel);
        this.mainPanel.add(this.menuBar);
        this.mainPanel.add(this.contentScrollPane);
        this.mainPanel.add(this.footerPanel);
        this.setEnableLogin(true,2);
        this.textInfo.setText("");
        showJam();
    }

    private String getHost(String id) {
        String hostname = "";
        try {
            InetAddress addr;
            addr = InetAddress.getLocalHost();
            if (id.equals("ip")) {
                hostname = addr.getHostAddress();
            }
            if (id.equals("pc")) {
                hostname = addr.getHostName();
            }

        } catch (UnknownHostException ex) {
            System.out.println("Hostname can not be resolved");
        }
        return hostname;
    }

    public void setTextUsername(String textUsername) {
        String[] pecah = textUsername.split("-");
        this.username = pecah[1];
        operator = pecah[1];
        String tulisan = "IP Client : " + getHost("ip") + " | Computer Name : " + getHost("pc") + " | Operator : " + pecah[0] + " | AppVersion: 1.0.0";
        this.textInfo.setText(tulisan);
        this.textInfo.setVisible(true);
    }

    public JLabel getTextInfo() {
        return textInfo;
    }

    public JScrollPane getContentScrollPane() {
        return contentScrollPane;
    }

    public void showJam() {
        new Thread() {
            @Override
            public void run() {
                while (waktumulai == 0) {
                    Calendar kalender = new GregorianCalendar();
                    int jam = kalender.get(Calendar.HOUR_OF_DAY);
                    int menit = kalender.get(Calendar.MINUTE);
                    int detik = kalender.get(Calendar.SECOND);
                    int AM_PM = kalender.get(Calendar.AM_PM);
                    String siang_malam = "";
                    if (AM_PM == 1) {
                        siang_malam = "PM";
                    } else {
                        siang_malam = "AM";
                    }
                    String time = jam + ":" + menit + ":" + detik + " " + siang_malam;
                    textWaktu.setText("Waktu: " + time);
                }
            }
        }.start();
    }

    // Fungsi untuk set halaman login atau halaman utama
    // Jika enable true, berarti yang muncul halaman login
    // Jika enable false, berarti yang muncul halaman utama
    public final void setEnableLogin(boolean enable, int i) {
        this.fileMenu.setEnabled(!enable);
        if (i==1 && enable==false) {
            this.masterMenu.setVisible(!enable);
            this.utilityMenu.setVisible(!enable);
        } else if(i==2 && enable==false){
            this.masterMenu.setVisible(enable);
            this.utilityMenu.setVisible(enable);
        }else {
            this.masterMenu.setVisible(!enable);
            this.utilityMenu.setVisible(!enable);
        }
        this.aboutMenu.setEnabled(!enable);
        if (enable) {
            this.contentScrollPane.setViewportView(new LoginPanel(this));
        } else {
            this.contentScrollPane.setViewportView(new HomePanel(this, operator));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new javax.swing.JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(new ImageIcon(ResourceLoader.getResource(Strings.HEADER)).getImage(), 0, 0, null);
            }
        };
        menuBar = new javax.swing.JMenuBar(){
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(new ImageIcon(ResourceLoader.getResource(Strings.BACKGROUND_MENU)).getImage(),0,0,null);
            }
        };
        fileMenu = new javax.swing.JMenu();
        homeMenu = new javax.swing.JMenuItem();
        entriMenu = new javax.swing.JMenuItem();
        progressMenu = new javax.swing.JMenuItem();
        logoutMenu = new javax.swing.JMenuItem();
        masterMenu = new javax.swing.JMenu();
        dsbsMenu = new javax.swing.JMenuItem();
        dsrtMenu = new javax.swing.JMenuItem();
        petugasMenu = new javax.swing.JMenuItem();
        operatorMenu = new javax.swing.JMenuItem();
        utilityMenu = new javax.swing.JMenu();
        backresMenu = new javax.swing.JMenuItem();
        eksporMenu = new javax.swing.JMenuItem();
        aboutMenu = new javax.swing.JMenu();
        infoMenu = new javax.swing.JMenuItem();
        contentScrollPane = new javax.swing.JScrollPane();
        footerPanel = new javax.swing.JPanel();
        textInfo = new javax.swing.JLabel();
        textWaktu = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel(){
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(new ImageIcon(ResourceLoader.getResource(Strings.BACKGROUND)).getImage(),0,0,null);
            }
        };

        headerPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        headerPanel.setName("headerPanel"); // NOI18N
        headerPanel.setOpaque(false);
        headerPanel.setPreferredSize(new java.awt.Dimension(990, 80));

        org.jdesktop.layout.GroupLayout headerPanelLayout = new org.jdesktop.layout.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 986, Short.MAX_VALUE)
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 76, Short.MAX_VALUE)
        );

        menuBar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        menuBar.setBorderPainted(false);
        menuBar.setName("menuBar"); // NOI18N
        menuBar.setOpaque(false);
        menuBar.setPreferredSize(new java.awt.Dimension(990, 30));

        fileMenu.setText("File");
        fileMenu.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        fileMenu.setOpaque(false);

        homeMenu.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        homeMenu.setText("Home");
        homeMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeMenuActionPerformed(evt);
            }
        });
        fileMenu.add(homeMenu);

        entriMenu.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        entriMenu.setText("Entri");
        entriMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entriMenuActionPerformed(evt);
            }
        });
        fileMenu.add(entriMenu);

        progressMenu.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        progressMenu.setText("Progress Report");
        progressMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                progressMenuActionPerformed(evt);
            }
        });
        fileMenu.add(progressMenu);

        logoutMenu.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        logoutMenu.setText("Logout");
        logoutMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutMenuActionPerformed(evt);
            }
        });
        fileMenu.add(logoutMenu);

        menuBar.add(fileMenu);

        masterMenu.setText("Master");
        masterMenu.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        masterMenu.setOpaque(false);

        dsbsMenu.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        dsbsMenu.setText("DSBS");
        dsbsMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dsbsMenuActionPerformed(evt);
            }
        });
        masterMenu.add(dsbsMenu);

        dsrtMenu.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        dsrtMenu.setText("DSRT");
        dsrtMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dsrtMenuActionPerformed(evt);
            }
        });
        masterMenu.add(dsrtMenu);

        petugasMenu.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        petugasMenu.setText("Petugas");
        petugasMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                petugasMenuActionPerformed(evt);
            }
        });
        masterMenu.add(petugasMenu);

        operatorMenu.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        operatorMenu.setText("Operator");
        operatorMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                operatorMenuActionPerformed(evt);
            }
        });
        masterMenu.add(operatorMenu);

        menuBar.add(masterMenu);

        utilityMenu.setText("Utilities");
        utilityMenu.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        utilityMenu.setOpaque(false);

        backresMenu.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        backresMenu.setText("Backup & Restore");
        backresMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backresMenuActionPerformed(evt);
            }
        });
        utilityMenu.add(backresMenu);

        eksporMenu.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        eksporMenu.setText("Ekspor Data");
        eksporMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eksporMenuActionPerformed(evt);
            }
        });
        utilityMenu.add(eksporMenu);

        menuBar.add(utilityMenu);

        aboutMenu.setText("Tentang Aplikasi");
        aboutMenu.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        aboutMenu.setOpaque(false);

        infoMenu.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        infoMenu.setText("Info Aplikasi");
        infoMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoMenuActionPerformed(evt);
            }
        });
        aboutMenu.add(infoMenu);

        menuBar.add(aboutMenu);

        contentScrollPane.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        contentScrollPane.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        contentScrollPane.setName("contentScrollPane"); // NOI18N
        contentScrollPane.setPreferredSize(new java.awt.Dimension(990, 520));

        footerPanel.setName("footerPanel"); // NOI18N
        footerPanel.setOpaque(false);
        footerPanel.setPreferredSize(new java.awt.Dimension(990, 30));

        textInfo.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        textInfo.setText("jLabel1");

        textWaktu.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        textWaktu.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        textWaktu.setText("jLabel1");

        org.jdesktop.layout.GroupLayout footerPanelLayout = new org.jdesktop.layout.GroupLayout(footerPanel);
        footerPanel.setLayout(footerPanelLayout);
        footerPanelLayout.setHorizontalGroup(
            footerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(footerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(textInfo, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
                .add(18, 18, 18)
                .add(textWaktu, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 275, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        footerPanelLayout.setVerticalGroup(
            footerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(footerPanelLayout.createSequentialGroup()
                .add(footerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, textInfo, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, textWaktu, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        mainPanel.setPreferredSize(new java.awt.Dimension(1014, 720));

        org.jdesktop.layout.GroupLayout mainPanelLayout = new org.jdesktop.layout.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 1008, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 704, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(mainPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 1012, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(mainPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void entriMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entriMenuActionPerformed
        // TODO add your handling code here:
        this.contentScrollPane.setViewportView(new FormDaftarDSRT(this, operator));
    }//GEN-LAST:event_entriMenuActionPerformed

    private void logoutMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutMenuActionPerformed
        // TODO add your handling code here:
        try {
            JOptionPane.showMessageDialog(this, "Anda telah logout!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            operator = "";
            this.setEnableLogin(true,2);
            this.textInfo.setText("");
            this.setTextUsername("");
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_logoutMenuActionPerformed

    private void infoMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoMenuActionPerformed
        // TODO add your handling code here:
        String pesan = "<html>SUTP2016 adalah aplikasi Monitoring Pengumpulan Data Produktivitas Tanaman Pangan 2016<br>BPS Kabupaten Sambas, Kalimantan Barat<br><br>Versi 1.0.0";
        JOptionPane pane = new JOptionPane();
        pane.setMessage(pesan);
        pane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog = pane.createDialog(null, "INFORMASI");
        dialog.setVisible(true);
    }//GEN-LAST:event_infoMenuActionPerformed

    private void dsbsMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dsbsMenuActionPerformed
        // TODO add your handling code here:
        this.contentScrollPane.setViewportView(new FormDSBS(this, operator));
    }//GEN-LAST:event_dsbsMenuActionPerformed

    private void dsrtMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dsrtMenuActionPerformed
        // TODO add your handling code here:
        this.contentScrollPane.setViewportView(new FormDSRT(this, operator));
    }//GEN-LAST:event_dsrtMenuActionPerformed

    private void petugasMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_petugasMenuActionPerformed
        // TODO add your handling code here:
        this.contentScrollPane.setViewportView(new FormPetugas(this, operator));
    }//GEN-LAST:event_petugasMenuActionPerformed

    private void operatorMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_operatorMenuActionPerformed
        // TODO add your handling code here:
        this.contentScrollPane.setViewportView(new FormOperator(this, operator));
    }//GEN-LAST:event_operatorMenuActionPerformed

    private void backresMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backresMenuActionPerformed
        // TODO add your handling code here:
        this.contentScrollPane.setViewportView(new FormBackupRestore(this, operator));
    }//GEN-LAST:event_backresMenuActionPerformed

    private void eksporMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eksporMenuActionPerformed
        // TODO add your handling code here:
        this.contentScrollPane.setViewportView(new FormEksporData(this, operator));
    }//GEN-LAST:event_eksporMenuActionPerformed

    private void progressMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_progressMenuActionPerformed
        // TODO add your handling code here:
        this.contentScrollPane.setViewportView(new FormProgressReport(this, operator));
    }//GEN-LAST:event_progressMenuActionPerformed

    private void homeMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeMenuActionPerformed
        // TODO add your handling code here:
       this.contentScrollPane.setViewportView(new HomePanel(this, operator));
    }//GEN-LAST:event_homeMenuActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu aboutMenu;
    private javax.swing.JMenuItem backresMenu;
    private javax.swing.JScrollPane contentScrollPane;
    private javax.swing.JMenuItem dsbsMenu;
    private javax.swing.JMenuItem dsrtMenu;
    private javax.swing.JMenuItem eksporMenu;
    private javax.swing.JMenuItem entriMenu;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JPanel footerPanel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JMenuItem homeMenu;
    private javax.swing.JMenuItem infoMenu;
    private javax.swing.JMenuItem logoutMenu;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenu masterMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem operatorMenu;
    private javax.swing.JMenuItem petugasMenu;
    private javax.swing.JMenuItem progressMenu;
    private javax.swing.JLabel textInfo;
    private javax.swing.JLabel textWaktu;
    private javax.swing.JMenu utilityMenu;
    // End of variables declaration//GEN-END:variables
}
