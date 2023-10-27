package br.upf.receitasnutricionais.model

import jakarta.persistence.*
import java.time.LocalDate

@Entity
data class Consulta(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val agendamento: String,

    @ManyToOne
    val usuario: Usuario,
    @ManyToOne
    val nutricionista: Nutricionista
)