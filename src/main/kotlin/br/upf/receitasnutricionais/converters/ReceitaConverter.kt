package br.upf.receitasnutricionais.converters

import br.upf.receitasnutricionais.dtos.ReceitasDTO
import br.upf.receitasnutricionais.dtos.ReceitasResponseDTO
import br.upf.receitasnutricionais.model.Receita
import org.springframework.stereotype.Component

@Component
class ReceitaConverter {
    fun toReceita(dto: ReceitasDTO): Receita{
        return Receita(
                nome = dto.nome,
                descricao = dto.descricao

        )
    }

    fun toReceitaResponseDTO(receita: Receita): ReceitasResponseDTO {
        return ReceitasResponseDTO(
                id = receita.id,
                nome = receita.nome,
                descricao = receita.descricao
        )
    }
}