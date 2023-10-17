package br.upf.receitasnutricionais.controller

import br.upf.receitasnutricionais.model.Nutricionista
import br.upf.receitasnutricionais.service.NutricionistaService
import org.apache.catalina.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/nutricionistas")
class NutricionistaController (val service: NutricionistaService){
    @GetMapping
    fun listar(): List<Nutricionista> {
        return service.listar()
    }
    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): Nutricionista {
        return service.buscarPorId(id)
    }
    @PostMapping
    fun cadastra(@RequestBody nutricionista: Nutricionista) {
         service.cadastrar(nutricionista)
    }
}