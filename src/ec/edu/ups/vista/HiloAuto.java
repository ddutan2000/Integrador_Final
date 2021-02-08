/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Dutan2000
 */
public class HiloAuto extends Thread {

    private int x;
    private int y;
    private boolean continuar;
    private JPanel panel;
    private JLabel label;

    public HiloAuto(JPanel panel,int x, int y) {
        this.panel = panel;
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isContinuar() {
        return continuar;
    }

    public void setContinuar(boolean continuar) {
        this.continuar = continuar;
    }

    @Override
    public void run() {
        try {
            while (continuar) {
                if (panel.getLocation().x != x) {
                    panel.setLocation(panel.getLocation().x + 1, panel.getLocation().y);
                    Thread.sleep(25);
                } else {
                    if (panel.getLocation().y > y) {
                        if (panel.getLocation().y != y) {
                            panel.setLocation(panel.getLocation().x, panel.getLocation().y - 1);
                            Thread.sleep(25);
                        } else {
                            panel.setLocation(179, 273);
                            continuar = false;
                        }
                    } else {
                        if (panel.getLocation().y != y) {
                            panel.setLocation(panel.getLocation().x, panel.getLocation().y + 1);
                            Thread.sleep(26);
                        } else {
                            panel.setLocation(179, 273);
                            continuar = false;
                        }
                    }
                }
            }
            System.out.println("terminado el hilo");

        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

}
