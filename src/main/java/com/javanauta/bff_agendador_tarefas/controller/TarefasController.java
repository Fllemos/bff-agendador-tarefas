package com.javanauta.bff_agendador_tarefas.controller;

import com.javanauta.bff_agendador_tarefas.business.TarefasService;
import com.javanauta.bff_agendador_tarefas.business.dto.in.TarefasDTORequest;
import com.javanauta.bff_agendador_tarefas.business.dto.out.TarefasDTOResponse;
import com.javanauta.bff_agendador_tarefas.infrascture.client.enums.StatusNotificacaoEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TarefasController {


    private final TarefasService tarefasService;


    // ============================================================
    // ======================= GRAVAR TAREFA ======================
    // ============================================================
    @PostMapping
    public ResponseEntity<TarefasDTOResponse> gravarTarefas(@RequestBody TarefasDTORequest  dto,
                                                            @RequestHeader("Authorization") String token){
        return ResponseEntity.ok(tarefasService.gravarTarefa(dto,token));
    }
    // ========================== FIM =============================



    // ============================================================
    // =================== LISTA POR PERIODO ======================
    // ============================================================
    @GetMapping("/eventos")
    public ResponseEntity<List<TarefasDTOResponse>>buscaTarefaPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal,
            @RequestHeader("Authorization") String token){
            return ResponseEntity.ok(tarefasService.buscaTarefaPorPeriodo(dataInicial,dataFinal,token));
    }
    // ========================== FIM =============================


    // ============================================================
    // =================== BUSCA TAREFA POR EMAIL =================
    // ============================================================
    @GetMapping
    public ResponseEntity<List<TarefasDTOResponse>>buscaTarefasPorEmail(@RequestHeader("Authorization") String token){
           return ResponseEntity.ok(tarefasService.buscaTarefasPorEmail(token));
    }
    // ========================== FIM =============================

    // ============================================================
    // =================== DELETA TAREFA POR ID  ==================
    // ============================================================
    @DeleteMapping
    public ResponseEntity<Void>deletaId(@RequestParam("id") String id,
                                        @RequestHeader("Authorization") String token){
        return  ResponseEntity.ok().build();
    }
    // ========================== FIM =============================

    // ============================================================
    // =================== ALTERAR STATUS =========================
    // ============================================================
    @PatchMapping
    public ResponseEntity<TarefasDTOResponse> alterarStatus(@RequestParam("status")         StatusNotificacaoEnum status,
                                                           @RequestParam("id")             String id,
                                                           @RequestHeader("Authorization") String token){
        return  ResponseEntity.ok().build();
    }
    // ========================== FIM =============================



    // ============================================================
    // =================== ALTERAR TAREFA =========================
    // ============================================================
    @PutMapping
    public ResponseEntity<TarefasDTOResponse>alteraTarefa(@RequestBody TarefasDTORequest dto,
                                                         @RequestParam("id")             String id,
                                                         @RequestHeader("Authorization") String token){
           return  ResponseEntity.ok(tarefasService.alteraTarefa(dto, id, token));
    }
    // ========================== FIM =============================
}
