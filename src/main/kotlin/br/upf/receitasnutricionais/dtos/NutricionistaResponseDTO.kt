package br.upf.receitasnutricionais.dtos

data class NutricionistaResponseDTO(
        val id: Long?,
        val nome: String,
        val inicioPrograma: String,
        val fimPrograma: String
)
