/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.*;
import ec.edu.ups.modelo.*;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dutan2000
 */
public class VentanaAdministrador extends javax.swing.JInternalFrame {

    private ControladorTicket controladorT;
    private ControladorParqueadero controladorP;
    private ControladorRegex controladorR;
    private Parqueadero p;

    public VentanaAdministrador(ControladorTicket controladorTicket, ControladorParqueadero controladorParqueadero, ControladorRegex controladorRegex) {
        initComponents();
        controladorT = controladorTicket;
        controladorP = controladorParqueadero;
        controladorR = controladorRegex;
    }

    public void actualizarVista(List<Ticket> tickets) {
        DefaultTableModel modelo = (DefaultTableModel) tablaDatos.getModel();
        modelo.setRowCount(0);
        if (tickets == null) {
            JOptionPane.showMessageDialog(null, "NO EXISTE UN REGISTRO DE TICKETS EN EL SISTEMA");
        }
        for (Ticket ticket : tickets) {
            Object[] fila = new Object[6];
            fila[0] = ticket.getId();
            fila[1] = ticket.getFechaDeIngreso().toString();
            if (ticket.getFechaDeSalida() == null) {
                fila[2] = null;
            } else {
                fila[2] = ticket.getFechaDeSalida().toString();
            }
            fila[3] = ticket.getTotal();
            fila[4] = ticket.getVehiculo();
            fila[5] = ticket.getPuesto();
            modelo.addRow(fila);
        }
        tablaDatos.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCrearEspacios2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDatos = new javax.swing.JTable();
        btnListarTiketsDeuda = new javax.swing.JButton();
        btnListarTicketsPagados = new javax.swing.JButton();
        btnListarTodosTicktes = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtEspacios = new javax.swing.JTextField();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        btnCrearEspacios2.setText("CREAR");
        btnCrearEspacios2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearEspacios2ActionPerformed(evt);
            }
        });

        tablaDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "# TICKET", "FECHA DE INGRESO", "FECHA DE SALIDA", "TOTAL", "PLACA", "LOTE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane1.setViewportView(tablaDatos);

        btnListarTiketsDeuda.setText("LISTA TICKETS POR PAGAR");
        btnListarTiketsDeuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarTiketsDeudaActionPerformed(evt);
            }
        });

        btnListarTicketsPagados.setText("LISTA TICKETS PAGADOS");
        btnListarTicketsPagados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarTicketsPagadosActionPerformed(evt);
            }
        });

        btnListarTodosTicktes.setText("TODOS TICKETS ");
        btnListarTodosTicktes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarTodosTicktesActionPerformed(evt);
            }
        });

        btnImprimir.setText("IMPRIMIR");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Al Nile", 1, 24)); // NOI18N
        jLabel1.setText("ADMINISTRADOR");

        jLabel2.setText("CREAR ESPACIOS DE PARQUEADEROS:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(342, 342, 342)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(txtEspacios, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(btnCrearEspacios2)
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnImprimir)
                                    .addComponent(btnListarTodosTicktes, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnListarTicketsPagados, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(btnListarTiketsDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnListarTodosTicktes, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnListarTiketsDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnListarTicketsPagados, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCrearEspacios2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEspacios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearEspacios2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearEspacios2ActionPerformed
        Object[] opcionesJPanel = {"SI", "NO"};

        controladorR.ingreseRegex("^\\d+$");
        boolean fEspacios = controladorR.validar(txtEspacios.getText());
        if (fEspacios) {
            int confirmar = JOptionPane.showOptionDialog(null, "ESTA SEGURO DE QUE DESEA CREAR ESTOS ESPACIOS", "PARQUEADERO", JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, opcionesJPanel, null);
            if (JOptionPane.OK_OPTION == confirmar) {
                int espacios = Integer.parseInt(txtEspacios.getText());

                for (int i = 0; i < espacios; i++) {
                    p = new Parqueadero();
                    p.setPuesto((i + 1));
                    p.setVacio(true);
                    controladorP.create(p);
                }
                JOptionPane.showMessageDialog(null, "ESPACIOS CREADOS EXITOSAMENTE");
                txtEspacios.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(null, "SOLO INGRESAR VALORES NUMERICOS");
        }
    }//GEN-LAST:event_btnCrearEspacios2ActionPerformed

    private void btnListarTiketsDeudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarTiketsDeudaActionPerformed
        actualizarVista(controladorT.ticketPorCobrar());
    }//GEN-LAST:event_btnListarTiketsDeudaActionPerformed

    private void btnListarTicketsPagadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarTicketsPagadosActionPerformed
        actualizarVista(controladorT.ticketCobrados());
    }//GEN-LAST:event_btnListarTicketsPagadosActionPerformed

    private void btnListarTodosTicktesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarTodosTicktesActionPerformed
        actualizarVista(controladorT.findAll());
    }//GEN-LAST:event_btnListarTodosTicktesActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        /*MessageFormat header = new MessageFormat("REPORTE DE INGRESO DIARIO");
        MessageFormat footer = new MessageFormat("PAGE[0,NUMBER,INTEGER]");
        try {
            tablaDatos.print(JTable.PrintMode.NORMAL, header, footer);
        } catch (java.awt.print.PrinterException e) {
            System.err.format("cannot print %s%n", e.getMessage());
        }*/

    }//GEN-LAST:event_btnImprimirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearEspacios2;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnListarTicketsPagados;
    private javax.swing.JButton btnListarTiketsDeuda;
    private javax.swing.JButton btnListarTodosTicktes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaDatos;
    private javax.swing.JTextField txtEspacios;
    // End of variables declaration//GEN-END:variables
}
