package br.upf.receitasnutricionais.service

import br.upf.receitasnutricionais.converters.NutricionistaConverter
import br.upf.receitasnutricionais.dtos.NutricionistaDTO
import br.upf.receitasnutricionais.dtos.NutricionistaResponseDTO
import br.upf.receitasnutricionais.exceptions.NotFoundException
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
        val nutricionista = repository.findAll().firstOrNull {it.id == id}
                ?: throw NotFoundException("Nutricionista não encontrada")
        return converter.toNutricionistaResponseDTO(nutricionista)
    }

    fun cadastrar(dto: NutricionistaDTO): NutricionistaResponseDTO {
        val nutricionista = repository.cadastrar(converter.toNutri(dto))
        return converter.toNutricionistaResponseDTO(nutricionista)
    }

    fun atualizar(id: Long, dto: NutricionistaDTO): NutricionistaResponseDTO{
        val nutricionista = repository.findAll().firstOrNull { it.id == id}
                ?: throw NotFoundException("Nutricionista não encontrada")
        val nutriAtualizada = repository.update(nutricionista, converter.toNutri(dto))
        return converter.toNutricionistaResponseDTO(nutriAtualizada)
    }

    fun deletar(id: Long) {
        repository.deletar(id)
    }
}