package com.Produtos.Produtos.services;

import com.Produtos.Produtos.entity.Produto;
import com.Produtos.Produtos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }


    public Produto criarProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public List<Produto> listarTodos(){
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Long id){
        return produtoRepository.findById(id).get();
    }

    public void deletarPorId(Long id) {
        produtoRepository.deleteById(id);
    }
}
