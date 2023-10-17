package br.upf.receitasnutricionais.service

import br.upf.receitasnutricionais.model.Receita
import br.upf.receitasnutricionais.repository.ReceitaRepository
import org.springframework.stereotype.Service

@Service
class ReceitasService (private val repository: ReceitaRepository){
    fun listar(): List<Receita> {
        return repository.findAll()
    }

    fun buscarPorId(id: Long): Receita {
        return repository.findAll().first { it.id == id}
    }

    fun cadastrar(receita: Receita) {
       repository.cadastrar(receita);
    }
}