package br.upf.receitasnutricionais.repository

import br.upf.receitasnutricionais.model.Receita
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReceitaRepository: JpaRepository<Receita, Long> {
}
