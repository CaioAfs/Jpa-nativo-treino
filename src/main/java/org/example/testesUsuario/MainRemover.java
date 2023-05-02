package org.example.testesUsuario;

import org.example.model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainRemover {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jpa-treino");
        EntityManager em = emf.createEntityManager();

        Usuario user = em.find(Usuario.class, 9L);

        if(user != null) {
            em.getTransaction().begin();
            em.remove(user);
            em.getTransaction().commit();
        }


        em.close();
        emf.close();

    }
}
