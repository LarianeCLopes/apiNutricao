package br.upf.receitasnutricionais.controller

import br.upf.receitasnutricionais.dtos.NutricionistaDTO
import br.upf.receitasnutricionais.dtos.NutricionistaResponseDTO
import br.upf.receitasnutricionais.model.Nutricionista
import br.upf.receitasnutricionais.service.NutricionistaService
import jakarta.validation.Valid
import org.apache.catalina.Service
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
import org.springframework.web.util.UriBuilder
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/nutricionistas")
class NutricionistaController (val service: NutricionistaService){
    @GetMapping
    fun listar(): List<NutricionistaResponseDTO> {
        return service.listar()
    }
    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): NutricionistaResponseDTO {
        return service.buscarPorId(id)
    }
    @PostMapping
    fun cadastra(@RequestBody @Valid dto: NutricionistaDTO,
                 uriBuilder: UriComponentsBuilder): ResponseEntity<NutricionistaResponseDTO> {
        val nutricionistaReponse = service.cadastrar(dto)
        val uri = uriBuilder.path("/nutricionistas/${nutricionistaReponse.id}").build().toUri()
        return ResponseEntity.created(uri).body(nutricionistaReponse)
    }

    @PutMapping("/{id}")
    fun atualizar (@PathVariable id: Long, @RequestBody @Valid dto: NutricionistaDTO
    ): NutricionistaResponseDTO {
        return service.atualizar(id, dto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }
}