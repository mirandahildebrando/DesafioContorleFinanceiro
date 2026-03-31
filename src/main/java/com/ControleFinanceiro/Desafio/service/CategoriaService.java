package com.ControleFinanceiro.Desafio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ControleFinanceiro.Desafio.model.Categoria;
import com.ControleFinanceiro.Desafio.model.Transacao;
import com.ControleFinanceiro.Desafio.repository.CategoriaRepository;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    private final TransacaoService transacaoService;

    public CategoriaService(CategoriaRepository categoriaRepository, TransacaoService transacaoService) {
        this.categoriaRepository = categoriaRepository;
        this.transacaoService = transacaoService;
    }

    public Categoria createCategoria(Categoria categoria, Transacao transacao) {
        if(categoriaRepository.findByNome(categoria.getNome()).equals("Receita")){
            categoria.setTipo("receita");
            transacao.setTipo("receita");
        } else {
            categoria.setTipo("despesa");
            transacao.setTipo("despesa");
        }
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();
    }

}
