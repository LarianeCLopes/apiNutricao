package br.upf.receitasnutricionais.service

import br.upf.receitasnutricionais.model.Usuario
import br.upf.receitasnutricionais.repository.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class UsuariosService (private val repository: UsuarioRepository){
    fun listar(): List<Usuario> {
        return repository.findAll()
    }

    fun buscaPorId(id: Long): Usuario {
        return repository.findAll().first { it.id == id}
    }

    fun cadastrar(usuario: Usuario){
        repository.cadastrar(usuario);
    }
}