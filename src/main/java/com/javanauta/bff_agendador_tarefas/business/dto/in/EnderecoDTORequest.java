package com.javanauta.bff_agendador_tarefas.business.dto.in;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnderecoDTORequest {


    private Long    id;
    private String rua;
    private String numero;
    private String complemento;
    private String cidade;
    private String estado;
    private String cep;





}
