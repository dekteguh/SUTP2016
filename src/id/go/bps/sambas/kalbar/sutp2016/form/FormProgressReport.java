/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.bps.sambas.kalbar.sutp2016.form;

import id.go.bps.sambas.kalbar.sutp2016.MainFrame;
import id.go.bps.sambas.kalbar.sutp2016.functions.UtilitasService;
import id.go.bps.sambas.kalbar.sutp2016.resources.ResourceLoader;
import id.go.bps.sambas.kalbar.sutp2016.resources.Strings;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author dekteguh
 */
public class FormProgressReport extends javax.swing.JPanel {

    private MainFrame mainFrame;
    private String username;
    ArrayList<Properties> list;

    /**
     * Creates new form PesertaForm
     */
    public FormProgressReport(MainFrame frame, String username) {
        this.mainFrame = frame;
        this.username = username;
        initComponents();
        //this.loadAwal();
        //this.mainFrame.setContentPane(chartPanel);

        cmbProgress.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadProgress(cmbProgress.getSelectedIndex());
            }
        });
    }

    private void loadProgress(int option) {
        if (option == 0) {
            JOptionPane.showMessageDialog(this, "Pilihan progress belum dipilih.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            loadAwal(option);
        }
    }

    private void loadAwal(int option) {
        CategoryDataset dataset = createDataset(option);
        JFreeChart chart = createChart(dataset, option);
        ChartPanel chartPanel = new ChartPanel(chart, false);
        jPanel2.setLayout(new BorderLayout());
        jPanel2.add(chartPanel, BorderLayout.NORTH);
    }

    private GradientPaint getwarna(double nilai) {
        GradientPaint gp = null;
        if (nilai >= 0.0 && nilai <= 50.0) {
            gp = new GradientPaint(0.0f, 0.0f, Color.red,
                    0.0f, 0.0f, new Color(0, 0, 64));
        } else if (nilai > 50.0 && nilai <= 80.0) {
            gp = new GradientPaint(0.0f, 0.0f, Color.yellow,
                    0.0f, 0.0f, new Color(0, 0, 64));
        } else if (nilai > 80.0 && nilai <= 100.0) {
            gp = new GradientPaint(0.0f, 0.0f, Color.green,
                    0.0f, 0.0f, new Color(0, 0, 64));
        }
        return gp;
    }

    private static CategoryDataset createDataset(int option) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try {
            String series;
            ArrayList<Properties> arr;
            if (option == 1) {
                series = "Berhasil Ubinan";
                arr = UtilitasService.getProgress(1);
                for (Properties prop : arr) {
                    dataset.addValue(Double.valueOf(prop.getProperty("persentase")) * 100, series, prop.getProperty("nks"));
                }
            } else if (option == 2) {
                series = "Berhasil Ubinan";
                arr = UtilitasService.getProgress(2);
                for (Properties prop : arr) {
                    dataset.addValue(Double.valueOf(prop.getProperty("persentase")) * 100, series, prop.getProperty("nama_pcl"));
                }
            } else if (option == 3) {
                series = "Berhasil Ubinan";
                arr = UtilitasService.getProgress(3);
                for (Properties prop : arr) {
                    dataset.addValue(Double.valueOf(prop.getProperty("persentase")) * 100, series, prop.getProperty("jenis_tanaman"));
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return dataset;
    }

    private JFreeChart createChart(CategoryDataset dataset, int option) {
        String[] nil = {"NKS", "Petugas Lapangan", "Komoditas"};
        String[] nul = {"Persentase (%)", "Persentase (%)", "Persentase (%)"};
        Color[] warna = {Color.BLUE, Color.GREEN, Color.ORANGE};
        JFreeChart chart = ChartFactory.createBarChart(
                "", nil[option - 1], nul[option - 1], dataset, PlotOrientation.HORIZONTAL, true, true, true);
        chart.setBackgroundPaint(Color.WHITE);
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);//warna Background
        plot.setDomainGridlinePaint(Color.BLACK);//warna Grid
        plot.setDomainGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);

        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);

        GradientPaint gp0 = new GradientPaint(0.0f, 0.0f, warna[option - 1],
                0.0f, 0.0f, Color.DARK_GRAY);
        renderer.setSeriesPaint(0, gp0);
        return chart;
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
        btnEksporPDF = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cmbProgress = new javax.swing.JComboBox();

        setPreferredSize(new java.awt.Dimension(980, 500));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PROGRESS REPORT MONITORING PENGUMPULAN DATA PRODUKTIVITAS TANAMAN PANGAN 2016");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnEksporPDF.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnEksporPDF.setText("Ekspor ke PNG");
        btnEksporPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEksporPDFActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 956, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 335, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel2.setText("Pilih Progress:");

        cmbProgress.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Pilihan Progress Report-", "1. Persentase hasil pengumpulan data produktivitas tanaman pangan berdasarkan nks", "2. Jumlah Ruta yang berhasil dilakukan pendataan berdasarkan petugas lapangan dan nks", "3. Jumlah Ruta yang berhasil dilakukan pendataan berdasarkan komoditas" }));

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 956, Short.MAX_VALUE)
                            .add(btnEksporPDF)
                            .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(20, 20, 20)
                        .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 106, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cmbProgress, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 762, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 33, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(cmbProgress, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(12, 12, 12)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(btnEksporPDF)
                .addContainerGap())
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEksporPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEksporPDFActionPerformed
        // TODO add your handling code here:
        String pesan = "<html>Silahkan KLIK KANAN pada Chart<br>Pilih SAVE AS > PNG <br>";
        JOptionPane pane = new JOptionPane();
        pane.setMessage(pesan);
        pane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog = pane.createDialog(null, "INFORMASI");
        dialog.setVisible(true);
    }//GEN-LAST:event_btnEksporPDFActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEksporPDF;
    private javax.swing.JComboBox cmbProgress;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
