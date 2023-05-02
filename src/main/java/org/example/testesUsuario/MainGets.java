package org.example.testesUsuario;

import org.example.model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class MainGets {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jpa-treino");
        EntityManager em = emf.createEntityManager();

        List<Usuario> usuarios = em.createQuery("select u from Usuario u",Usuario.class)
                .setMaxResults(5)
                .getResultList();

        for(Usuario usuario : usuarios) {
            System.out.println(usuario.toString());
        }

        emf.close();
        em.close();
    }
}

