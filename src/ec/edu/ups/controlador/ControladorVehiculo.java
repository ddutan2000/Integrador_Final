/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Vehiculo;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Dutan2000
 */
public class ControladorVehiculo extends ControladorGenerico<Vehiculo>{
    
        public List<Vehiculo> vehiculosDeCliente(String cedula) {
        String queryString = "Select * from vehiculo as v "
                + "where v.fk_persona like ?";
        Query query = getEm().createNativeQuery(queryString, Vehiculo.class);
        List<Vehiculo> vehiculo = query.setParameter(1, cedula).getResultList();
        if (vehiculo.size()> 0) {
            return vehiculo;
        } 
        return null;
    }
}
