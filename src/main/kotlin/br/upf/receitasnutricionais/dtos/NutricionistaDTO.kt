package br.upf.receitasnutricionais.dtos

import jakarta.validation.constraints.NotEmpty

data class NutricionistaDTO(
        @field:NotEmpty(message = "Nutricionista deve ter um nome")
        val nome: String,
        @field:NotEmpty(message = "O programa deve ter um data de inicio")
        val inicioPrograma: String,
        val fimPrograma: String
)
