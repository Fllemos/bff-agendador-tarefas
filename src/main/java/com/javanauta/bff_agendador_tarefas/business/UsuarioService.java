package com.javanauta.bff_agendador_tarefas.business;
import com.javanauta.bff_agendador_tarefas.business.dto.in.EnderecoDTORequest;
import com.javanauta.bff_agendador_tarefas.business.dto.in.LoginDTORequest;
import com.javanauta.bff_agendador_tarefas.business.dto.in.TelefoneDTORequest;
import com.javanauta.bff_agendador_tarefas.business.dto.in.UsuarioDTORequest;
import com.javanauta.bff_agendador_tarefas.business.dto.out.EnderecoDTOResponse;
import com.javanauta.bff_agendador_tarefas.business.dto.out.TelefoneDTOResponse;
import com.javanauta.bff_agendador_tarefas.business.dto.out.UsuarioDTOResponse;
import com.javanauta.bff_agendador_tarefas.infrascture.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class UsuarioService {


    private final UsuarioClient usuarioClient;

    /// ============================================================
    /// ======================== SALVAR USUARIO ====================
    /// ========================   INICIO       ====================
    public UsuarioDTOResponse salvaUsuario(UsuarioDTORequest usuarioDTORequest){
           return  usuarioClient.salvaUsuario(usuarioDTORequest);
    }
    ///  =========================   FIM   ==========================


    /// ============================================================
    /// ========================   LOGIN     =======================
    /// ========================   INICIO    =======================
    public String loginUsuario(LoginDTORequest dto){
        return usuarioClient.login(dto);
    }
    ///  =========================   FIM   ==========================


    ///  ============================================================
    ///  ================== BUSCAR USUARIO POR EMAIL ================
    ///  ======================   INICIO   ==========================
    public UsuarioDTOResponse buscarUsuarioPorEmail(String email, String token){
            return usuarioClient.buscaUsuarioPorEmail(email, token);
    }
    ///  =========================   FIM   ==========================


    /// ============================================================
    /// ================== DELETA USUARIO POR EMAIL ================
    /// ========================   INICIO       ====================

    public void deletaUsuarioPorEmail(String email, String token){
                usuarioClient.deletaUsuarioPorEmail(email,token);
    }
    ///  =========================   FIM   ==========================

    /// ============================================================
    /// ================== ATUALIZA DADOS DO USUARIO================
    /// ========================   INICIO       ====================
    public UsuarioDTOResponse atualizarDadosUsuario(UsuarioDTORequest dto, String token){
            return usuarioClient.atualizarDadosUsuario(dto,token);
    }
    ///  =========================   FIM   ==========================


    /// TODO ==================== fim das informações referente ao usuario


    /// ============================================================
    /// ================== ATUALIZA DADOS DO ENDERECO ==============
    /// ========================   INICIO       ====================
    public EnderecoDTOResponse atualizarDadosEndereco(EnderecoDTORequest enderecoDTO, Long idEndereco, String token){
        return usuarioClient.atualizarDadosEndereco(enderecoDTO,idEndereco,token);
    }
    ///  =========================   FIM   ==========================


    /// ============================================================
    /// ================== INSERIR NOVO ENDERECO ===================
    /// ========================   INICIO       ====================
    public EnderecoDTOResponse salvaNovoEndereco(EnderecoDTORequest dto, String token){
            return  usuarioClient.salvaNovoEndereco(dto,token);
    }
    /// =========================   FIM   ==========================


    /// ============================================================
    /// ================== ATUALIZA DADOS DO TELEFONE ==============
    /// ========================   INICIO       ====================
    public TelefoneDTOResponse atualizarTelefone(TelefoneDTORequest telefoneDTORequest, Long idTelefone, String token){
        return usuarioClient.atualizarTelefone(telefoneDTORequest,idTelefone,token);
    }
    ///  =========================   FIM   ==========================



    /// ============================================================
    /// ================== INSERIR NOVO TELEFONE ===================
    /// ========================   INICIO       ====================
    public TelefoneDTOResponse salvaNovoTelefone(TelefoneDTORequest dto, String token){
        return usuarioClient.salvaNovoTelefone(dto,token);
    }



}
