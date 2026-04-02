package com.ControleFinanceiro.Desafio.dtos;

import java.time.LocalDate;

import com.ControleFinanceiro.Desafio.model.Categoria;

public record TransacaoRequestDTO(
    Long id,
    String descricao,
    Double valor,
    String tipo,
    LocalDate data,
    Categoria categoria
    
) {

}
