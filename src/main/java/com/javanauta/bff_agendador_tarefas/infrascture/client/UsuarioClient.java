package com.javanauta.bff_agendador_tarefas.infrascture.client;

import com.javanauta.bff_agendador_tarefas.business.dto.in.EnderecoDTORequest;
import com.javanauta.bff_agendador_tarefas.business.dto.in.LoginDTORequest;
import com.javanauta.bff_agendador_tarefas.business.dto.in.TelefoneDTORequest;
import com.javanauta.bff_agendador_tarefas.business.dto.in.UsuarioDTORequest;
import com.javanauta.bff_agendador_tarefas.business.dto.out.EnderecoDTOResponse;
import com.javanauta.bff_agendador_tarefas.business.dto.out.TelefoneDTOResponse;
import com.javanauta.bff_agendador_tarefas.business.dto.out.UsuarioDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    /// ============================================================
    /// ================= BUSCA USUARIO POR EMAIL ==================
    /// ========================   INICIO       ====================
    @GetMapping("/usuario")
    UsuarioDTOResponse buscaUsuarioPorEmail(@RequestParam("email") String email,
                                            @RequestHeader("Authorization") String token);
    ///  =========================   FIM   ==========================


    /// ============================================================
    /// =====================   SALVA USUARIO  =====================
    /// ========================   INICIO       ====================
    @PostMapping
    UsuarioDTOResponse salvaUsuario(@RequestBody UsuarioDTORequest usuarioDTORequest);
    ///  =========================   FIM   ==========================


    /// ============================================================
    /// ====  VALIDACAO VIA TOKEN - PASSA USER(EMAIL) E SENHA  =====
    /// ========================   INICIO       ====================

    // VALIDAÇÃO VIA TOKE -- PASSANDO USUARIO(EMAIL) E SENHA
    @PostMapping("/login")
    String login(@RequestBody LoginDTORequest usuarioDTORequest);
    ///  =========================   FIM   ==========================


    /// ============================================================
    /// ================== DELETA USUARIO POR EMAIL ================
    /// ========================   INICIO       ====================
    @DeleteMapping("/delete")
    Void deletaUsuarioPorEmail(@RequestParam("email")          String email,
                               @RequestHeader("Authorization") String token);
    ///  =========================   FIM   ==========================

    /// ============================================================
    /// ================== ATUALIZA DADOS DO USUARIO================
    /// ========================   INICIO       ====================
    @PutMapping
    UsuarioDTOResponse atualizarDadosUsuario(@RequestBody UsuarioDTORequest dto,
                                            @RequestHeader("Authorization") String token);
    ///  =========================   FIM   ==========================

    /// ============================================================
    /// ================== ATUALIZA DADOS DE ENDERECO===============
    /// ========================   INICIO       ====================
    @PutMapping("/Endereco")
    EnderecoDTOResponse atualizarDadosEndereco(@RequestBody EnderecoDTORequest dto,
                                               @RequestParam("id") Long id,
                                               @RequestHeader("Authorization") String token);
    ///  =========================   FIM   ==========================

    /// ============================================================'
    /// ================== INSERIR DADOS DE ENDERECO ===============
    /// ========================   INICIO       ====================
    @PostMapping("/Novo/Endereco")
    EnderecoDTOResponse salvaNovoEndereco(@RequestBody EnderecoDTORequest dto,
                                         @RequestHeader("Authorization") String token);
    ///  =========================   FIM   ==========================

    /// ============================================================
    /// ================== INSERIR NOVO TELEFONE ===================
    /// ========================   INICIO       ====================
    @PostMapping("/Novo/Telefone")
    TelefoneDTOResponse salvaNovoTelefone(@RequestBody TelefoneDTORequest dto,
                                          @RequestHeader("Authorization") String token);
    ///  =========================   FIM   ==========================
    ///
    /// ============================================================
    /// ================== ATUALIZA DADOS DE TELEFONE===============
    /// ========================   INICIO       ====================
    @PutMapping("/Telefone")
    TelefoneDTOResponse atualizarTelefone(@RequestBody TelefoneDTORequest dto,
                                         @RequestParam("id") Long id,
                                         @RequestHeader("Authorization") String token);
    ///  =========================   FIM   ==========================
}















