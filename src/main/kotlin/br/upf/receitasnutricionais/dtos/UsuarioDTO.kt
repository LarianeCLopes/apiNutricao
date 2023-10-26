package br.upf.receitasnutricionais.dtos

import jakarta.validation.constraints.NotEmpty

data class UsuarioDTO(
        @field:NotEmpty(message = "O usuario deve ter um nome")
        val nome: String,
        val telefone: String,
        val senha: String,
        val email: String
)
