package br.upf.receitasnutricionais.service

import br.upf.receitasnutricionais.converters.UsuarioConverter
import br.upf.receitasnutricionais.dtos.UsuarioDTO
import br.upf.receitasnutricionais.dtos.UsuarioResponseDTO
import br.upf.receitasnutricionais.exceptions.NotFoundException
import br.upf.receitasnutricionais.model.Usuario
import br.upf.receitasnutricionais.repository.UsuarioRepository
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service
import java.awt.print.Pageable

private const val USUARIO_NOT_FOUND_MESSAGE = "Usuario não encontrado!"
@Service
class UsuariosService (private val repository: UsuarioRepository,
                       private val converter: UsuarioConverter){
    fun listar(nomeUsuario: String?, paginacao: Pageable): Page<UsuarioResponseDTO> {
        val usuarios = if (nomeUsuario == null) {
            repository.findAll(paginacao)
        } else {
            repository.findByNome(nomeUsuario,paginacao)
        }
        return usuarios.map(converter::toUsuarioResponseDTO)
    }

    fun buscaPorId(id: Long): UsuarioResponseDTO {
        val usuario = repository.findById(id)
                .orElseThrow{NotFoundException(USUARIO_NOT_FOUND_MESSAGE)}
        return converter.toUsuarioResponseDTO(usuario)
    }

    fun cadastrar(dto: UsuarioDTO): UsuarioResponseDTO{
        return converter.toUsuarioResponseDTO(
                repository.save(converter.toUsuario(dto))
        )
    }

    fun atualizar(id: Long, dto: UsuarioDTO): UsuarioResponseDTO {
        val usuario = repository.findById(id)
                .orElseThrow{NotFoundException(USUARIO_NOT_FOUND_MESSAGE)}
                .copy(
                        nome = dto.nome,
                        telefone = dto.telefone
                )
        return converter.toUsuarioResponseDTO(repository.save(usuario))
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }
}