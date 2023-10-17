package br.upf.receitasnutricionais.controller

import br.upf.receitasnutricionais.model.Usuario
import br.upf.receitasnutricionais.service.UsuariosService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/usuarios")
class UsuarioController (val service: UsuariosService){
    @GetMapping
    fun listar(): List<Usuario> {
        return service.listar()
    }
    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id:Long): Usuario {
        return service.buscaPorId(id)
    }

    @PostMapping
    fun cadastra(@RequestBody usuario: Usuario) {
        service.cadastrar(usuario)
    }
}