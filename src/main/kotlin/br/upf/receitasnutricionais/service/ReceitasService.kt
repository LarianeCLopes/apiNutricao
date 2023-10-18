package br.upf.receitasnutricionais.service

import br.upf.receitasnutricionais.converters.ReceitaConverter
import br.upf.receitasnutricionais.dtos.ReceitasDTO
import br.upf.receitasnutricionais.dtos.ReceitasResponseDTO
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
       val receita = repository.findAll().first { it.id == id}
        return converter.toReceitaResponseDTO(receita)
    }

    fun cadastrar(receita: ReceitasDTO) {
       repository.cadastrar(converter.toReceita(receita));
    }
}