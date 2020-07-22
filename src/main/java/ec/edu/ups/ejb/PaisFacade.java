package ec.edu.ups.ejb;

import ec.edu.ups.entidad.Pais;
import ec.edu.ups.entidad.Producto;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PaisFacade extends AbstractFacade<Pais> {
    @PersistenceContext(unitName = "Practica03.EJB.JSF.JPA")
    private EntityManager entityManager;

    public PaisFacade(){
        super(Pais.class);
    }

    @Override
    protected  EntityManager getEntityManager(){
        return entityManager;
    }



    public Pais findPais(String nombre){
        String query=" SELECT p FROM Pais p WHERE p.nombre= '"+nombre+"';";
        return (Pais) getEntityManager().createQuery(query).getSingleResult();
    }
}
