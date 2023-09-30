package br.upf.receitasnutricionais.model


data class nutricionista(
    val id: Long? = null,
    val nome: String,
    val inicioPrograma: String,
    val fimPrograma: String
)
