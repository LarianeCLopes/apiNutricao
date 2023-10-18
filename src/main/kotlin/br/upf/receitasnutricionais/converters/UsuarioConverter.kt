package br.upf.receitasnutricionais.converters

import br.upf.receitasnutricionais.dtos.UsuarioDTO
import br.upf.receitasnutricionais.dtos.UsuarioResponseDTO
import br.upf.receitasnutricionais.model.Usuario
import org.springframework.stereotype.Component

@Component
class UsuarioConverter {
    fun ToUsuario(dto: UsuarioDTO): Usuario {
        return Usuario(
                nome = dto.nome,
                telefone = dto.telefone
        )
    }

    fun toUsuarioResponseDTO(usuario: Usuario): UsuarioResponseDTO {
        return UsuarioResponseDTO(
                nome = usuario.nome,
                telefone = usuario.telefone
        )
    }
}