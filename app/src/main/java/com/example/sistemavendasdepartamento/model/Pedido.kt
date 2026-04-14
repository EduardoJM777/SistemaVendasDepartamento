package com.example.sistemavendasdepartamento.model

data class Pedido(

    val cliente: Cliente,
    val item: Item,
    val qtd: Int,
    val valTot: Double

)
