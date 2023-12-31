package br.upf.receitasnutricionais.converters

import br.upf.receitasnutricionais.dtos.UsuarioDTO
import br.upf.receitasnutricionais.dtos.UsuarioResponseDTO
import br.upf.receitasnutricionais.model.Usuario
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component

@Component
class UsuarioConverter {

    fun toUsuario(dto: UsuarioDTO): Usuario {
        return Usuario(
                nome = dto.nome,
                telefone = dto.telefone,
                email = dto.email,
                senha = BCryptPasswordEncoder().encode(dto.senha),
        )
    }
    fun toUsuarioResponseDTO(usuario: Usuario): UsuarioResponseDTO {
        return UsuarioResponseDTO(
                id = usuario.id,
                nome = usuario.nome,
                telefone = usuario.telefone,
                email = usuario.email
        )
    }


}