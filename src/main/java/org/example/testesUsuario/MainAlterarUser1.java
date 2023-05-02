package org.example.testesUsuario;

import org.example.model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class MainAlterarUser1 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jpa-treino");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Usuario usuario = em.find(Usuario.class, 2L);
        usuario.setNome("Caio");
        usuario.setEmail("Caio@gmail.com");

        em.merge(usuario);

        em.getTransaction().commit();

        em.close();
        emf.close();

    }
}
