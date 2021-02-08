/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.*;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 *
 * @author Dutan2000
 */
public class MenuPrincipal extends javax.swing.JFrame {

    private ControladorCliente controladorC;
    private ControladorParqueadero controladorP;
    private ControladorRegex controladorR;
    private ControladorTicket controladorT;
    private ControladorUsuario controladorU;
    private ControladorVehiculo controladorV;

    private IniciarSession iniciarS;
    private Inicio inicio;
    private RegistrarAdministrador registrarA;
    private RegistrarCliente registrarC;
    private RegistrarVehiculo registrarV;
    private ReservarParqueadero reservarP;
    private Tipo tipo;
    private VentanaAdministrador ventanaA;

    public MenuPrincipal() {
        initComponents();
        
        controladorC=new ControladorCliente();
        controladorP=new ControladorParqueadero();
        controladorR=new ControladorRegex();
        controladorT=new ControladorTicket(controladorP);
        controladorU=new ControladorUsuario();
        controladorV=new ControladorVehiculo();
        
        iniciarS=new IniciarSession(this, controladorU);
        registrarC=new RegistrarCliente(controladorR, controladorC, inicio);
        registrarA=new RegistrarAdministrador(controladorU, controladorR);
        reservarP=new ReservarParqueadero(inicio, controladorR, controladorC, controladorV, controladorP, controladorT, tipo);
        tipo=new Tipo(reservarP, inicio);
        reservarP.setVistaTipo(tipo);
        registrarV=new RegistrarVehiculo(controladorV, controladorC, controladorR, inicio);
        inicio=new Inicio(reservarP, registrarV, registrarC, tipo);
        tipo.setVistaInicio(inicio);
        reservarP.setVistaInicio(inicio);
        registrarV.setVistaInicio(inicio);
        registrarC.setVistaInicio(inicio);

        ventanaA=new VentanaAdministrador(controladorT, controladorP, controladorR);
        
        desktopPane.add(iniciarS);
        desktopPane.add(inicio);
        desktopPane.add(registrarA);
        desktopPane.add(registrarC);
        desktopPane.add(registrarV);
        desktopPane.add(reservarP);
        desktopPane.add(tipo);
        desktopPane.add(ventanaA);
        
        MenuA.setVisible(false);
        itemCerrarS.setVisible(false);
        inicio.setVisible(true);

    }

    public JMenu getMenuAdministrador(){
        return MenuA;
    }
    
    public JMenuItem getItemCerrarSession (){
        return itemCerrarS;
    }
    
    public JMenuItem getItemInicioSession (){
        return itemIniciarS;
    }
    
    public JMenuItem getItemRegistrar (){
        return itenMenuRegistrarU;
    }           
                

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        Menu = new javax.swing.JMenu();
        itenMenuRegistrarU = new javax.swing.JMenuItem();
        itemIniciarS = new javax.swing.JMenuItem();
        itemCerrarS = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        MenuA = new javax.swing.JMenu();
        itemMenuA = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        desktopPane.setLayout(null);

        Menu.setMnemonic('f');
        Menu.setText("MENU");

        itenMenuRegistrarU.setMnemonic('o');
        itenMenuRegistrarU.setText("R. USUARIO");
        itenMenuRegistrarU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itenMenuRegistrarUActionPerformed(evt);
            }
        });
        Menu.add(itenMenuRegistrarU);

        itemIniciarS.setMnemonic('s');
        itemIniciarS.setText("I. SESSION");
        itemIniciarS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemIniciarSActionPerformed(evt);
            }
        });
        Menu.add(itemIniciarS);

        itemCerrarS.setMnemonic('a');
        itemCerrarS.setText("CERRAR SESSION");
        itemCerrarS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCerrarSActionPerformed(evt);
            }
        });
        Menu.add(itemCerrarS);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("EXIT");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        Menu.add(exitMenuItem);

        menuBar.add(Menu);

        MenuA.setMnemonic('e');
        MenuA.setText("ADMINISTRADOR");

        itemMenuA.setMnemonic('t');
        itemMenuA.setText("MENU A.");
        itemMenuA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuAActionPerformed(evt);
            }
        });
        MenuA.add(itemMenuA);

        menuBar.add(MenuA);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void itemMenuAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuAActionPerformed

        ventanaA.setVisible(true);

    }//GEN-LAST:event_itemMenuAActionPerformed

    private void itenMenuRegistrarUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itenMenuRegistrarUActionPerformed

        registrarA.setVisible(true);

    }//GEN-LAST:event_itenMenuRegistrarUActionPerformed

    private void itemIniciarSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemIniciarSActionPerformed

        iniciarS.setVisible(true);

    }//GEN-LAST:event_itemIniciarSActionPerformed

    private void itemCerrarSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCerrarSActionPerformed
        MenuA.setVisible(false);
        itemCerrarS.setVisible(false);
        itemIniciarS.setVisible(true);
        itenMenuRegistrarU.setVisible(true);
    }//GEN-LAST:event_itemCerrarSActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Menu;
    private javax.swing.JMenu MenuA;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenuItem itemCerrarS;
    private javax.swing.JMenuItem itemIniciarS;
    private javax.swing.JMenuItem itemMenuA;
    private javax.swing.JMenuItem itenMenuRegistrarU;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

}
