package br.upf.receitasnutricionais.repository

import br.upf.receitasnutricionais.model.Nutricionista
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface NutricionistaRepository: JpaRepository<Nutricionista, Long> {
}
