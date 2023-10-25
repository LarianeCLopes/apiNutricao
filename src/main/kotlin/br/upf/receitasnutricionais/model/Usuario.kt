package br.upf.receitasnutricionais.model

import jakarta.persistence.*
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity
data class Usuario(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String,
    val telefone: String,

    @OneToMany(mappedBy = "usuario")
    val consultas: List<Consulta> = listOf()

)