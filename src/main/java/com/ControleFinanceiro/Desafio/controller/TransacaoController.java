package com.ControleFinanceiro.Desafio.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ControleFinanceiro.Desafio.model.Transacao;
import com.ControleFinanceiro.Desafio.service.TransacaoService;

@RestController
@RequestMapping("/api/transacoes")
public class TransacaoController {

    private final TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @PostMapping
    public ResponseEntity<Transacao> createTransacao(@RequestBody Transacao transacao) {
        Transacao novaTransacao = transacaoService.createTransacao(transacao);
        return ResponseEntity.ok(novaTransacao);
    }

    @GetMapping
    public ResponseEntity<List<Transacao>> getAllTransacoes() {
        return ResponseEntity.ok(transacaoService.getAllTransacoes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transacao> getTransacaoById(@PathVariable Long id) {
        return ResponseEntity.ok(transacaoService.getTransacaoById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transacao> updateTransacao(@PathVariable Long id, @RequestBody Transacao transacao) {
        Transacao transacaoAtualizada = transacaoService.updateTransacao(id, transacao);
        if (transacaoAtualizada != null) {
            return ResponseEntity.ok(transacaoAtualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransacao(@PathVariable Long id) {
        transacaoService.deleteTransacao(id);
        return ResponseEntity.noContent().build();
    }

}
