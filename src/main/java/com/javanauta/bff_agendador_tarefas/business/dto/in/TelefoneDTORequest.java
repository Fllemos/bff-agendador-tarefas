package com.javanauta.bff_agendador_tarefas.business.dto.in;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TelefoneDTORequest {

    private Long    id;
    private String numero;
    private String ddd;



}
