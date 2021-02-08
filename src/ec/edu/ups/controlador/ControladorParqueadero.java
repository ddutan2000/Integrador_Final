/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;
import ec.edu.ups.modelo.Parqueadero;

/**
 *
 * @author Dutan2000
 */
public class ControladorParqueadero extends ControladorGenerico<Parqueadero>{
    
    private Parqueadero parqueadero;
    
    public void liberar(int puesto){
        parqueadero=super.read(puesto);
        parqueadero.setVacio(true);
        super.update(parqueadero);
    }
    
    public void reservar(int puesto){
        parqueadero=super.read(puesto);
        parqueadero.setVacio(false);
        super.update(parqueadero);
    }
}
