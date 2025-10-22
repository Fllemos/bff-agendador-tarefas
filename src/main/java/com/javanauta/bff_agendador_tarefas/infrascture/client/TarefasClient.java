package com.javanauta.bff_agendador_tarefas.infrascture.client;

import com.javanauta.bff_agendador_tarefas.business.dto.in.TarefasDTORequest;
import com.javanauta.bff_agendador_tarefas.business.dto.out.TarefasDTOResponse;
import com.javanauta.bff_agendador_tarefas.infrascture.client.enums.StatusNotificacaoEnum;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@FeignClient(name = "agendador-tarefas", url = "${agendador-tarefas.url}")
public interface TarefasClient {

    // ============================================================
    // ======================= GRAVAR TAREFA ======================
    // ============================================================
    @PostMapping
    TarefasDTOResponse gravarTarefas(@RequestBody TarefasDTORequest dto,
                                     @RequestHeader("Authorization") String token);
    // ========================== FIM =============================


    // ============================================================
    // =================== LISTA POR PERIODO ======================
    // ============================================================
    @GetMapping("/eventos")
    List<TarefasDTOResponse >buscaTarefaPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal,
            @RequestHeader("Authorization") String token);
    // ========================== FIM =============================


    // ============================================================
    // =================== BUSCA TAREFA POR EMAIL =================
    // ============================================================
    @GetMapping
    List<TarefasDTOResponse > buscaTarefasPorEmail(@RequestHeader("Authorization") String token);
    // ========================== FIM =============================

    // ============================================================
    // =================== DELETA TAREFA POR ID  ==================
    // ============================================================
    @DeleteMapping
    Void deletaId(@RequestParam("id") String id,
                  @RequestHeader("Authorization") String token);
    // ========================== FIM =============================

    // ============================================================
    // =================== ALTERAR STATUS =========================
    // ============================================================
    @PatchMapping
    TarefasDTOResponse  alterarStatus(@RequestParam("status") StatusNotificacaoEnum status,
                                    @RequestParam("id") String id,
                                    @RequestHeader("Authorization") String token);
    // ========================== FIM =============================



    // ============================================================
    // =================== ALTERAR TAREFA =========================
    // ============================================================
    @PutMapping
    TarefasDTOResponse  alteraTarefa(@RequestBody TarefasDTORequest dto,
                                   @RequestParam("id") String id,
                                   @RequestHeader("Authorization") String token);
     // ========================== FIM =============================

}







