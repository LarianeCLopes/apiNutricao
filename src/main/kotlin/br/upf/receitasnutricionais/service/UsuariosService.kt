package br.upf.receitasnutricionais.service

import br.upf.receitasnutricionais.converters.UsuarioConverter
import br.upf.receitasnutricionais.dtos.UsuarioDTO
import br.upf.receitasnutricionais.dtos.UsuarioResponseDTO
import br.upf.receitasnutricionais.model.Usuario
import br.upf.receitasnutricionais.repository.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class UsuariosService (private val repository: UsuarioRepository,
                       private val converter: UsuarioConverter){
    fun listar(): List<UsuarioResponseDTO> {
        return repository.findAll()
                .map(converter::toUsuarioResponseDTO)
    }

    fun buscaPorId(id: Long): UsuarioResponseDTO {
        val usuario = repository.findAll().first { it.id == id}
        return converter.toUsuarioResponseDTO(usuario)
    }

    fun cadastrar(usuario: UsuarioDTO){
        repository.cadastrar(converter.ToUsuario(usuario));
    }
}