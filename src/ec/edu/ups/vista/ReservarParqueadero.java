/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.*;
import ec.edu.ups.modelo.*;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Dutan2000
 */
public class ReservarParqueadero extends javax.swing.JInternalFrame {

    private Inicio inicio;
    private ControladorRegex controladorR;
    private ControladorCliente controladorC;
    private ControladorVehiculo controladorV;
    private ControladorParqueadero controladorP;
    private ControladorTicket controladorT;
    private Tipo tipoVentana;
    private String tipo;
    private String tipo1;
    private HiloAuto hiloAuto;

    private int puesto;

    private Cliente cliente = new Cliente();
    private Vehiculo vehiculo = new Vehiculo();
    private Ticket ticket;

    public ReservarParqueadero(Inicio inicio, ControladorRegex controladorRegex, ControladorCliente controladorCliente, ControladorVehiculo controladorVehiculo, ControladorParqueadero controladorParqueadero,
            ControladorTicket controladorTicket, Tipo tipoVentana) {
        initComponents();
        this.inicio = inicio;
        controladorR = controladorRegex;
        controladorC = controladorCliente;
        controladorV = controladorVehiculo;
        controladorP = controladorParqueadero;
        controladorT = controladorTicket;
        this.tipoVentana = tipoVentana;
        //switchPanel(pnlParqueadero);
        //panelAuto1.loadimage("/Users/newuser/NetBeansProjects/ParqueaderoJPA/src/ec/edu/ups/imagenes/autoVertical.png");
        //panelAuto1.invalidate();
        //panelAuto1.setVisible(false);
    }

    /*public void switchPanel(JPanel panel) {
        capaspanel.add(panel);
        capaspanel.repaint();
        capaspanel.revalidate();
    }*/

    public void limpiar() {
        txtCedula.setText("");
        cmbxVehiculo.setSelectedIndex(0);
        txtSalirParqueadero.setText("");
        txtPlaca.setText("");
        cmbxTiempo.setSelectedIndex(0);
    }

    public void visualaizarTodoDeNuevo() {
        lblCedula.setVisible(true);
        lblFechaI.setVisible(true);
        lblFechaS.setVisible(true);
        lblSalirParqueadero.setVisible(true);
        lblVehiculo.setVisible(true);
        lblServicio.setVisible(true);
        txtCedula.setVisible(true);
        txtSalirParqueadero.setVisible(true);
        btnCancelar.setVisible(true);
        btnSalirParqueadero.setVisible(true);
        cmbxFechaDeIngreso.setVisible(true);
        cmbxFechaDeSalida.setVisible(true);
        cmbxVehiculo.setVisible(true);
        lblPlaca.setVisible(true);
        txtPlaca.setVisible(true);
        lblTiempo.setVisible(true);
        cmbxTiempo.setVisible(true);
        lblPagos.setVisible(true);
    }

    public void visualizar() {
        tipo = inicio.getTipo();
        tipo1 = tipoVentana.getTipo();

        if (tipo1.equals("normalCliente")) {
            lblFechaI.setVisible(false);
            lblFechaS.setVisible(false);
            cmbxFechaDeIngreso.setVisible(false);
            cmbxFechaDeSalida.setVisible(false);
            lblSalirParqueadero.setVisible(false);
            txtSalirParqueadero.setVisible(false);
            btnSalirParqueadero.setVisible(false);
            lblPlaca.setVisible(false);
            txtPlaca.setVisible(false);
            lblTiempo.setVisible(false);
            cmbxTiempo.setVisible(false);
            lblPagos.setVisible(false);
        } else if (tipo1.equals("reservarCliente")) {
            lblSalirParqueadero.setVisible(false);
            txtSalirParqueadero.setVisible(false);
            btnSalirParqueadero.setVisible(false);
            lblPlaca.setVisible(false);
            txtPlaca.setVisible(false);
        } else if (tipo1.equals("normalNormal")) {
            lblFechaI.setVisible(false);
            lblFechaS.setVisible(false);
            cmbxFechaDeIngreso.setVisible(false);
            cmbxFechaDeSalida.setVisible(false);
            lblSalirParqueadero.setVisible(false);
            txtSalirParqueadero.setVisible(false);
            btnSalirParqueadero.setVisible(false);
            lblCedula.setVisible(false);
            lblVehiculo.setVisible(false);
            txtCedula.setVisible(false);
            cmbxVehiculo.setVisible(false);
            lblTiempo.setVisible(false);
            cmbxTiempo.setVisible(false);
            lblPagos.setVisible(false);
        } else if (tipo1.equals("reservarNormal")) {
            lblSalirParqueadero.setVisible(false);
            txtSalirParqueadero.setVisible(false);
            btnSalirParqueadero.setVisible(false);
            lblCedula.setVisible(false);
            lblVehiculo.setVisible(false);
            txtCedula.setVisible(false);
            cmbxVehiculo.setVisible(false);
        }
        if (tipo.equals("salir")) {
            lblFechaI.setVisible(false);
            lblFechaS.setVisible(false);
            lblCedula.setVisible(false);
            lblVehiculo.setVisible(false);
            txtCedula.setVisible(false);
            cmbxFechaDeIngreso.setVisible(false);
            cmbxFechaDeSalida.setVisible(false);
            cmbxVehiculo.setVisible(false);
            lblPlaca.setVisible(false);
            txtPlaca.setVisible(false);
            lblTiempo.setVisible(false);
            cmbxTiempo.setVisible(false);
            lblPagos.setVisible(false);

            btnSalirParqueadero.setVisible(true);
            lblSalirParqueadero.setVisible(true);
            txtSalirParqueadero.setVisible(true);
        }
    }

    public void actualizarCmbx(String cedula) {
        cmbxVehiculo.removeAllItems();

        cmbxVehiculo.addItem("--SELECCIONE UNA PLACA--");
        if (controladorV.vehiculosDeCliente(cedula) == null) {
        } else {
            List<Vehiculo> vehiculos = controladorV.vehiculosDeCliente(cedula);

            for (Vehiculo vehiculo : vehiculos) {
                cmbxVehiculo.addItem(vehiculo.getPlaca());
            }
        }

        cmbxVehiculo.setSelectedIndex(0);
    }

    public void limpiarCmbx() {
        cmbxVehiculo.removeAllItems();

        cmbxVehiculo.addItem("--SELECCIONE UNA PLACA--");

        cmbxVehiculo.setSelectedIndex(0);
    }

    public void actualizarPanel() {
        //lblParqueadero = new ArrayList<>();
        pnlParqueadero.removeAll();
        pnlParqueadero.setLayout(new GridLayout(5, 10, 0, 0));
        for (int i = 0; i < 50; i++) {
            JLabel labelPar = new JLabel(i + 1 + "");
            labelPar.setHorizontalTextPosition(JLabel.CENTER);
            labelPar.setVerticalTextPosition(JLabel.CENTER);
            labelPar.setBounds(i * 90, 50, 90, 110);
            labelPar.setFont(new Font("Verdana", Font.PLAIN, 14));
            if (controladorP.read(i + 1).isVacio()) {
                labelPar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/parqueadero.png")));
            } else {
                labelPar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/imagen auto1.png")));
            }

            labelPar.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Object[] opcionesJPanel = {"SI", "NO"};
                    int confirmar = JOptionPane.showOptionDialog(null, "ESTA SEGURO QUE QUIERE RESERVAR ESTE PARQUEADERO", "PARQUEADERO", JOptionPane.YES_NO_OPTION,
                            JOptionPane.INFORMATION_MESSAGE, null, opcionesJPanel, null);
                    if (JOptionPane.OK_OPTION == confirmar) {
                        if (controladorP.read(Integer.parseInt(labelPar.getText())).isVacio()) {
                            String tipo = tipoVentana.getTipo();
                            if (tipo.equals("normalCliente")) {
                                if (!txtCedula.getText().isEmpty() && cmbxVehiculo.getSelectedIndex() != 0) {
                                    vehiculo = controladorV.read(String.valueOf(cmbxVehiculo.getSelectedItem()));
                                    Calendar c = Calendar.getInstance();
                                    int puesto = Integer.parseInt(labelPar.getText());
                                    ticket = new Ticket();
                                    ticket.setFechaDeIngreso(c.getTime());
                                    ticket.setTipo("INGRESO");
                                    ticket.setTotal(0.00);
                                    ticket.setVehiculo(vehiculo.getPlaca());
                                    ticket.setPuesto(puesto);
                                    ticket.setTiempo("HORA");
                                    controladorT.ingresarParqueadero(ticket);
                                    JOptionPane.showMessageDialog(null, ticket);
                                    panelAuto1.loadimage("/Users/newuser/NetBeansProjects/ParqueaderoJPA/src/ec/edu/ups/imagenes/autoVertical.png");
                                    int x=labelPar.getX();
                                    int y=labelPar.getY();
                                    hiloAuto = new HiloAuto(panelAuto1, x,y);
                                    hiloAuto.setContinuar(true);
                                    hiloAuto.start();
                                    //falta imprimir
                                    limpiarCmbx();
                                    limpiar();
                                } else {
                                    JOptionPane.showMessageDialog(null, "EXISTEN CAMPOS VACIOS \nPRIMERO INGRESE DATOS LUEGO SELECIONE PUESTO");
                                }
                            } else if (tipo.equals("reservarCliente")) {
                                if (!txtCedula.getText().isEmpty() && cmbxVehiculo.getSelectedIndex() != 0 && cmbxTiempo.getSelectedIndex() != 0) {
                                    Calendar c = cmbxFechaDeIngreso.getSelectedDate();
                                    Calendar c1 = cmbxFechaDeSalida.getSelectedDate();
                                    int puesto = Integer.parseInt(labelPar.getText());
                                    vehiculo = controladorV.read(String.valueOf(cmbxVehiculo.getSelectedItem()));
                                    String tiempo = String.valueOf(cmbxTiempo.getSelectedItem());

                                    ticket = new Ticket();
                                    ticket.setTipo("INGRESO");
                                    ticket.setFechaDeIngreso(c.getTime());
                                    ticket.setFechaDeSalida(c1.getTime());
                                    ticket.setTotal(0.00);
                                    ticket.setVehiculo(vehiculo.getPlaca());
                                    ticket.setPuesto(puesto);
                                    ticket.setTiempo(tiempo);
                                    controladorT.ingresarParqueadero(ticket);
                                    JOptionPane.showMessageDialog(null, ticket);
                                    //falta imprimir tocket
                                    limpiarCmbx();
                                    limpiar();

                                } else {
                                    JOptionPane.showMessageDialog(null, "EXISTEN CAMPOS VACIOS \nPRIMERO INGRESE DATOS LUEGO SELECIONES PUESTO");
                                }
                            } else if (tipo.equals("normalNormal")) {
                                if (!txtPlaca.getText().isEmpty()) {
                                    controladorR.ingreseRegex("^[A-Z]{3}-\\d{4}$");
                                    boolean fPlaca = controladorR.validar(txtPlaca.getText());
                                    if (fPlaca) {
                                        if (controladorC.read("1") == null) {
                                            cliente = new Cliente();
                                            cliente.setCedula(1 + "");
                                            cliente.setTipo("NORMAL");
                                            vehiculo = new Vehiculo();
                                            vehiculo.setPlaca(txtPlaca.getText());
                                            vehiculo.setCliente(cliente);
                                            controladorC.create(cliente);
                                            controladorV.create(vehiculo);
                                            Calendar c = Calendar.getInstance();
                                            int puesto = Integer.parseInt(labelPar.getText());
                                            ticket = new Ticket();
                                            ticket.setTipo("INGRESO");
                                            ticket.setFechaDeIngreso(c.getTime());
                                            ticket.setTotal(0.00);
                                            ticket.setVehiculo(vehiculo.getPlaca());
                                            ticket.setPuesto(puesto);
                                            ticket.setTiempo("HORA");
                                            controladorT.ingresarParqueadero(ticket);
                                            JOptionPane.showMessageDialog(null, ticket);
                                            //falta imprimir ticket
                                            limpiar();
                                        } else {
                                            cliente = controladorC.read("1");
                                            vehiculo = new Vehiculo();
                                            vehiculo.setPlaca(txtPlaca.getText());
                                            vehiculo.setCliente(cliente);
                                            controladorV.create(vehiculo);
                                            Calendar c = Calendar.getInstance();
                                            int puesto = Integer.parseInt(labelPar.getText());
                                            ticket = new Ticket();
                                            ticket.setTipo("INGRESO");
                                            ticket.setFechaDeIngreso(c.getTime());
                                            ticket.setTotal(0.00);
                                            ticket.setVehiculo(vehiculo.getPlaca());
                                            ticket.setPuesto(puesto);
                                            ticket.setTiempo("HORA");
                                            controladorT.ingresarParqueadero(ticket);
                                            JOptionPane.showMessageDialog(null, ticket);
                                            //falta imprimir ticket
                                            limpiar();
                                        }

                                    } else {
                                        JOptionPane.showMessageDialog(null, "FORMATO DE PLACA NO VALIDO \nEJEMPLO: AAA-0000");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "EL CAMPO DE PLACA ESTA VACIO");
                                }
                            } else if (tipo.equals("reservarNormal")) {
                                if (!txtPlaca.getText().isEmpty() && cmbxTiempo.getSelectedIndex() != 0) {
                                    controladorR.ingreseRegex("^[A-Z]{3}-\\d{4}$");
                                    boolean fPlaca = controladorR.validar(txtPlaca.getText());
                                    if (fPlaca) {
                                        if (controladorC.read("1") == null) {
                                            cliente = new Cliente();
                                            cliente.setTipo("NORMAL");
                                            cliente.setCedula(1 + "");
                                            vehiculo = new Vehiculo();
                                            vehiculo.setPlaca(txtPlaca.getText());
                                            vehiculo.setCliente(cliente);
                                            controladorC.create(cliente);
                                            controladorV.create(vehiculo);
                                            int puesto = Integer.parseInt(labelPar.getText());
                                            Calendar c = cmbxFechaDeIngreso.getSelectedDate();
                                            Calendar c1 = cmbxFechaDeSalida.getSelectedDate();
                                            String tiempo = String.valueOf(cmbxTiempo.getSelectedItem());
                                            ticket = new Ticket();
                                            ticket.setTipo("INGRESO");
                                            ticket.setFechaDeIngreso(c.getTime());
                                            ticket.setFechaDeSalida(c1.getTime());
                                            ticket.setTotal(0.00);
                                            ticket.setVehiculo(vehiculo.getPlaca());
                                            ticket.setPuesto(puesto);
                                            ticket.setTiempo(tiempo);
                                            controladorT.ingresarParqueadero(ticket);
                                            JOptionPane.showMessageDialog(null, ticket);
                                            limpiar();
                                        } else {
                                            cliente = controladorC.read("1");
                                            vehiculo = new Vehiculo();
                                            vehiculo.setPlaca(txtPlaca.getText());
                                            vehiculo.setCliente(cliente);
                                            controladorV.create(vehiculo);
                                            int puesto = Integer.parseInt(labelPar.getText());
                                            Calendar c = cmbxFechaDeIngreso.getSelectedDate();
                                            Calendar c1 = cmbxFechaDeSalida.getSelectedDate();
                                            String tiempo = String.valueOf(cmbxTiempo.getSelectedItem());
                                            ticket = new Ticket();
                                            ticket.setTipo("INGRESO");
                                            ticket.setFechaDeIngreso(c.getTime());
                                            ticket.setFechaDeSalida(c1.getTime());
                                            ticket.setTotal(0.00);
                                            ticket.setVehiculo(vehiculo.getPlaca());
                                            ticket.setPuesto(puesto);
                                            ticket.setTiempo(tiempo);
                                            controladorT.ingresarParqueadero(ticket);
                                            JOptionPane.showMessageDialog(null, ticket);
                                            limpiar();
                                        }

                                    } else {
                                        JOptionPane.showMessageDialog(null, "FORMATO DE PLACA NO VALIDO \nEJEMPLO: AAA-0000");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "EL CAMPO DE PLACA ESTA VACIO");
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "LO SIENTO ESPCACIO OCUPADO");
                        }
                    }
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
            pnlParqueadero.add(labelPar);

        }
        pnlParqueadero.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        pnlParqueadero.updateUI();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFechaS = new javax.swing.JLabel();
        cmbxTiempo = new javax.swing.JComboBox<>();
        lblServicio = new javax.swing.JLabel();
        lblPagos = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblCedula = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        lblSalirParqueadero = new javax.swing.JLabel();
        lblVehiculo = new javax.swing.JLabel();
        txtSalirParqueadero = new javax.swing.JTextField();
        cmbxVehiculo = new javax.swing.JComboBox<>();
        btnSalirParqueadero = new javax.swing.JButton();
        cmbxFechaDeIngreso = new datechooser.beans.DateChooserCombo();
        lblPlaca = new javax.swing.JLabel();
        cmbxFechaDeSalida = new datechooser.beans.DateChooserCombo();
        txtPlaca = new javax.swing.JTextField();
        lblFechaI = new javax.swing.JLabel();
        lblTiempo = new javax.swing.JLabel();
        pnlParqueadero = new javax.swing.JPanel();
        panelAuto1 = new ec.edu.ups.vista.PanelAuto();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        lblFechaS.setText("FECHA DE SALIDA");

        cmbxTiempo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--ELIJA UNA OPCION--", "DIA", "MES", "AÑO" }));

        lblServicio.setText("SERVICIO");

        lblPagos.setText("DIA: $3,00   MES:$18,00  AÑO:$50,00");

        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblCedula.setText("CEDULA:");

        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaKeyTyped(evt);
            }
        });

        lblSalirParqueadero.setText("INGRESE TICKET:");

        lblVehiculo.setText("VEHICULO:");

        cmbxVehiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--SELLECIONES UNA PLACA--" }));

        btnSalirParqueadero.setText("EGRESO");
        btnSalirParqueadero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirParqueaderoActionPerformed(evt);
            }
        });

        lblPlaca.setText("PLACA:");

        lblFechaI.setText("FECHA DE INCIO");

        lblTiempo.setText("TIEMPO");

        pnlParqueadero.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout pnlParqueaderoLayout = new javax.swing.GroupLayout(pnlParqueadero);
        pnlParqueadero.setLayout(pnlParqueaderoLayout);
        pnlParqueaderoLayout.setHorizontalGroup(
            pnlParqueaderoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 873, Short.MAX_VALUE)
        );
        pnlParqueaderoLayout.setVerticalGroup(
            pnlParqueaderoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 376, Short.MAX_VALUE)
        );

        panelAuto1.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout panelAuto1Layout = new javax.swing.GroupLayout(panelAuto1);
        panelAuto1.setLayout(panelAuto1Layout);
        panelAuto1Layout.setHorizontalGroup(
            panelAuto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 96, Short.MAX_VALUE)
        );
        panelAuto1Layout.setVerticalGroup(
            panelAuto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(192, 192, 192))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbxFechaDeIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblFechaI))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cmbxFechaDeSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblFechaS)
                                        .addGap(47, 47, 47))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblVehiculo)
                                    .addComponent(lblCedula))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbxVehiculo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPlaca)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPagos)
                            .addComponent(lblTiempo)
                            .addComponent(cmbxTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(361, 361, 361)
                        .addComponent(lblServicio)
                        .addGap(169, 169, 169))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblSalirParqueadero)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtSalirParqueadero, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnSalirParqueadero)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)))
                        .addGap(24, 24, 24))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelAuto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlParqueadero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(pnlParqueadero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelAuto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(137, 137, 137)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblServicio)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblSalirParqueadero)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSalirParqueadero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSalirParqueadero))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 34, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblPagos)
                                .addGap(16, 16, 16)
                                .addComponent(lblTiempo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbxTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblFechaI)
                                    .addComponent(lblFechaS))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cmbxFechaDeIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbxFechaDeSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblCedula)
                                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblVehiculo)
                                    .addComponent(cmbxVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPlaca)
                            .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        Object[] opcionesJPanel = {"SI", "NO"};
        int confirmar = JOptionPane.showOptionDialog(null, "ESTA SEGURO QUE DESEAS REGRESAR", "PARQUEADERO", JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, opcionesJPanel, null);

        if (JOptionPane.OK_OPTION == confirmar) {
            inicio.setVisible(true);
            visualaizarTodoDeNuevo();
            this.setVisible(false);
            limpiar();
        } else {
            System.out.println("hacer nada");
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyTyped
        char tipo = evt.getKeyChar();

        if (tipo == '\n') {
            if (!txtCedula.getText().isEmpty()) {
                cliente = controladorC.read(txtCedula.getText());
                if (cliente != null) {
                    actualizarCmbx(cliente.getCedula());
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR-CLIENTE NO EXISTE");
                }
            } else {
                JOptionPane.showMessageDialog(null, "ERROR- AREA DE CEDULA ESTA VACIA");
            }
        } else {
            System.out.println("nada");
        }
    }//GEN-LAST:event_txtCedulaKeyTyped

    private void btnSalirParqueaderoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirParqueaderoActionPerformed
        if (!txtSalirParqueadero.getText().isEmpty()) {
            ticket = controladorT.read(Integer.parseInt(txtSalirParqueadero.getText()));
            if (ticket != null) {
                Ticket ticket1 = controladorT.calcularPAgo(ticket.getId());
                JOptionPane.showMessageDialog(null, ticket1);
                controladorT.salidaParqueadero(ticket1);
                JOptionPane.showMessageDialog(null, "GRACIAS POR HACER NEGOCIOS CON NOSOTROS \nVUELVA DE NUEVO");
                txtSalirParqueadero.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "TICKET NO EXISTE");
            }
        } else {
            JOptionPane.showMessageDialog(null, "CAMPO DE TICKET ESTA VACIO");
        }
    }//GEN-LAST:event_btnSalirParqueaderoActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        actualizarPanel();
        visualizar();
    }//GEN-LAST:event_formInternalFrameActivated

    public void setVistaInicio(Inicio inicio) {
        this.inicio = inicio;
    }

    public void setVistaTipo(Tipo tipo) {
        this.tipoVentana = tipo;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalirParqueadero;
    private datechooser.beans.DateChooserCombo cmbxFechaDeIngreso;
    private datechooser.beans.DateChooserCombo cmbxFechaDeSalida;
    private javax.swing.JComboBox<String> cmbxTiempo;
    private javax.swing.JComboBox<String> cmbxVehiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblFechaI;
    private javax.swing.JLabel lblFechaS;
    private javax.swing.JLabel lblPagos;
    private javax.swing.JLabel lblPlaca;
    private javax.swing.JLabel lblSalirParqueadero;
    private javax.swing.JLabel lblServicio;
    private javax.swing.JLabel lblTiempo;
    private javax.swing.JLabel lblVehiculo;
    private ec.edu.ups.vista.PanelAuto panelAuto1;
    private javax.swing.JPanel pnlParqueadero;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtSalirParqueadero;
    // End of variables declaration//GEN-END:variables
}
