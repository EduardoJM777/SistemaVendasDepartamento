package com.example.sistemavendasdepartamento.repository

import com.example.sistemavendasdepartamento.model.Pedido

object PedidoRepository {

    val listaPedidos = mutableListOf<Pedido>()

    fun totalGeral(): Double {
        return listaPedidos.sumOf { it.valTot }
    }

    fun somaItens(): Int {
        return listaPedidos.sumOf { it.qtd }
    }

}