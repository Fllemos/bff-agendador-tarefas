package com.javanauta.bff_agendador_tarefas.controller;

import com.javanauta.bff_agendador_tarefas.business.UsuarioService;
import com.javanauta.bff_agendador_tarefas.business.dto.in.EnderecoDTORequest;
import com.javanauta.bff_agendador_tarefas.business.dto.in.LoginDTORequest;
import com.javanauta.bff_agendador_tarefas.business.dto.in.TelefoneDTORequest;
import com.javanauta.bff_agendador_tarefas.business.dto.in.UsuarioDTORequest;
import com.javanauta.bff_agendador_tarefas.business.dto.out.EnderecoDTOResponse;
import com.javanauta.bff_agendador_tarefas.business.dto.out.TelefoneDTOResponse;
import com.javanauta.bff_agendador_tarefas.business.dto.out.UsuarioDTOResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;


    /// ============================================================
    /// ======================== SALVAR USUARIO ====================
    /// ========================   INICIO       ====================
    @PostMapping
    public ResponseEntity<UsuarioDTOResponse> salvaUsuario(@RequestBody UsuarioDTORequest usuarioDTORequest){
        return ResponseEntity.ok(usuarioService.salvaUsuario(usuarioDTORequest));
    }
    ///  =========================   FIM   ==========================

    /// ============================================================
    /// ========================   LOGIN     =======================
    /// ========================   INICIO    =======================
    @PostMapping("/login")
    public String login(@RequestBody LoginDTORequest dto){
         return usuarioService.loginUsuario(dto);
    }
    ///  =========================   FIM   ==========================


    /// ============================================================
    /// ================= BUSCA USUARIO POR EMAIL ==================
    /// ========================   INICIO       ====================
    @GetMapping
    public ResponseEntity<UsuarioDTOResponse> buscaUsuarioPorEmail(@RequestParam("email")          String email,
                                                           @RequestHeader("Authorization") String token){
        return  ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email, token));
    }
    ///  =========================   FIM   ==========================

    /// ============================================================
    /// ================== DELETA USUARIO POR EMAIL ================
    /// ========================   INICIO       ====================
    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deletaUsuarioPorEmail(@RequestParam("email")          String email,
                                                      @RequestHeader("Authorization") String token){
        return ResponseEntity.ok().build();
    }
    ///  =========================   FIM   ==========================

    /// ============================================================
    /// ================== ATUALIZA DADOS DO USUARIO================
    /// ========================   INICIO       ====================
    @PutMapping
    public ResponseEntity<UsuarioDTOResponse> atualizarDadosUsuario(@RequestBody UsuarioDTORequest dto,
                                                            @RequestHeader("Authorization") String token){
    return ResponseEntity.ok(usuarioService.atualizarDadosUsuario(dto,token));
    }
    ///  =========================   FIM   ==========================


    /// TODO ============================================================ fim das informações referente ao usuario



    /// ============================================================
    /// ================== ATUALIZA DADOS DE ENDERECO===============
    /// ========================   INICIO       ====================
    @PutMapping("/endereco")
    public ResponseEntity<EnderecoDTOResponse> atualizarEndereco(@RequestBody EnderecoDTORequest dto,
                                                                 @RequestParam("id") Long id,
                                                                 @RequestHeader("Authorization") String token){
        return ResponseEntity.ok(usuarioService.atualizarDadosEndereco(dto,id,token));
    }
    ///  =========================   FIM   ==========================


    /// ============================================================'
    /// ================== INSERIR NOVO  ENDERECO ==================
    /// ========================   INICIO       ====================
    @PostMapping("/endereco")
    public ResponseEntity<EnderecoDTOResponse> salvaNovoEndereco(@RequestBody EnderecoDTORequest dto,
                                                                @RequestHeader("Authorization") String token){
        return ResponseEntity.ok(usuarioService.salvaNovoEndereco(dto,token));
    }
    ///  =========================   FIM   ==========================



    /// ============================================================
    /// ================== ATUALIZA DADOS DE TELEFONE===============
    /// ========================   INICIO       ====================
    @PutMapping("/telefone")
    public ResponseEntity<TelefoneDTOResponse> atualizarTelefone(@RequestBody TelefoneDTORequest dto,
                                                                 @RequestParam("id") Long id,
                                                                 @RequestHeader("Authorization") String token){
        return ResponseEntity.ok(usuarioService.atualizarTelefone(dto,id,token));
    }
    ///  =========================   FIM   ==========================


    /// ============================================================
    /// ================== INSERIR NOVO TELEFONE ===================
    /// ========================   INICIO       ====================
    @GetMapping("/endereco/{cep}")
    public ResponseEntity<TelefoneDTOResponse> salvaNovoTelefone(@RequestBody TelefoneDTORequest dto,
                                                                @RequestHeader("Authorization") String token){
        return ResponseEntity.ok(usuarioService.salvaNovoTelefone(dto,token));
    }

}
