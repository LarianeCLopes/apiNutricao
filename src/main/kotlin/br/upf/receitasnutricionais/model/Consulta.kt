package br.upf.receitasnutricionais.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
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
