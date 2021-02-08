/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Dutan2000
 */
public class PanelAuto extends javax.swing.JPanel {

    BufferedImage img;
    double rotateAngle;

    public PanelAuto() {
        initComponents();
        img = null;
    }

    public void loadimage(String filePath) {
        try {
            img = ImageIO.read(new File(filePath));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void rotate(int angle) {
        rotateAngle = angle * 3.6;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (img != null) {
            Graphics2D g2D = (Graphics2D) g;
            g2D.translate(this.getSize().width / 2, this.getSize().height / 2);
            g2D.rotate(Math.toRadians(rotateAngle));
            g2D.drawImage(img, -img.getWidth() / 2, -img.getHeight() / 2, null);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
