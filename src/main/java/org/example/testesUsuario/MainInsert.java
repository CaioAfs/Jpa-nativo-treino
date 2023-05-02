package org.example.testesUsuario;


import org.example.model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainInsert {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jpa-treino");
        EntityManager em = emf.createEntityManager();

        Usuario user = new Usuario();
        user.setNome("Joana");
        user.setEmail("Joana@teste.com");
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}