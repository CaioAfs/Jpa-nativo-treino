package org.example.testeDao;

import org.example.infra.DAO;
import org.example.model.Produto;

public class NovoProduto {
    public static void main(String[] args) {
        DAO<Produto> dao = new DAO<Produto>(Produto.class);
        dao.excluirProdutoId(7L);
    }
}
