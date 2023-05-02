package org.example.testesUsuario;

import org.example.model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainAlterarUser2 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jpa-treino");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Usuario user = em.find(Usuario.class, 1L);
        user.setEmail("Pedro@123.com");
        user.setNome("Pedro Pedroso");
        em.detach(user);
        //Detach retira o objeto do estado gerenciado
        em.merge(user);

        em.getTransaction().commit();

        emf.close();
        em.close();


    }
}
