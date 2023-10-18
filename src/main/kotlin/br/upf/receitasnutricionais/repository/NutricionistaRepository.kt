package br.upf.receitasnutricionais.repository

import br.upf.receitasnutricionais.model.Nutricionista
import org.springframework.stereotype.Repository

@Repository
class NutricionistaRepository (private var nutricionistas: MutableList<Nutricionista>) {
    private var idCont = 4L
    init {
        val nutricionista1 = Nutricionista(
                id = 1,
                nome = "Maria Gabriela",
                inicioPrograma = "12/06/2023",
                fimPrograma = "12/12/2023"
        )
        nutricionistas = mutableListOf(nutricionista1)
    }

    fun findAll() = nutricionistas

    fun cadastrar(nutricionista: Nutricionista){
        nutricionistas.add(nutricionista.copy(id = idCont++))
    }
}