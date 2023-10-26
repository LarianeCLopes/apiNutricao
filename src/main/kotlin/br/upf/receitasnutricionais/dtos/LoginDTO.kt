package br.upf.receitasnutricionais.dtos

import org.springframework.context.annotation.Bean
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

data class LoginDTO(val login: String, val password: String)

@Bean
fun authenticationManager(
        authenticationConfiguration: AuthenticationConfiguration
): AuthenticationManager {
    return authenticationConfiguration.authenticationManager
}
@Bean
fun passwordEncoder(): PasswordEncoder {
    return BCryptPasswordEncoder()
}

