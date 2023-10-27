package br.upf.receitasnutricionais.dtos

import jakarta.validation.constraints.NotEmpty

data class UsuarioDTO(
        val nome: String,
        val telefone: String,
        val senha: String,
        val email: String
)

