/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;

/**
 *
 * @author Krista
 */
public class ProgressBarController implements Runnable {

    private JProgressBar bar;
    private ArchivoDeRegitstro secuencial;
    private int progress = 0;
    private boolean vive;

    public ProgressBarController(JProgressBar bar, ArchivoDeRegitstro secuencial) {
        this.bar = bar;
        this.secuencial = secuencial;
        bar.setMaximum(secuencial.getNoRegistros());
    }
    
    @Override
    public void run() {
        vive = true;
        while (vive) {
            
            bar.setValue(progress);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ProgressBarController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    public void stop() {
        vive = false;
    }
    
    public void setProgress(int progreso) {
        this.progress = progreso;
    }

    public JProgressBar getBar() {
        return bar;
    }

    public ArchivoDeRegitstro getSecuencial() {
        return secuencial;
    }
    
}
