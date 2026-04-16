package com.example.sistemavendasdepartamento.repository

import com.example.sistemavendasdepartamento.model.Item

object ItemRepository {

    val listaItem = mutableListOf<Item>()

    private var contadorCodigo = 0

    private fun gerarCodigo(): String {
        contadorCodigo++
        return String.format("%03d", contadorCodigo)
    }

    fun adicionar(descricao: String, valorUnitario: Double): Item {
        val novoItem = Item(
            codigo = gerarCodigo(),
            descricao = descricao,
            valorUnitario = valorUnitario
        )
        listaItem.add(novoItem)
        return novoItem
    }

    fun buscarPorCodigo(codigo: String): Item? {
        return listaItem.find { it.codigo == codigo }
    }
}