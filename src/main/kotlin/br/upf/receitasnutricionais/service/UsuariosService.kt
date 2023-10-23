package br.upf.receitasnutricionais.service

import br.upf.receitasnutricionais.converters.UsuarioConverter
import br.upf.receitasnutricionais.dtos.UsuarioDTO
import br.upf.receitasnutricionais.dtos.UsuarioResponseDTO
import br.upf.receitasnutricionais.exceptions.NotFoundException
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
        val usuario = repository.findAll().firstOrNull { it.id == id}
                ?: throw NotFoundException("Usuario não encontrado")
        return converter.toUsuarioResponseDTO(usuario)
    }

    fun cadastrar(dto: UsuarioDTO): UsuarioResponseDTO{
       val usuario = repository.cadastrar(converter.toUsuario(dto))
        return converter.toUsuarioResponseDTO(usuario)
    }

    fun atualizar(id: Long, dto: UsuarioDTO): UsuarioResponseDTO {
       val usuario = repository.findAll().firstOrNull{ it.id == id}
               ?: throw NotFoundException("Usuario não encontrada")
       val usuarioAtualizado = repository.update(usuario, converter.toUsuario(dto))
       return converter.toUsuarioResponseDTO(usuarioAtualizado)
    }

    fun deletar(id: Long) {
        repository.deletar(id)
    }
}