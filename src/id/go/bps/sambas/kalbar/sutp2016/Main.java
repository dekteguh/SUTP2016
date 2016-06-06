/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.bps.sambas.kalbar.sutp2016;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.SplashScreen;
import java.awt.geom.Rectangle2D;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;
import org.jvnet.substance.skin.SubstanceMistAquaLookAndFeel;

/**
 *
 * @author dekteguh
 */
public class Main {
    private static SplashScreen splashScreen;
    private static Graphics2D gd;
    private static Rectangle2D.Double progressArea;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        splashInit();
        appInit();
        
        if(splashScreen != null) splashScreen.close();
        // Set Tampilan
        try {
            UIManager.setLookAndFeel(new SubstanceMistAquaLookAndFeel());
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
        } catch (Exception ex) {
        }

        //menjalankan MainFrame
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    private static void runBar(int a) {
        if (splashScreen != null && splashScreen.isVisible()) {
            gd.setPaint(Color.LIGHT_GRAY);
            gd.fill(progressArea);

            gd.setPaint(Color.BLACK);
            gd.draw(progressArea);

            int x = (int) progressArea.getMinX();
            int y = (int) progressArea.getMinY();
            int w = (int) progressArea.getWidth();
            int h = (int) progressArea.getHeight();

            int doneWidth = Math.round(a * w / 100.f);
            doneWidth = Math.max(0, Math.min(doneWidth, w - 1));  // limit 0-width

            // fill the done part one pixel smaller than the outline
            gd.setPaint(Color.DARK_GRAY);
            gd.fillRect(x, y + 1, doneWidth, h - 1);
            
            splashScreen.update();
        }
    }
    
    private static void splashInit(){
        splashScreen = SplashScreen.getSplashScreen();
        if(splashScreen != null){
            Dimension dim = splashScreen.getSize();
            int h = dim.height;
            int w = dim.width;
            
            progressArea = new Rectangle2D.Double(w * .15, h*.95, w*.7, 6 );
            
            gd = splashScreen.createGraphics();
            runBar(0);
        }
    }
    
    private static void appInit(){
        for(int i =0; i<=100; i++){
            int j = i;
            runBar(j);
            try{
                Thread.sleep(5);
            }catch(Exception ex){
                break;
            }
        }
    }
}
