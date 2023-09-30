package br.upf.receitasnutricionais.controller

import br.upf.receitasnutricionais.model.usuario
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/usuario")
class usuario {
    @GetMapping
    fun listar(): List<usuario> {
        val Usuario = usuario(
            id = 1,
            nome = "Ana Clara",
            telefone = "99999-9999"
        )
        return listOf(usuario)
    }
}