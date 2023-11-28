package br.senac.pr.exemplospringbootbasicauth.pessoas.repositorio;

import br.senac.pr.exemplospringbootbasicauth.pessoas.entidade.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepositorio extends JpaRepository<Pessoa, Long> {}
