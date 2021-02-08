/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Dutan2000
 */
@Entity
public class Parqueadero implements Serializable {

    
    @Id
    @Column
    private int puesto;
    @Column
    private boolean vacio;

    public int getPuesto() {
        return puesto;
    }

    public void setPuesto(int puesto) {
        this.puesto = puesto;
    }

    public boolean isVacio() {
        return vacio;
    }

    public void setVacio(boolean vacio) {
        this.vacio = vacio;
    }

    @Override
    public String toString() {
        return "Parqueadero" + "\nPuesto:" + puesto + "\nVacio:" + vacio;
    }
    
    
    
}
