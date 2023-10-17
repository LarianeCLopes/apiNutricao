package br.upf.receitasnutricionais.repository

import br.upf.receitasnutricionais.model.Receita
import org.springframework.stereotype.Repository

@Repository
class ReceitaRepository (private  var receitas: MutableList<Receita>) {

    init {
        val receita1 = Receita(
                id = 1,
                nome = "Creme de cacau",
                descricao = "2 avocados, 1 colher de sopa de cacau, suco de 1 limão, 2 colheres de sopa de mel ou açúcar mascavo ou adoçante culinário. Preparo: 1) Bata tudo no mixer ou liquidificador. 2) Coloque em taças e leve para gelar por 1 hora antes de consumir."
        )
        receitas = mutableListOf(receita1)
    }
    fun findAll() = receitas

    fun cadastrar(receita: Receita){
        receitas.add(receita)
    }
}