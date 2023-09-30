package br.upf.receitasnutricionais.controller

import br.upf.receitasnutricionais.model.nutricionista
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
@RequestMapping("/nutricionista")
class NutricionistaController {
    @GetMapping
    fun listar(): List<nutricionista> {
        val Nutricionista = nutricionista(
            id = 1,
            nome = "Maria Gabriela",
            inicioPrograma = "12/06/2023",
            fimPrograma = "12/12/2023"
        )
        return listOf(nutricionista)
    }
}