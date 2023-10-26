package br.upf.receitasnutricionais.controller

import br.upf.receitasnutricionais.dtos.UsuarioDTO
import br.upf.receitasnutricionais.dtos.UsuarioResponseDTO
import br.upf.receitasnutricionais.model.Usuario
import br.upf.receitasnutricionais.service.UsuariosService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import java.awt.print.Pageable

@RestController
@RequestMapping("/usuarios")
class UsuarioController (val service: UsuariosService){
    @GetMapping
    fun listar(@RequestParam(required = false) nomeUsuario: String?,
            @PageableDefault(size = 10)   paginacao: Pageable)
    : Page<UsuarioResponseDTO> {
        return service.listar(nomeUsuario, paginacao)
    }
    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id:Long): UsuarioResponseDTO {
        return service.buscaPorId(id)
    }

    @PostMapping
    @Transactional
    fun cadastra(@RequestBody @Valid dto: UsuarioDTO,
        uriBuilder: UriComponentsBuilder): ResponseEntity<UsuarioResponseDTO> {
            val usuarioResponse = service.cadastrar(dto)
            val uri = uriBuilder.path("/usuarios/${usuarioResponse.id}").build().toUri()
            return ResponseEntity.created(uri).body(usuarioResponse)
    }

    @PutMapping("/{id}")
    @Transactional
    fun atualizar(@PathVariable id: Long, @RequestBody @Valid dto: UsuarioDTO
    ): UsuarioResponseDTO {
        return service.atualizar(id, dto)
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }
}