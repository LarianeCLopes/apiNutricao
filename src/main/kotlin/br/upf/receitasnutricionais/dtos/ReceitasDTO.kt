package br.upf.receitasnutricionais.dtos

import jakarta.validation.constraints.NotEmpty

data class ReceitasDTO(
        @field:NotEmpty(message = "Receita deve ter um nome")
        val nome: String,
        val descricao: String
)
