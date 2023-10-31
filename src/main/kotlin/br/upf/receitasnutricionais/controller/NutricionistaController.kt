package br.upf.receitasnutricionais.controller

import br.upf.receitasnutricionais.dtos.NutricionistaDTO
import br.upf.receitasnutricionais.dtos.NutricionistaResponseDTO
import br.upf.receitasnutricionais.model.Nutricionista
import br.upf.receitasnutricionais.service.NutricionistaService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.apache.catalina.Service
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriBuilder
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/nutricionistas")
class NutricionistaController(val service: NutricionistaService) {
    @GetMapping
    fun listar(
            @RequestParam(required = false) nomeNutricionista: String?,
            paginacao: Pageable
    ): Page<NutricionistaResponseDTO> {
        return service.listar(nomeNutricionista, paginacao)
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): NutricionistaResponseDTO {
        return service.buscarPorId(id)
    }

    @PostMapping
    @Transactional
    fun cadastrar(
            @RequestBody @Valid dto: NutricionistaDTO,
            uriBuilder: UriComponentsBuilder
    ): ResponseEntity<NutricionistaResponseDTO> {
        val nutricionistaResponse = service.cadastrar(dto)
        val uri = uriBuilder.path("/nutricionistas/${nutricionistaResponse.id}")
                .build().toUri()
        return ResponseEntity.created(uri).body(nutricionistaResponse)
    }

    @PutMapping("/{id}")
    @Transactional
    fun atualizar(@PathVariable id: Long, @RequestBody @Valid dto: NutricionistaDTO): NutricionistaResponseDTO {
        return service.atualizar(id, dto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }
}