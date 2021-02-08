/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Usuario;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Dutan2000
 */
public class ControladorUsuario extends ControladorGenerico<Usuario> {

    public boolean validar(String correo, String contrasenia) {

        String queryString = "Select * from usuario as u "
                + "where u.correo like ? and u.contrasenia like ?";
        Query query = getEm().createNativeQuery(queryString, Usuario.class);
        List<Usuario> usuarios = query.setParameter(1, correo).setParameter(2, contrasenia).getResultList();
        if (usuarios.size() == 1) {
            return true;
        } else {
            return false;
        }
    }
}
