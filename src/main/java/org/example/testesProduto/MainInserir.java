package org.example.testesProduto;

import org.example.model.Produto;
import org.example.model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainInserir {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jpa-treino");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Produto produto = new Produto();
        produto.setProduto("PedraDeAmolar");
        produto.setPreco(5D);

        em.persist(produto);
        em.getTransaction().commit();

        em.close();
        emf.close();

    }
}
