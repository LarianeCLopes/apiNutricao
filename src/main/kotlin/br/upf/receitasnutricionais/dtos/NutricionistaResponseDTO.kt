package br.upf.receitasnutricionais.dtos

data class NutricionistaResponseDTO(
        val id: Long?,
        val nome: String,
        val inicio_programa: String,
        val fim_programa: String
)
