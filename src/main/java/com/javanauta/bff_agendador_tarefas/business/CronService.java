package com.javanauta.bff_agendador_tarefas.business;

import com.javanauta.bff_agendador_tarefas.business.dto.in.LoginDTORequest;
import com.javanauta.bff_agendador_tarefas.business.dto.out.TarefasDTOResponse;
import com.javanauta.bff_agendador_tarefas.infrascture.client.enums.StatusNotificacaoEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CronService {

    private final TarefasService tarefasService;
    private final EmailService   emailService;
    private final UsuarioService usuarioService;


    /// contruiindo dto com metodo estaticos para obter o token e usar no buscaTarefaProximaHora/buscaTarefaPorPeriodo
    @Value("${usuario.email}")
    private String email;

    @Value("${usuario.senha}")
    private String senha;
    /// *


    @Scheduled(cron = "${cron.horario}")
    public void buscaTarefaProximaHora(){
        String token = login(converterParaRequestDTO());
          LocalDateTime agora = LocalDateTime.now();
          LocalDateTime horaFutura = agora.plusHours(1);
          System.out.println("🔎 Buscando tarefas entre " + agora + " e " + horaFutura);


        List<TarefasDTOResponse> listaDeTarefas =
        tarefasService.buscaTarefaPorPeriodo(agora,horaFutura,token);

        listaDeTarefas.forEach(tarefa -> { emailService.enviaEmail(tarefa);
        tarefasService.alterarStatus(StatusNotificacaoEnum.NOTIFICADO, tarefa.getId(), token);});


    }


    ///  inicio
    /// CRIANDO UM METODO PARA OBTER LOGIN VIA TOKEN PARA PASSAR NO  buscaTarefaProximaHora QUE CHAMA O buscaTarefaPorPeriodo
    /// VAMOS CHAMAR O USUARIO SERVICE PQ NELE É OBTIDO O TOKEN
    public String login(LoginDTORequest dto){
        return usuarioService.loginUsuario(dto);
    }

    /// CRIANDO UM CONVERTE SIMPLES
    public LoginDTORequest converterParaRequestDTO(){
        return LoginDTORequest.builder()
                .email(email)
                .senha(senha)
                .build();
    }
    ///  fim.



}
