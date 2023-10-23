package br.upf.receitasnutricionais.exceptions

import java.lang.RuntimeException

class NotFoundException (override val message: String)
    : RuntimeException()