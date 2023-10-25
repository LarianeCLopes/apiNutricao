package br.upf.receitasnutricionais.service

import br.upf.receitasnutricionais.converters.ReceitaConverter
import br.upf.receitasnutricionais.dtos.ReceitasDTO
import br.upf.receitasnutricionais.dtos.ReceitasResponseDTO
import br.upf.receitasnutricionais.exceptions.NotFoundException
import br.upf.receitasnutricionais.repository.ReceitaRepository
import org.springframework.stereotype.Service

private const val RECEITA_NOT_FOUND_MESSAGE = "Receita não encontrado!"
@Service
class ReceitasService (private val repository: ReceitaRepository,
                       private val converter: ReceitaConverter
) {
    fun listar(): List<ReceitasResponseDTO> {
        return repository.findAll()
            .map(converter::toReceitaResponseDTO)
    }

    fun buscarPorId(id: Long): ReceitasResponseDTO {
        val receita = repository.findById(id)
            .orElseThrow { NotFoundException(RECEITA_NOT_FOUND_MESSAGE) }
        return converter.toReceitaResponseDTO(receita)
    }

    fun cadastrar(dto: ReceitasDTO): ReceitasResponseDTO {
        return converter.toReceitaResponseDTO(
            repository.save(converter.toReceita(dto)))
    }

    fun atualizar(id: Long, dto: ReceitasDTO): ReceitasResponseDTO {
        val receita = repository.findById(id)
            .orElseThrow { NotFoundException(RECEITA_NOT_FOUND_MESSAGE) }
            .copy(
                nome = dto.nome,
                descricao = dto.descricao

            )
        return converter.toReceitaResponseDTO(repository.save(receita))
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }

}