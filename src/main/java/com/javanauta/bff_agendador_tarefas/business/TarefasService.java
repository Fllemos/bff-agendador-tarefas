package com.javanauta.bff_agendador_tarefas.business;

import com.javanauta.bff_agendador_tarefas.business.dto.in.TarefasDTORequest;
import com.javanauta.bff_agendador_tarefas.business.dto.out.TarefasDTOResponse;
import com.javanauta.bff_agendador_tarefas.infrascture.client.TarefasClient;
import com.javanauta.bff_agendador_tarefas.infrascture.client.enums.StatusNotificacaoEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasClient tarefasClient;

    // ============================================================
    // ======================= GRAVAR TAREFA ======================
    // ============================================================
        public TarefasDTOResponse gravarTarefa(TarefasDTORequest  dto, String token) {
               return tarefasClient.gravarTarefas(dto, token);
        }
    // ========================== FIM =============================


    // ============================================================
    // =================== LISTA POR PERIODO ======================
    // ============================================================
        public List<TarefasDTOResponse> buscaTarefaPorPeriodo(LocalDateTime dataInicial,
                                                             LocalDateTime dataFinal,
                                                             String token) {
               return tarefasClient.buscaTarefaPorPeriodo(dataInicial,dataFinal,token);
        }
    // ========================== FIM =============================


    // ============================================================
    // =================== BUSCA TAREFA POR EMAIL==================
    // ============================================================
        public List<TarefasDTOResponse>buscaTarefasPorEmail(String token){
            return tarefasClient.buscaTarefasPorEmail(token);
        }
    // ========================== FIM =============================

    // ============================================================
    // =================== DELETA TAREFA POR ID  ==================
    // ============================================================
        public void deletaId(String id, String token){
                    tarefasClient.deletaId(id,token);
        }
    // ========================== FIM =============================

    // ============================================================
    // =================== ALTERAR STATUS =========================
    // ============================================================
    public TarefasDTOResponse alterarStatus(StatusNotificacaoEnum status, String id, String token){
                return tarefasClient.alterarStatus(status,id,token);
    }
    // ========================== FIM =============================

    // ============================================================
    // =================== ALTERAR TAREFA =========================
    // ============================================================
    public TarefasDTOResponse alteraTarefa(TarefasDTORequest tarefasDTO, String id , String token){
           return  tarefasClient.alteraTarefa(tarefasDTO, id,token );
    }
    // ========================== FIM =============================




}