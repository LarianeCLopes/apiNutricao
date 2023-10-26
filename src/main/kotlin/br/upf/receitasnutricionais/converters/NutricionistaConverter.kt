package br.upf.receitasnutricionais.converters

import br.upf.receitasnutricionais.dtos.NutricionistaDTO
import br.upf.receitasnutricionais.dtos.NutricionistaResponseDTO
import br.upf.receitasnutricionais.model.Nutricionista
import org.springframework.stereotype.Component

@Component
class NutricionistaConverter {
    fun toNutri(dto: NutricionistaDTO): Nutricionista {
        return Nutricionista(
                nome = dto.nome,
                inicio_programa = dto.inicio_programa,
                fim_programa = dto.fim_programa,
                consultas = listOf()
        )
    }

    fun toNutricionistaResponseDTO(nutricionista: Nutricionista): NutricionistaResponseDTO {
        return NutricionistaResponseDTO(
                id = nutricionista.id,
                nome = nutricionista.nome,
                inicio_programa = nutricionista.inicio_programa,
                fim_programa = nutricionista.fim_programa
        )
    }
}