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
                inicioPrograma = dto.inicioPrograma,
                fimPrograma = dto.fimPrograma
        )
    }

    fun toNutricionistaResponseDTO(nutricionista: Nutricionista): NutricionistaResponseDTO {
        return NutricionistaResponseDTO(
                id = nutricionista.id,
                nome = nutricionista.nome,
                inicioPrograma = nutricionista.inicioPrograma,
                fimPrograma = nutricionista.fimPrograma
        )
    }
}