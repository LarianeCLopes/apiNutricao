package br.upf.receitasnutricionais.service

import br.upf.receitasnutricionais.model.Nutricionista
import br.upf.receitasnutricionais.repository.NutricionistaRepository
import org.springframework.stereotype.Service

@Service
class NutricionistaService(private val repository: NutricionistaRepository) {
    fun listar(): List<Nutricionista> {
        return repository.findAll()
    }

    fun buscarPorId(id: Long): Nutricionista {
        return repository.findAll().first {it.id == id}
    }

    fun cadastrar(nutricionista: Nutricionista) {
        repository.cadastrar(nutricionista);
    }
}