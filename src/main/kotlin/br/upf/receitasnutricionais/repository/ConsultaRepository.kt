package br.upf.receitasnutricionais.repository

import br.upf.receitasnutricionais.model.Consulta
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface ConsultaRepository: JpaRepository<Consulta, Long> {
}