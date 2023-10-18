package br.upf.receitasnutricionais.service

import br.upf.receitasnutricionais.converters.NutricionistaConverter
import br.upf.receitasnutricionais.dtos.NutricionistaDTO
import br.upf.receitasnutricionais.dtos.NutricionistaResponseDTO
import br.upf.receitasnutricionais.model.Nutricionista
import br.upf.receitasnutricionais.repository.NutricionistaRepository
import org.springframework.stereotype.Service

@Service
class NutricionistaService(private val repository: NutricionistaRepository, private val converter: NutricionistaConverter) {
    fun listar(): List<NutricionistaResponseDTO> {
        return repository.findAll()
                .map(converter::toNutricionistaResponseDTO)
    }

    fun buscarPorId(id: Long): NutricionistaResponseDTO {
        val nutricionista = repository.findAll().first {it.id == id}
        return converter.toNutricionistaResponseDTO(nutricionista)
    }

    fun cadastrar(nutricionista: NutricionistaDTO) {
        repository.cadastrar(converter.toNutri(nutricionista));
    }
}