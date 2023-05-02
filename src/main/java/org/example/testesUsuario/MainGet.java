package org.example.testesUsuario;

import org.example.model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainGet {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jpa-treino");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Usuario user = em.find(Usuario.class,1L);
        System.out.println(user.getNome());

        emf.close();
        em.close();
    }

}
