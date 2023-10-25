package br.upf.receitasnutricionais.model

import jakarta.persistence.*

@Entity
data class Receita (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String,
    val descricao: String,
    @ManyToOne
    val nutricionista: Nutricionista? = null
)
