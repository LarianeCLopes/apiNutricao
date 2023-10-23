package br.upf.receitasnutricionais.repository

import br.upf.receitasnutricionais.dtos.UsuarioDTO
import br.upf.receitasnutricionais.model.Usuario
import org.springframework.stereotype.Repository

@Repository
class UsuarioRepository (private var usuarios: MutableList<Usuario>){
    private var idCont = 4L
    init {
        val usuario1 = Usuario(
                id = 1,
                nome = "Ana Clara",
                telefone = "99999-9999"
        )
        usuarios = mutableListOf(usuario1)
    }
    fun findAll() = usuarios

    fun cadastrar(usuario: Usuario): Usuario{
        val usuarioComId = usuario.copy(id = idCont++)
        usuarios.add(usuarioComId)
        return usuarioComId
    }

    fun update(usuario: Usuario, usuarioAtualizado: Usuario): Usuario {
        usuarios.remove(usuario)
        val usuarioAtualizadoComId = Usuario(
                id = usuario.id,
                nome = usuarioAtualizado.nome,
                telefone = usuarioAtualizado.telefone
        )
        usuarios.add(usuarioAtualizadoComId)
        return usuarioAtualizadoComId
    }

    fun deletar(id: Long) {
        val usuario = usuarios.first { it.id == id}
        usuarios.remove(usuario)
    }
}