package com.Produtos.Produtos.controllers;

import com.Produtos.Produtos.entity.Produto;
import com.Produtos.Produtos.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoservice) {
        this.produtoService = produtoservice;
    }

    @PostMapping
    public Produto criar(@RequestBody Produto produto){
        return produtoService.criarProduto(produto);
    }

    @GetMapping
    public List<Produto> listar(){
        return produtoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable Long id){
        return produtoService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable Long id){
        produtoService.deletarPorId(id);
    }

    @PutMapping("/{id}")
    public Produto atualizarProduto(@PathVariable Long id, @RequestBody Produto produto){
        Produto produtoExistente = produtoService.buscarPorId(id);

        if(produtoExistente != null){
            produtoExistente.setNome(produto.getNome());
            produtoExistente.setPreco(produto.getPreco());
            produtoExistente.setEstoque(produto.getEstoque());

            return produtoService.criarProduto(produtoExistente);
        }
        return null;
    }
}
