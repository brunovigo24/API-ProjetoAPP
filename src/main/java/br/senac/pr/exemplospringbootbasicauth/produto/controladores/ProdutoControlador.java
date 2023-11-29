package br.senac.pr.exemplospringbootbasicauth.produto.controladores;


import br.senac.pr.exemplospringbootbasicauth.pessoas.entidade.Pessoa;
import br.senac.pr.exemplospringbootbasicauth.produto.entidades.Produto;
import br.senac.pr.exemplospringbootbasicauth.produto.repositorios.ProdutoRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/geral/produtos")
@AllArgsConstructor
public class ProdutoControlador {

    private ProdutoRepositorio produtoRepositorio;

    @GetMapping
    public List<Produto> findAll(){
        return produtoRepositorio.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable long id){
        return produtoRepositorio.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Produto> create(@RequestBody Produto produto){
        return ResponseEntity.ok((produtoRepositorio.save(produto)));
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        produtoRepositorio.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable("id") long id,
                                         @RequestBody Produto produto) {
        return produtoRepositorio.findById(id)
                .map(record -> {
                    record.setNome(produto.getNome());
                    record.setPreco(produto.getPreco());
                    record.setDescricao(produto.getDescricao());
                    Produto updated = produtoRepositorio.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }
}
