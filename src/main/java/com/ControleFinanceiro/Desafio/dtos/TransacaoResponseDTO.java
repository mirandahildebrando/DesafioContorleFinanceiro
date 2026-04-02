package com.ControleFinanceiro.Desafio.dtos;

import java.time.LocalDate;

import com.ControleFinanceiro.Desafio.model.Categoria;

public record TransacaoResponseDTO(
    String descricao,
    Double valor,
    String tipo,
    LocalDate data,
    Categoria categoria
) {

}
