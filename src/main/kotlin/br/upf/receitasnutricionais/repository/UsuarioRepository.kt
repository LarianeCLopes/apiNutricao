package br.upf.receitasnutricionais.repository

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

    fun cadastrar(usuario: Usuario){
        usuarios.add(usuario.copy(id = idCont++))
    }
}