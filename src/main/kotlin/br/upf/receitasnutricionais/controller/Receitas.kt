package br.upf.receitasnutricionais.controller

import br.upf.receitasnutricionais.model.nutricionista
import br.upf.receitasnutricionais.model.receita
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/receitas")
class Receitas {
    @GetMapping
    fun listar(): List<receita> {
        val Receita = receita (
            id: 1,
            nome: "Creme de cacau",
            descricao: "2 avocados, 1 colher de sopa de cacau, suco de 1 limão, 2 colheres de sopa de mel ou açúcar mascavo ou adoçante culinário. Preparo: 1) Bata tudo no mixer ou liquidificador. 2) Coloque em taças e leve para gelar por 1 hora antes de consumir."
        )
        return listOf(receita)
    }
}