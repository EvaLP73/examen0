package org.example.repositorios;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.example.entidades.Director;
import org.example.entidades.Instituto;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class InstitutoRepositorio {
    private Session session;


    public InstitutoRepositorio(Session session) {
        this.session = session;
    }

    public void crearInstituto(String nombreInstituto, String telefono, int director) {
        Transaction trx=null;
        try {
            trx=session.beginTransaction();

            Instituto instituto = new Instituto();
            instituto.setNombre(nombreInstituto);
            instituto.setTelefono(telefono);
            instituto.setDirectorId(director);
            session.persist(instituto);
            System.out.println("Instituto Creado con exito");

            trx.commit();
        } catch (Exception e) {
            if(trx!=null) trx.rollback();
            e.printStackTrace();
        }
    }

    public void eliminarInstituto(int idInstituto) {
        Transaction trx=null;
        try {
            trx=session.beginTransaction();

            Instituto instituto= session.find(Instituto.class, idInstituto);
            session.remove(instituto);
            System.out.println("Instituto "+idInstituto+" eliminado");

            trx.commit();
        } catch (Exception e) {
            if(trx!=null) trx.rollback();
            e.printStackTrace();
        }
    }

    public void modificarTelefono(int codigo,String telefonoModificar) {
        Transaction trx=null;
        try {
            trx=session.beginTransaction();

            Instituto instituto= session.find(Instituto.class, codigo);
            if(instituto != null) {
                instituto.setTelefono(telefonoModificar);
                session.merge(instituto);
                System.out.println("Telefono Modificado");
            }else{
                System.out.println("No existe instituto con el codigo: "+codigo);
            }
            trx.commit();
        } catch (Exception e) {
            if(trx!=null) trx.rollback();
            e.printStackTrace();
        }
    }
    public void asignarDirectorInstituto(int directorCodigo,int instCodigo) {
        Transaction trx=null;
        try {
            trx=session.beginTransaction();
            Director director = session.find(Director.class, directorCodigo );
            Instituto instituto= session.find(Instituto.class, instCodigo);
            if(instituto != null || director !=null) {


            }else{
                System.out.println("No existe instituto o instituto");
            }
            trx.commit();
        } catch (Exception e) {
            if(trx!=null) trx.rollback();
            e.printStackTrace();
        }
    }
}
