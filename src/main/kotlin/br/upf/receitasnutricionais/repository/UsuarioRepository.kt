package br.upf.receitasnutricionais.repository

import br.upf.receitasnutricionais.dtos.UsuarioDTO
import br.upf.receitasnutricionais.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UsuarioRepository: JpaRepository<Usuario, Long> {
}
