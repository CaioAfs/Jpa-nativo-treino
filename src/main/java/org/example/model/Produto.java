package org.example.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "produto", length = 200,nullable = false)
    private String produto;

    @Column(name = "preco", length = 10,nullable = false)
    private Double preco;

    public Produto(String nomeProduto, Double valorProduto){
        this.produto = nomeProduto;
        this.preco = valorProduto;
    }

}
