package br.upf.receitasnutricionais.controller

import br.upf.receitasnutricionais.service.TokenService
import br.upf.receitasnutricionais.dtos.LoginDTO
import br.upf.receitasnutricionais.dtos.LoginResponseDTO
import br.upf.receitasnutricionais.dtos.UsuarioDTO
import br.upf.receitasnutricionais.model.Usuario
import br.upf.receitasnutricionais.service.UsuariosService
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("auth")
class AuthenticationController(
        val authenticationManager: AuthenticationManager,
        val service: UsuariosService,
        val tokenService: TokenService) {

    @PostMapping("/login")
    fun login(@RequestBody data: LoginDTO): ResponseEntity<LoginResponseDTO> {
        val userPassword = UsernamePasswordAuthenticationToken(
                data.login, data.password)
        val auth = authenticationManager.authenticate(userPassword)
        val token = tokenService.generateToken(auth.principal as Usuario)
        return ResponseEntity.ok(LoginResponseDTO(token))
    }

    @PostMapping("/register")
    fun login(@RequestBody data: UsuarioDTO): ResponseEntity<String> {
        service.cadastrar(data)
        return ResponseEntity.ok().build()
    }
}