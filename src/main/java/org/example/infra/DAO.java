package org.example.infra;


import javax.persistence.*;
import java.util.List;

public class DAO<E> {

    private static EntityManagerFactory emf;
    private EntityManager em;
    private Class<E> classe;

    static{
        try{
            emf = Persistence.createEntityManagerFactory("Jpa-treino");
        }catch (Exception e){
            e.getMessage();
        }
    }


    public DAO(){
        this(null);
     }

     public DAO(Class<E> classe){
        em = emf.createEntityManager();
        this.classe = classe;
     }

     public DAO<E> abrirT(){
        em.getTransaction().begin();
        return this;
     }
    public DAO<E> fecharT(){
        em.getTransaction().commit();
        return this;
    }

    public DAO<E> incluir(E entidade){
        em.persist(entidade);
        return this;
    }

    public DAO<E> incluirAtomico(E entidade){
        return this.abrirT().incluir(entidade).fecharT();
    }

    public List<E> obterTodos(){
        return obterTodos(10,0);
    }

    public List<E> obterTodos(int quantidade, int deslocamento){
        if (classe == null){
            throw new UnsupportedOperationException("classe nula");
        }

        String jpql = "SELECT e FROM " +classe.getName() + " e";
        TypedQuery<E> query = em.createQuery(jpql, classe);
        query.setMaxResults(quantidade);
        query.setFirstResult(deslocamento);
        return query.getResultList();
    }

    public void fechar(){
        em.close();
    }

    //minhas implementacoes

    public E obterPorId(Long id){
        String jpql = "SELECT e FROM "+ classe.getName() + " e where e.id = :id";
        TypedQuery<E> query = em.createQuery(jpql, classe);
        query.setParameter("id", id);

        return query.getSingleResult();

    }

    public void excluirProdutoId(Long id) {
        abrirT();
        String objeto = obterPorId(id).toString();
        String jpql = "DELETE FROM " + classe.getName() + " e WHERE e.id = :id";
        Query query = em.createQuery(jpql);
        query.setParameter("id", id);
        int deleted = query.executeUpdate();
        System.out.println("Excluído quantidade: " + deleted + " Objeto -> " + objeto);
        fecharT();
    }

}
