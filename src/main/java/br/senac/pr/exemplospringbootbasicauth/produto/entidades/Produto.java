package br.senac.pr.exemplospringbootbasicauth.produto.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, unique = true)
    @NotBlank
    private String nome;

    private double preco;
    private String descricao;


}
