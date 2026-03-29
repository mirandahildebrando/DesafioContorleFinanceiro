package com.ControleFinanceiro.Desafio.model;

import jakarta.persistence.Entity;

@Entity
@
public class Transacao {

    private Long id;
    private String descricao;
    private Double valor;
    private String tipo; // "receita" ou "despesa"
    private LocalDate data;
    private Categoria categoria;
    

}
