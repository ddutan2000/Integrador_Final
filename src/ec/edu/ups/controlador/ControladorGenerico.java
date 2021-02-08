/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.utilidades.Utilidades;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Dutan2000
 */
public abstract class ControladorGenerico<T> {

    private Class<T> clase;
    private EntityManager em;


    public ControladorGenerico() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        clase = (Class) pt.getActualTypeArguments()[0];
        this.em = Utilidades.getEntityManager();
    }

    public void create(T objeto) {
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
    }

    public T read(Object id) {
        return (T) em.find(clase, id);
    }

    public void update(T obejto) {
        em.getTransaction().begin();
        em.merge(obejto);
        em.getTransaction().commit();
    }

    public void delete(T objeto) {
        em.getTransaction().begin();
        em.remove(em.merge(objeto));
        em.getTransaction().commit();
    }

    public List<T> findAll() {
        return em.createQuery("Select t from " + clase.getSimpleName() + " t").getResultList();
    }

    public Class<T> getClase() {
        return clase;
    }

    public void setClase(Class<T> clase) {
        this.clase = clase;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}
