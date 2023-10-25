package br.upf.receitasnutricionais.controller

import br.upf.receitasnutricionais.dtos.NutricionistaResponseDTO
import br.upf.receitasnutricionais.dtos.ReceitasDTO
import br.upf.receitasnutricionais.dtos.ReceitasResponseDTO
import br.upf.receitasnutricionais.model.Receita
import br.upf.receitasnutricionais.service.ReceitasService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

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
    @Transactional
    fun cadastrar(@RequestBody @Valid dto: ReceitasDTO,
                 uriBuilder: UriComponentsBuilder): ResponseEntity<ReceitasResponseDTO> {
        val receitasResponse = service.cadastrar(dto)
        val uri = uriBuilder.path("/receitas/${receitasResponse.id}")
            .build().toUri()
        return ResponseEntity.created(uri).body(receitasResponse)
    }

    @PutMapping("/{id}")
    @Transactional
    fun atualizar(@PathVariable id: Long, @RequestBody @Valid dto: ReceitasDTO
    ): ReceitasResponseDTO {
        return service.atualizar(id, dto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }
}