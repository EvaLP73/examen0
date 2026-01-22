package org.example.repositorios;

import org.example.entidades.Ciclo;
import org.example.entidades.Instituto;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CicloRepositorio {
    Session session;

    public CicloRepositorio(Session sesion) {
        this.session = sesion;
    }

    public void crearCiclo(String nombreCiclo) {
        Transaction trx=null;
        try {
            trx=session.beginTransaction();

            Ciclo ciclo = new Ciclo();
            ciclo.setNombreCiclo(nombreCiclo);
            session.persist(ciclo);
            System.out.println("Ciclo Creado con exito");

            trx.commit();
        } catch (Exception e) {
            if(trx!=null) trx.rollback();
            e.printStackTrace();
        }
    }
    public void eliminarCiclo(int idCiclo) {
        Transaction trx=null;
        try {
            trx=session.beginTransaction();

            Ciclo ciclo= session.find(Ciclo.class, idCiclo);
            session.remove(ciclo);
            System.out.println("Ciclo Eliminado con exito");

            trx.commit();
        } catch (Exception e) {
            if(trx!=null) trx.rollback();
            e.printStackTrace();
        }

    }
}
