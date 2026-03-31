package com.ControleFinanceiro.Desafio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ControleFinanceiro.Desafio.model.Categoria;
import com.ControleFinanceiro.Desafio.repository.CategoriaRepository;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria createCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();
    }

}
