package br.senac.pr.exemplospringbootbasicauth.produto.repositorios;


import br.senac.pr.exemplospringbootbasicauth.produto.entidades.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepositorio extends JpaRepository<Produto, Long> {}
