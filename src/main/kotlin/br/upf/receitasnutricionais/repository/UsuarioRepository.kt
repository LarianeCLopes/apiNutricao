package br.upf.receitasnutricionais.repository

import br.upf.receitasnutricionais.model.Usuario
import org.springframework.data.domain.Page
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Repository
import java.awt.print.Pageable

@Repository
interface UsuarioRepository: JpaRepository<Usuario, Long> {
    fun findByNome(nomeUsuario: String, paginacao: Pageable): Page<Usuario>

    fun findByEmail(email: String): UserDetails?
}