package br.upf.receitasnutricionais.model
import jakarta.persistence.*

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany

@Entity
data class Nutricionista(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String,
    val inicio_programa: String,
    val fim_programa: String,

    @OneToMany(mappedBy = "nutricionista")
    val consultas: List<Consulta> = listOf(),

    )