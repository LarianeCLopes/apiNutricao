package br.upf.receitasnutricionais.dtos

data class UsuarioResponseDTO(
        val id: Long?,
        val nome: String,
        val telefone: String,
        val email: String
)
