package com.javanauta.bff_agendador_tarefas.business;

import com.javanauta.bff_agendador_tarefas.business.dto.out.TarefasDTOResponse;
import com.javanauta.bff_agendador_tarefas.infrascture.client.EmailClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailClient emailClient;


    public void enviaEmail(TarefasDTOResponse  dto) {
                emailClient.enviarEmail(dto);
    }
    // ========================== FIM =============================

 }