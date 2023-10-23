package br.upf.receitasnutricionais.service

import br.upf.receitasnutricionais.converters.ReceitaConverter
import br.upf.receitasnutricionais.dtos.NutricionistaResponseDTO
import br.upf.receitasnutricionais.dtos.ReceitasDTO
import br.upf.receitasnutricionais.dtos.ReceitasResponseDTO
import br.upf.receitasnutricionais.exceptions.NotFoundException
import br.upf.receitasnutricionais.model.Receita
import br.upf.receitasnutricionais.repository.ReceitaRepository
import org.springframework.stereotype.Service

@Service
class ReceitasService (private val repository: ReceitaRepository,
                       private val converter: ReceitaConverter){
    fun listar(): List<ReceitasResponseDTO> {
        return repository.findAll()
                .map(converter::toReceitaResponseDTO)
    }

    fun buscarPorId(id: Long): ReceitasResponseDTO {
       val receita = repository.findAll().firstOrNull { it.id == id}
               ?: throw NotFoundException("Receita não encontrada")
        return converter.toReceitaResponseDTO(receita)
    }

    fun cadastrar(dto: ReceitasDTO) : ReceitasResponseDTO {
       val receita = repository.cadastrar(converter.toReceita(dto))
       return converter.toReceitaResponseDTO(receita)
    }

    fun atualizar(id: Long, dto: ReceitasDTO): ReceitasResponseDTO {
        val receita = repository.findAll().firstOrNull{ it.id == id}
                ?: throw NotFoundException("Receita não encontrada")
        val receitaAtualizada = repository.update(receita, converter.toReceita(dto))
        return converter.toReceitaResponseDTO(receitaAtualizada)
    }

    fun deletar(id: Long) {
        repository.deletar(id)
    }
}