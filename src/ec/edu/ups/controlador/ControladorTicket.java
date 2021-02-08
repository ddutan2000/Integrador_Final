/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Ticket;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Dutan2000
 */
public class ControladorTicket extends ControladorGenerico<Ticket> {

    private Ticket ticketInterno;
    private ControladorParqueadero controladorp;

    public ControladorTicket(ControladorParqueadero controladorp) {
        this.controladorp = controladorp;
    }


    public void ingresarParqueadero(Ticket ticket) {
        super.create(ticket);
        controladorp.reservar(ticket.getPuesto());
    }

    public void salidaParqueadero(Ticket ticket) {
        super.update(ticket);
        controladorp.liberar(ticket.getPuesto());
    }

    public Ticket calcularPAgo(int codigo) {
        ticketInterno = super.read(codigo);
        ticketInterno=CalcularTotal(ticketInterno.getTiempo());
        return ticketInterno;
    }

    public Ticket CalcularTotal(String tiempo) {
        double precio = 0;
        SimpleDateFormat formato = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
        if (tiempo.equals("HORA")) {
            try {
                precio = 0.60;
                Date d = Calendar.getInstance().getTime();
                String strDate = dateFormat.format(d);
                Date d1 = formato.parse(strDate);
                ticketInterno.setFechaDeSalida(d1);
                long millisIngreso = ticketInterno.getFechaDeIngreso().getTime();
                long millisSalida = ticketInterno.getFechaDeSalida().getTime();
                long milisDiferencia = millisSalida - millisIngreso;
                milisDiferencia = milisDiferencia / 3600000;
                long redondiado = Math.round(milisDiferencia);
                ticketInterno.setHoras(Integer.parseInt(redondiado + ""));
                if (redondiado == 0) {
                    ticketInterno.setTotal(precio);
                    return ticketInterno;
                } else {
                    ticketInterno.setTotal(precio * (redondiado));
                    return ticketInterno;
                }
            } catch (ParseException ex) {
                ex.printStackTrace();
            }

        } else if (tiempo.equals("DIA")) {
            precio = 3.00;
            LocalDate fechaIngreso = ticketInterno.getFechaDeIngreso().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate fechaSalida = ticketInterno.getFechaDeSalida().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int dias = Period.between(fechaIngreso, fechaSalida).getDays();
            if (dias == 0) {
                ticketInterno.setTotal(precio);
                return ticketInterno;
            } else {
                ticketInterno.setTotal(precio * dias);
                return ticketInterno;
            }
        } else if (tiempo.equals("MES")) {
            precio = 18.00;
            LocalDate fechaIngreso = ticketInterno.getFechaDeIngreso().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate fechaSalida = ticketInterno.getFechaDeSalida().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int meses = Period.between(fechaIngreso, fechaSalida).getMonths();
            if (meses == 0) {
                ticketInterno.setTotal(precio);
                return ticketInterno;
            } else {
                ticketInterno.setTotal(precio * meses);
                return ticketInterno;
            }

        } else if (tiempo.equals("AÑO")) {
            precio=50;
            LocalDate fechaIngreso = ticketInterno.getFechaDeIngreso().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate fechaSalida = ticketInterno.getFechaDeIngreso().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int anos = Period.between(fechaIngreso, fechaSalida).getYears();
            if (anos == 0) {
                ticketInterno.setTotal(precio);
                return ticketInterno;
            } else {
                ticketInterno.setTotal(precio * anos);
                return ticketInterno;
            }
        }
        return ticketInterno;
    }

    public List<Ticket> ticketPorCobrar() {
        String queryString = "Select * from ticket as t "
                + "where t.tipo like ?";
        Query query = getEm().createNativeQuery(queryString, Ticket.class);
        List<Ticket> tickets = query.setParameter(1, "INGRESO").getResultList();
        if (tickets.size() > 0) {
            return tickets;
        }
        return null;
    }

    public List<Ticket> ticketCobrados() {
        String queryString = "Select * from ticket as t "
                + "where t.tipo like ?";
        Query query = getEm().createNativeQuery(queryString, Ticket.class);
        List<Ticket> tickets = query.setParameter(1, "SALIDA").getResultList();
        if (tickets.size() > 0) {
            return tickets;
        }
        return null;
    }
}
