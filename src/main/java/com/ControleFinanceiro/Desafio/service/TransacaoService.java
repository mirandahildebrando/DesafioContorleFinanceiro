package com.ControleFinanceiro.Desafio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ControleFinanceiro.Desafio.dtos.TransacaoRequestDTO;
import com.ControleFinanceiro.Desafio.dtos.TransacaoResponseDTO;
import com.ControleFinanceiro.Desafio.model.Transacao;
import com.ControleFinanceiro.Desafio.repository.TransacaoRepository;

@Service
public class TransacaoService {

    private final TransacaoRepository transacaoRepository;

    public TransacaoService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    public Transacao createTransacao(TransacaoRequestDTO dto) {

        Transacao transacao = new Transacao();

        transacao.setId(dto.id());
        transacao.setDescricao(dto.descricao());
        transacao.setValor(dto.valor());
        transacao.setTipo(dto.tipo());
        transacao.setData(dto.data());
        transacao.setCategoria(dto.categoria());
        
        return transacaoRepository.save(transacao);
    }

    public List<Transacao> getAllTransacoes() {
        return transacaoRepository.findAll();
    }

    public Transacao getTransacaoById(Long id) {
        return transacaoRepository.findById(id).orElse(null);
    }

    public Transacao updateTransacao(Long id, Transacao transacao) {
        Transacao existeTransacao = transacaoRepository.findById(id).orElse(null);
        if (existeTransacao != null) {
            existeTransacao.setValor(transacao.getValor());
            existeTransacao.setData(transacao.getData());
            existeTransacao.setCategoria(transacao.getCategoria());
            return transacaoRepository.save(existeTransacao);
        }
        return null;
    }

    public void deleteTransacao(Long id) {
        transacaoRepository.deleteById(id);
    }
}
