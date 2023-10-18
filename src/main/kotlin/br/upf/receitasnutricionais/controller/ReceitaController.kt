package br.upf.receitasnutricionais.controller

import br.upf.receitasnutricionais.dtos.ReceitasDTO
import br.upf.receitasnutricionais.dtos.ReceitasResponseDTO
import br.upf.receitasnutricionais.model.Receita
import br.upf.receitasnutricionais.service.ReceitasService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/receitas")
class ReceitaController (val service: ReceitasService){
    @GetMapping
    fun listar(): List<ReceitasResponseDTO> {
        return service.listar()
    }
    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id:Long): ReceitasResponseDTO {
        return service.buscarPorId(id)
    }
    @PostMapping
    fun cadastra(@RequestBody dto: ReceitasDTO) {
        service.cadastrar(dto)
    }
}