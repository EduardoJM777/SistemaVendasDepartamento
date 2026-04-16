package com.example.sistemavendasdepartamento.repository

import com.example.sistemavendasdepartamento.model.Pedido

object PedidoRepository {

    val listaPedidos = mutableListOf<Pedido>()

    private var contadorPedido = 0

    fun gerarNumeroPedido(): String {
        contadorPedido++
        return String.format("%05d", contadorPedido)
        // ex: "00001", "00002"...
    }

    fun totalGeral(): Double {
        return listaPedidos.sumOf { it.valTot }
    }

    fun somaItens(): Int {
        return listaPedidos.sumOf { it.qtd }
    }

}