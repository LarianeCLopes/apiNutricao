package br.upf.receitasnutricionais.model


data class Nutricionista(
    val id: Long? = null,
    val nome: String,
    val inicioPrograma: String,
    val fimPrograma: String
)
