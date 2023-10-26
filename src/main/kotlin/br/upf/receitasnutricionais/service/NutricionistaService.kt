package br.upf.receitasnutricionais.service

import br.upf.receitasnutricionais.converters.NutricionistaConverter
import br.upf.receitasnutricionais.dtos.NutricionistaDTO
import br.upf.receitasnutricionais.dtos.NutricionistaResponseDTO
import br.upf.receitasnutricionais.exceptions.NotFoundException
import br.upf.receitasnutricionais.repository.NutricionistaRepository
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service
import java.awt.print.Pageable

private const val NUTRICIONISTA_NOT_FOUND_MESSAGE = "Nutricionista não encontrado!"

@Service
class NutricionistaService(private val repository: NutricionistaRepository, private val converter: NutricionistaConverter) {
    fun listar(nomeNutricionista: String?, paginacao: Pageable): Page<NutricionistaResponseDTO> {
        val nutricionistas = if (nomeNutricionista == null){
            repository.findAll(paginacao)
        } else {
            repository.findByNome(nomeNutricionista, paginacao)
        }
        return nutricionistas.map(converter::toNutricionistaResponseDTO)
    }

    fun buscarPorId(id: Long): NutricionistaResponseDTO {
        val nutricionista = repository.findById(id)
                .orElseThrow{NotFoundException(NUTRICIONISTA_NOT_FOUND_MESSAGE)}
        return converter.toNutricionistaResponseDTO(nutricionista)
    }
    fun cadastrar(dto: NutricionistaDTO): NutricionistaResponseDTO {
        return converter.toNutricionistaResponseDTO(
                repository.save(converter.toNutri(dto))
        )
    }
    fun atualizar(id: Long, dto: NutricionistaDTO): NutricionistaResponseDTO{
        val nutricionista = repository.findById(id)
                .orElseThrow{NotFoundException(NUTRICIONISTA_NOT_FOUND_MESSAGE)}
                .copy(
                        nome = dto.nome,
                        inicio_programa = dto.inicio_programa,
                        fim_programa = dto.fim_programa
                )
        return converter.toNutricionistaResponseDTO(repository.save(nutricionista))
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }
}